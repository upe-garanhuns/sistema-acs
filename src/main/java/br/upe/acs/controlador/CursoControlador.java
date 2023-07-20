package br.upe.acs.controlador;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.upe.acs.controlador.respostas.CursoResposta;
import br.upe.acs.servico.CursoServico;
import br.upe.acs.utils.AcsExcecao;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/curso")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CursoControlador {

	private final CursoServico servico;

	@Operation(summary = "Listar todos os cursos")
	@GetMapping
	public ResponseEntity<List<CursoResposta>> listarCursos() {
		return ResponseEntity.ok(
				servico.listarCursos().stream().map(CursoResposta::new).collect(Collectors.toList()));
	}

	@Operation(summary = "Buscar curso por id")
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarCursoPorId(@PathVariable("id") Long id) {
		ResponseEntity<?> resposta;
		try {
			CursoResposta cursoResposta = new CursoResposta(servico.buscarCursoPorId(id).orElseThrow());
			resposta =  ResponseEntity.ok(cursoResposta);
		} catch (AcsExcecao e) {
			resposta = ResponseEntity.badRequest().body(e.getMessage());
		}

		return resposta;
	}
}
