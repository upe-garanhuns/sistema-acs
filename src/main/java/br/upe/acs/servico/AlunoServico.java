package br.upe.acs.servico;

import br.upe.acs.controlador.respostas.RequisicaoBaseResposta;
import br.upe.acs.dominio.Aluno;
import br.upe.acs.dominio.vo.AtividadeComplementarVO;
import br.upe.acs.repositorio.AlunoRepositorio;
import br.upe.acs.repositorio.RequisicaoRascunhoRepositorio;
import br.upe.acs.utils.AcsExcecao;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AlunoServico {

	private final AlunoRepositorio repositorio;
	private final RequisicaoRascunhoRepositorio requisicaoRascunhoRepositorio;

	public Optional<Aluno> buscarAlunoPorId(Long id) throws AcsExcecao {
		if (repositorio.findById(id).isEmpty()) {
			throw new AcsExcecao("Não existe um usuário associado a este id!");
		}

		return repositorio.findById(id);
	}

	public Aluno buscarAlunoPorEmail(String email) throws AcsExcecao {
		Optional<Aluno> aluno = repositorio.findByEmail(email);
		if (aluno.isEmpty()) {
			throw new AcsExcecao("Não existe um usuário associado a este email!");
		}

		return aluno.get();
	}
	
	public String verificarAluno(Long alunoId, String codigoVerificacao) throws AcsExcecao {
		Aluno usuario = buscarAlunoPorId(alunoId).orElseThrow();
		String resposta;

		if (usuario.isVerificado()) {
			resposta = "Este Aluno já é verificado!";
		} else if (codigoVerificacao.equals(usuario.getCodigoVerificacao())) {
			usuario.setVerificado(true);
			repositorio.save(usuario);
			resposta = "Aluno verificado com sucesso!";
		} else {
			resposta = "O código de verificação está incorreto!";
		}

		return resposta;
	}
	
    public Optional<Aluno> buscarAlunoPorEmail(String email) {
        return repositorio.findByEmail(email);
    }
    
    public Optional<Aluno> buscarAlunoPorToken(String token) {
        return repositorio.findByTokenRecuperacaoSenha(token);
    }
    
    public void salvarAluno(Aluno aluno) {
        repositorio.save(aluno);
    }

	public Map<String, Object> requisicoesAlunoPaginada(String email, int pagina, int quantidade) throws AcsExcecao {
		Aluno aluno = buscarAlunoPorEmail(email);
		Pageable paginaFormato = PageRequest.of(pagina, quantidade);
		List<RequisicaoBaseResposta> requisicoesAluno = new ArrayList<>(aluno.getRequisicoes()
				.stream().map(RequisicaoBaseResposta::new).toList());
		requisicoesAluno.addAll(requisicaoRascunhoRepositorio.findRequisicaoRascunhoByUsuarioId(aluno.getId())
				.stream().map(RequisicaoBaseResposta::new).toList());

		return gerarPaginacaoRequisicoes(requisicoesAluno, pagina, quantidade);
	}

	private Map<String, Object> gerarPaginacaoRequisicoes(List<RequisicaoBaseResposta> lista, int pagina, int quantidade) {
		Map<String, Object> resposta = new HashMap<>();
		resposta.put("requisicoes", gerarPaginacao(lista, pagina, quantidade));
		resposta.put("paginaAtual", pagina);
		resposta.put("totalItens", lista.size());
		resposta.put("totalPaginas", Math.floorDiv(lista.size(), quantidade) + (lista.size() % quantidade == 0? 0: 1));

		return resposta;
	}

	private <T> List<T> gerarPaginacao(List<T> lista, int pagina, int quantidade) {
		int inicio = pagina * quantidade;
		int fim = Math.min(inicio + quantidade, lista.size());

		if (inicio >= fim) {
			return Collections.emptyList();
		}

		return lista.subList(inicio, fim);
	}

	public AtividadeComplementarVO atividadesComplementaresAluno(String email) throws AcsExcecao {
		Aluno aluno = buscarAlunoPorEmail(email);

		return new AtividadeComplementarVO(aluno);
	}
}
