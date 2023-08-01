package br.upe.acs.controlador;

import br.upe.acs.config.JwtService;
import br.upe.acs.controlador.respostas.AlunoResposta;
import br.upe.acs.dominio.Aluno;
import br.upe.acs.utils.AcsExcecao;
import br.upe.acs.utils.EmailUtils;
import br.upe.acs.utils.TokenUtils;
import io.swagger.v3.oas.annotations.Operation;

import java.time.LocalDateTime;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.upe.acs.servico.AlunoServico;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/aluno")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AlunoControlador {

    private final AlunoServico servico;
    private final JwtService jwtService;

    @Operation(summary = "Buscar aluno por id")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAlunoPorId(@PathVariable("id") Long id) {
        ResponseEntity<?> resposta;
        try {
			AlunoResposta alunoResposta = new AlunoResposta(servico.buscarAlunoPorId(id).orElseThrow());
			resposta = ResponseEntity.ok(alunoResposta);
		} catch (AcsExcecao e) {
			resposta = ResponseEntity.badRequest().body(e.getMessage());
		}

        return resposta;
    }

    @Operation(summary = "Verificar aluno")
    @PostMapping("/verificacao")
    public ResponseEntity<?> verificarAluno(@RequestParam(value = "usuarioId") Long alunoId,
                                              @RequestParam(value = "codigoVerificacao") String codigo) {
        ResponseEntity<?> resposta;
        try {
            resposta = ResponseEntity.ok(servico.verificarAluno(alunoId, codigo));
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }

    @Operation(summary = "Carga horaria dos alunos")
    @GetMapping("/horas")
    public ResponseEntity<?> atividadesComplementaresAluno(HttpServletRequest request) {
        ResponseEntity<?> resposta;
        try {
            String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
            resposta = ResponseEntity.ok(servico.atividadesComplementaresAluno(email));
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }


}
