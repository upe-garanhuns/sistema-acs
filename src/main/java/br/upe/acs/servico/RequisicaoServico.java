package br.upe.acs.servico;

import br.upe.acs.controlador.respostas.RequisicaoSimplesResposta;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.Certificado;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.enums.CertificadoStatusEnum;
import br.upe.acs.dominio.enums.RequisicaoStatusEnum;
import br.upe.acs.repositorio.CertificadoRepositorio;
import br.upe.acs.repositorio.RequisicaoRepositorio;
import br.upe.acs.utils.AcsExcecao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.*;

@Service
public class RequisicaoServico {

	private final RequisicaoRepositorio repositorio;
	private final UsuarioServico usuarioServico;
	private final TemplateEngine templateEngine;
	private final CertificadoRepositorio certificadoRepositorio;

	public RequisicaoServico(RequisicaoRepositorio repositorio, UsuarioServico usuarioServico, TemplateEngine templateEngine, CertificadoRepositorio certificadoRepositorio) {
		this.repositorio = repositorio;
		this.usuarioServico = usuarioServico;
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateEngine.setTemplateResolver(templateResolver);
		this.templateEngine = templateEngine;
		this.certificadoRepositorio = certificadoRepositorio;
	}

	public Map<String, Object> listarRequisicoesPaginadas(int pagina, int quantidade) {
		Pageable paginaFormato = PageRequest.of(pagina, quantidade);

		Page<Requisicao> requisicoesPagina = repositorio.findAll(paginaFormato);

		return gerarPaginacao(requisicoesPagina);
	}

	public Requisicao buscarRequisicaoPorId(Long id) throws AcsExcecao {
		Optional<Requisicao> requisicao = repositorio.findById(id);
		if (requisicao.isEmpty()) {
			throw new AcsExcecao("Não existe uma requisição associada a este id!");
		}

		return requisicao.get();
	}

	public Long adicionarRequisicao(String email) throws AcsExcecao {
		Usuario aluno = usuarioServico.buscarUsuarioPorEmail(email);
		List <Requisicao> requisicoesRacunhos = aluno.getRequisicoes().stream()
				.filter(requisicao -> requisicao.getStatusRequisicao().equals(RequisicaoStatusEnum.RASCUNHO)).toList();
		if (requisicoesRacunhos.size() >= 2) {
			throw new AcsExcecao("aluno só pode possuir 2 requisições em rascunho!");
		}

		Requisicao requisicao = new Requisicao();
		requisicao.setStatusRequisicao(RequisicaoStatusEnum.RASCUNHO);
		requisicao.setCriacao(new Date());
		requisicao.setUsuario(aluno);
		requisicao.setCurso(aluno.getCurso());
		Requisicao requisicaoSalva = repositorio.save(requisicao);
		return requisicaoSalva.getId();
	}

	public byte[] gerarRequisicaoPDF(Long id) throws AcsExcecao {
		Requisicao requisicao = buscarRequisicaoPorId(id);

		if (requisicao.getStatusRequisicao() != RequisicaoStatusEnum.TRANSITO) {
			throw new AcsExcecao("Não possivel gerar um pdf de uma requisição que não esteja trânsito!");
		}

		Context contexto = definirValoresTemplateHTML(requisicao);

		String htmlDoDocumento = templateEngine.process("requisicao.html", contexto);
		Path pathDoPdf = Paths.get("src/main/resources/requisicao" + id +".pdf");

		try (FileOutputStream outputStream = new FileOutputStream("src/main/resources/requisicao" + id +".pdf")) {
			ITextRenderer renderer = new ITextRenderer();
			SharedContext sharedContext = renderer.getSharedContext();
			sharedContext.setPrint(true);
			sharedContext.setInteractive(false);
			renderer.setDocumentFromString(htmlDoDocumento);
			renderer.layout();
			renderer.createPDF(outputStream);
			outputStream.close();

			byte[] arquivoPDF = Files.readAllBytes(pathDoPdf);
			Files.delete(pathDoPdf);
			return arquivoPDF;

		} catch (Exception e) {
			throw new AcsExcecao("Erro ao gerar o arquivo pdf!");
		}

	}

	public String submeterRequisicao(Long requisicaoId) throws AcsExcecao {
		Requisicao requisicao = buscarRequisicaoPorId(requisicaoId);

		if (requisicao.getStatusRequisicao() != RequisicaoStatusEnum.RASCUNHO) {
			throw new AcsExcecao("Essa requisição já foi submetido!");
		}

		if (requisicao.getCertificados().size()  < 1) {
			throw new AcsExcecao("Uma requisição precisa de pelo menos um certificado!");
		}
		List<Certificado> certificadosInvalidas = requisicao.getCertificados().stream()
				.filter(certificado -> !validarCertificado(certificado)).toList();
		if (!certificadosInvalidas.isEmpty()) {
			throw new AcsExcecao(
					"Certificados: " + String.join( "; ", certificadosInvalidas.stream()
							.map(certificado -> certificado.getId().toString()).toList())
							+ " possuem dados inválidos."
			);
		}
		String token = gerarTokenRequisicao();
		requisicao.setToken(token);
		requisicao.setDataDeSubmissao(new Date());
		requisicao.setStatusRequisicao(RequisicaoStatusEnum.TRANSITO);
		modificarCertificados(requisicao.getCertificados());
		repositorio.save(requisicao);

		return token;
	}

	public void excluirRequisicao(Long requisicaoId, String email) throws AcsExcecao {
		Requisicao requisicao = buscarRequisicaoPorId(requisicaoId);
		if (!requisicao.getUsuario().getEmail().equals(email)) {
			throw new AcsExcecao("Usuário sem premissão para excluir esse requisição!");
		}

		if (!requisicao.getStatusRequisicao().equals(RequisicaoStatusEnum.RASCUNHO)) {
			throw new AcsExcecao("Um requisição já submetido não pode ser apagado!");
		}

		repositorio.deleteById(requisicaoId);
	}

	private Map<String, Object> gerarPaginacao (Page<Requisicao> pagina) {
		List<RequisicaoSimplesResposta> requisicoesConteudo = pagina.getContent().stream()
				.map(RequisicaoSimplesResposta::new).toList();

		Map<String, Object> resposta = new HashMap<>();
		resposta.put("requisicoes", requisicoesConteudo);
		resposta.put("paginaAtual", pagina.getNumber());
		resposta.put("totalItens", requisicoesConteudo.size());
		resposta.put("totalPaginas", pagina.getTotalPages());

		return resposta;
	}

	private Context definirValoresTemplateHTML(Requisicao requisicao) {
		Context contexto = new Context();

		contexto.setVariable("protocolo", requisicao.getToken());
		contexto.setVariable("cpf", requisicao.getUsuario().getCpf());
		contexto.setVariable("data", requisicao.getDataDeSubmissao().toString());
		contexto.setVariable("nome", requisicao.getUsuario().getNomeCompleto());
		contexto.setVariable("curso", requisicao.getUsuario().getCurso().getNome());
		contexto.setVariable("periodo", requisicao.getUsuario().getPeriodo());
		contexto.setVariable("rua", requisicao.getUsuario().getEndereco().getRua());
		contexto.setVariable("bairro", requisicao.getUsuario().getEndereco().getBairro());
		contexto.setVariable("numero", requisicao.getUsuario().getEndereco().getNumero());
		contexto.setVariable("cidade", requisicao.getUsuario().getEndereco().getCidade());
		contexto.setVariable("uf", requisicao.getUsuario().getEndereco().getUF());
		contexto.setVariable("cep", requisicao.getUsuario().getEndereco().getCep());
		contexto.setVariable("email", requisicao.getUsuario().getEmail());
		contexto.setVariable("telefone", requisicao.getUsuario().getTelefone());

		return contexto;
	}

	private boolean validarCertificado(Certificado certificado) {
		boolean isValid = true;

			if (certificado.getCertificado() == null){
				isValid = false;
			} else if (certificado.getTitulo() == null || certificado.getTitulo().isBlank()) {
				isValid = false;
			} else if (certificado.getDataInicial().after(new Date())) {
				isValid = false;
			} else if (certificado.getDataFinal().after(new Date())) {
				isValid = false;
			} else if (certificado.getCargaHoraria() <= 1) {
				isValid = false;
			} else if (certificado.getAtividade() == null) {
				isValid = false;
			}

			return isValid;
	}

	private String gerarTokenRequisicao() {
		String caracteres = "0123456789!@#$%.*";
		Random random = new Random();
		StringBuilder tokenParcial = new StringBuilder();

		for (int i = 0; i < 6; i++) {
			int index = random.nextInt(caracteres.length());
			tokenParcial.append(caracteres.charAt(index));
		}

		Instant timeStamp = Instant.now();
		long epocaSegundos = timeStamp.getEpochSecond();

		return tokenParcial + Long.toString(epocaSegundos);
	}

	private void modificarCertificados(List<Certificado> certificados) {
		for (Certificado certificado: certificados) {
			certificado.setStatusCertificado(CertificadoStatusEnum.ENCAMINHADO_COORDENACAO);
			certificadoRepositorio.save(certificado);
		}
	}

}
