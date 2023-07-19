package br.upe.acs.servico;

import br.upe.acs.dominio.Aluno;
import br.upe.acs.dominio.RequisicaoRascunho;
import br.upe.acs.repositorio.RequisicaoRascunhoRepositorio;
import br.upe.acs.utils.AcsExcecao;
import br.upe.acs.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequisicaoRascunhoServico {
    private final RequisicaoRascunhoRepositorio repositorio;
    
    private final AlunoServico alunoServico;
    
	private final JwtService jwtService;

	public List<RequisicaoRascunho> buscarRequisicaoRascunhoPorAluno(Long id) {
		return repositorio.findRequisicaoRascunhoByUsuarioId(id);
	}

    public Optional<RequisicaoRascunho> buscarRequisicaoRascunhoPorId(Long id) throws AcsExcecao {
        if (repositorio.findById(id).isEmpty()) {
            throw new AcsExcecao("Não existe uma requisição associada a este id!");
        }

        return repositorio.findById(id);
    }
    
    public void deletarRequisicaoRascunho(Long id, String token) throws AcsExcecao {
    	RequisicaoRascunho rascunho = buscarRequisicaoRascunhoPorId(id).orElseThrow();

    	String usuario = jwtService.extractUsername(token);
    	Aluno autor =  alunoServico.buscarAlunoPorId(rascunho.getUsuarioId()).orElseThrow();
    	
    	if(!Objects.equals(usuario, autor.getEmail())) {
    		throw new AcsExcecao("Você não possui permissão para excluir esse rascunho");    		
    	};
    	
    	if(!autor.isVerificado()) {
    		throw new AcsExcecao("Usuário não verificado");    	
    	}
    	
    	
    	repositorio.delete(rascunho);
    	
    }
}
