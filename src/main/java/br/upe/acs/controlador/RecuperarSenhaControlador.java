package br.upe.acs.controlador;


import br.upe.acs.dominio.Aluno;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.servico.AlunoServico;
import br.upe.acs.utils.AcsExcecao;
import br.upe.acs.utils.EmailUtils;
import br.upe.acs.utils.RespostaPadrao;
import br.upe.acs.utils.TokenUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class RecuperarSenhaControlador {

    private final AlunoServico alunoServico;

    public RecuperarSenhaControlador(AlunoServico alunoServico) {
        this.alunoServico = alunoServico;
    }

    @GetMapping("/recuperar-senha")
    public ResponseEntity<RespostaPadrao> recuperarSenha(@RequestParam("email") String email) {
        try {
            Aluno aluno = alunoServico.buscarAlunoPorEmail(email);
            String token = TokenUtils.gerarToken();
            LocalDateTime dataExpiracao = LocalDateTime.now().plusMinutes(5);

            aluno.setTokenRecuperacaoSenha(token);
            aluno.setDataExpiracaoToken(dataExpiracao);
            alunoServico.salvarAluno(aluno);

            EmailUtils.enviarEmailRecuperacaoSenha(aluno.getEmail(), token);

            return ResponseEntity.ok(new RespostaPadrao(token));
        } catch (AcsExcecao e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/recuperar-senha")
    public ResponseEntity<RespostaPadrao> redefinirSenha(
            @RequestParam("token") String token,
            @RequestParam("novaSenha") String novaSenha,
            @RequestParam("confirmarNovaSenha") String confirmarNovaSenha) {
    	Optional<Aluno> alunoOptional = alunoServico.buscarAlunoPorToken(token);

        if (alunoOptional.isPresent()) {
            Usuario usuario = alunoOptional.get();
            if (usuario.isTokenRecuperacaoSenhaValido()) {
                if (novaSenha.equals(confirmarNovaSenha)) {
                    usuario.setSenha(novaSenha);
                    usuario.setTokenRecuperacaoSenha(null);
                    usuario.setDataExpiracaoToken(null);

                    alunoServico.salvarAluno((Aluno) usuario);

                    return ResponseEntity.ok(new RespostaPadrao("Senha redefinida com sucesso!"));
                } else {
                    return ResponseEntity.badRequest().body(new RespostaPadrao("A nova senha e a confirmação de senha não coincidem."));
                }
            }
        }

        return ResponseEntity.notFound().build();
    }
}
