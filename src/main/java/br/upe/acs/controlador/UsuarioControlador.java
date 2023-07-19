package br.upe.acs.controlador;

import br.upe.acs.controlador.respostas.UsuarioResposta;
import br.upe.acs.dominio.dto.AlterarSenhaDTO;
import br.upe.acs.servico.ControleAcessoServico;
import br.upe.acs.servico.UsuarioServico;
import br.upe.acs.utils.AcsExcecao;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuario")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioControlador {

    private final UsuarioServico servico;

    private final ControleAcessoServico controleAcessoServico;

    @Operation(summary = "Retornar dados de perfil do usuário")
    @GetMapping("/me")
    public ResponseEntity<?> retornarPerfilDoUsuario(HttpServletRequest request,
                                                     @RequestParam(value = "usuarioId") Long id,
                                                     @RequestParam(value = "codigoDeVerificacao") String codigo) {

        ResponseEntity<?> resposta;
        String token = request.getHeader("Authorization").substring(7);
        try {
            var usuarioResposta = new UsuarioResposta(servico.buscarUsuarioPorId(id).orElseThrow());
            if (!usuarioResposta.isVerificado()) {
                resposta = new ResponseEntity<>("Usuário não verificado.", HttpStatus.FORBIDDEN);
            } else {
                resposta = ResponseEntity.ok(usuarioResposta);
            }
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }

    @Operation(summary = "Verificar usuário")
    @PostMapping("/verificacao")
    public ResponseEntity<?> verificarUsuario(@RequestParam(value = "usuarioId") Long id,
                                            @RequestParam(value = "codigoDeVerificacao") String codigo) {
        ResponseEntity<?> resposta;
        try {
            resposta = ResponseEntity.ok(servico.verificarUsuario(id, codigo));
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }

    @Operation(summary = "Alterar senha do usuário")
    @PatchMapping
    public ResponseEntity<?> alterarSenha(
            HttpServletRequest request,
            @RequestBody AlterarSenhaDTO alterarSenhaDTO
            ) {
        String token = request.getHeader("Authorization").substring(7);
        ResponseEntity<?> resposta;
        try {
            controleAcessoServico.alterarSenha(token, alterarSenhaDTO.getSenha(), alterarSenhaDTO.getNovaSenha());
            resposta = ResponseEntity.noContent().build();
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }

}