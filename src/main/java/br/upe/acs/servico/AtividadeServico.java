package br.upe.acs.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.upe.acs.dominio.Atividade;
import br.upe.acs.repositorio.AtividadeRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtividadeServico {

	private final AtividadeRepositorio repositorio;
	
	public List<Atividade> listarAtividades() {
		return repositorio.findAll();
	}
	
	public Atividade buscarAtividadePorId(Long id) throws AcsExcecao {
		Optional<Atividade> atividade = repositorio.findById(id);
		if (atividade.isEmpty()) {
			throw new AcsExcecao("Não existe uma atividade associada a este id!");
		}
		
		return atividade.get();
	}
}
