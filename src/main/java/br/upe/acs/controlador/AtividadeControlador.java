package br.upe.acs.controlador;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.upe.acs.controlador.respostas.AtividadeResposta;
import br.upe.acs.servico.AtividadeServico;
import br.upe.acs.utils.AcsExcecao;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/atividade")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AtividadeControlador {

    private final AtividadeServico servico;

    @Operation(summary = "Listar todas as atividades")
    @GetMapping
    public ResponseEntity<List<AtividadeResposta>> listarAtividades() {
        return ResponseEntity.ok(servico.listarAtividades().stream().map(AtividadeResposta::new)
                .collect(Collectors.toList()));
    }

    @Operation(summary = "Buscar atividade por id")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAtividadePorId(@PathVariable("id") Long id) {
        ResponseEntity<?> resposta;
        try {
            AtividadeResposta atividadeResposta = new AtividadeResposta(servico.buscarAtividadePorId(id));
            resposta = ResponseEntity.ok(atividadeResposta);
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }
}
