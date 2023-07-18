package br.upe.acs.servico;

import br.upe.acs.controlador.respostas.RequisicaoResposta;
import br.upe.acs.dominio.Aluno;
import br.upe.acs.dominio.Requisicao;
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
import java.util.*;

@Service
public class RequisicaoServico {

	private final RequisicaoRepositorio repositorio;
	private final AlunoServico alunoServico;
	private final TemplateEngine templateEngine;

	public RequisicaoServico(RequisicaoRepositorio repositorio, AlunoServico alunoServico, TemplateEngine templateEngine) {
		this.repositorio = repositorio;
		this.alunoServico = alunoServico;
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateEngine.setTemplateResolver(templateResolver);
		this.templateEngine = templateEngine;
	}

	public List<Requisicao> listarRequisicoes() {
		return repositorio.findAll();
	}

	public Map<String, Object> listarRequisicoesPaginadas(int pagina, int quantidade) {
		Pageable paginaFormato = PageRequest.of(pagina, quantidade);

		Page<Requisicao> requisicoesPagina = repositorio.findAll(paginaFormato);

		return gerarPaginacao(requisicoesPagina);
	}

	public List<Requisicao> listarRequisicoesPorAluno(Long alunoId) throws AcsExcecao {
		Aluno aluno = alunoServico.buscarAlunoPorId(alunoId).orElseThrow();
		return aluno.getRequisicoes();
	}

	public Requisicao buscarRequisicaoPorId(Long id) throws AcsExcecao {
		Optional<Requisicao> requisicao = repositorio.findById(id);
		if (requisicao.isEmpty()) {
			throw new AcsExcecao("Não existe uma requisição associada a este id!");
		}

		return requisicao.get();
	}

	private Map<String, Object> gerarPaginacao (Page<Requisicao> pagina) {
		List<RequisicaoResposta> requisicoesConteudo = pagina.getContent().stream()
				.map(RequisicaoResposta::new).toList();

		Map<String, Object> resposta = new HashMap<>();
		resposta.put("requisicoes", requisicoesConteudo);
		resposta.put("paginaAtual", pagina.getNumber());
		resposta.put("totalItens", requisicoesConteudo.size());
		resposta.put("totalPaginas", pagina.getTotalPages());

		return resposta;
	}

	public byte[] gerarRequisicaoPDF(Long id) throws AcsExcecao {
		Requisicao requisicao = buscarRequisicaoPorId(id);

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

	private Context definirValoresTemplateHTML(Requisicao requisicao) {
		Context contexto = new Context();

		contexto.setVariable("protocolo", requisicao.getToken());
		contexto.setVariable("cpf", requisicao.getAluno().getCpf());
		contexto.setVariable("data", requisicao.getDataDeSubmissao().toString());
		contexto.setVariable("nome", requisicao.getAluno().getNomeCompleto());
		contexto.setVariable("curso", requisicao.getAluno().getCurso().getNome());
		contexto.setVariable("periodo", requisicao.getAluno().getPeriodo());
		contexto.setVariable("rua", requisicao.getAluno().getEndereco().getRua());
		contexto.setVariable("bairro", requisicao.getAluno().getEndereco().getBairro());
		contexto.setVariable("numero", requisicao.getAluno().getEndereco().getNumero());
		contexto.setVariable("cidade", requisicao.getAluno().getEndereco().getCidade());
		contexto.setVariable("uf", requisicao.getAluno().getEndereco().getUF());
		contexto.setVariable("cep", requisicao.getAluno().getEndereco().getCep());
		contexto.setVariable("email", requisicao.getAluno().getEmail());
		contexto.setVariable("telefone", requisicao.getAluno().getTelefone());

		return contexto;
	}

}
