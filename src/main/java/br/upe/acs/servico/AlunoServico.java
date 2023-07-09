package br.upe.acs.servico;

import br.upe.acs.dominio.Aluno;
import br.upe.acs.repositorio.AlunoRepositorio;
import br.upe.acs.utils.AcsExcecao;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunoServico {

	private final AlunoRepositorio repositorio;

	public Optional<Aluno> buscarAlunoPorId(Long id) throws AcsExcecao {
		if (repositorio.findById(id).isEmpty()) {
			throw new AcsExcecao("Não existe um usuário associado a este id!");
		}

		return repositorio.findById(id);
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
}
