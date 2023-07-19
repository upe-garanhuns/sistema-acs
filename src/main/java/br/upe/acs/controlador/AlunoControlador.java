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
    
    @Operation(summary = "Recuperar senha")
    @GetMapping("/recuperar-senha")
    public ResponseEntity<?> recuperarSenha(@RequestParam("email") String email) {
        Aluno aluno = servico.buscarAlunoPorEmail(email).orElse(null);

        if (aluno != null) {
            String token = TokenUtils.gerarToken();
            LocalDateTime dataExpiracao = LocalDateTime.now().plusMinutes(5);

            EmailUtils.enviarEmailRecuperacaoSenha(aluno.getEmail(), token);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
    

    @Operation(summary = "Redefinir senha")
    @PostMapping("/recuperar-senha")
    public ResponseEntity<?> redefinirSenha(
            @RequestParam("token") String token,
            @RequestParam("novaSenha") String novaSenha,
            @RequestParam("confirmarNovaSenha") String confirmarNovaSenha) {

        Aluno aluno = servico.buscarAlunoPorToken(token).orElse(null);

        if (aluno != null && aluno.getDataExpiracaoToken().isAfter(LocalDateTime.now())) {
            if (novaSenha.equals(confirmarNovaSenha)) {
                if (novaSenha.length() >= 8 && novaSenha.length() <= 16) {
                    aluno.setSenha(novaSenha);
                    aluno.setTokenRecuperacaoSenha(null);
                    aluno.setDataExpiracaoToken(null);
                    servico.salvarAluno(aluno);

                    return ResponseEntity.ok().build();
                } else {
                    return ResponseEntity.badRequest().build();
                }
            } else {
                return ResponseEntity.badRequest().build();
            }
        }

        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Listar todas as requisições do aluno")
    @GetMapping("/requisicao/paginacao")
    public  ResponseEntity<?> listarRequisicaoAlunoPaginacao(
            HttpServletRequest request,
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int quantidade
    ) {
        ResponseEntity<?> resposta;
        try {
            String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
            resposta = ResponseEntity.ok(servico.requisicoesAlunoPaginada(email, pagina, quantidade));

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
