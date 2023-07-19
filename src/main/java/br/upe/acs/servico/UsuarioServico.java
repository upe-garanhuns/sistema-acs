package br.upe.acs.servico;

import br.upe.acs.dominio.Aluno;
import br.upe.acs.repositorio.AlunoRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServico {
    private final AlunoRepositorio repositorio;

    public Optional<Aluno> buscarUsuarioPorId(Long id) throws AcsExcecao {
        if (repositorio.findById(id).isEmpty()) {
            throw new AcsExcecao("Não existe um usuário associado a este id!");
        }

        return repositorio.findById(id);
    }

    public String verificarUsuario(Long usuarioId, String codigoVerificacao) throws AcsExcecao {
        Aluno usuario = buscarUsuarioPorId(usuarioId).orElseThrow();
        String resposta;

        if (usuario.isVerificado()) {
            resposta = "Este usuário já é verificado!";
        } else if (codigoVerificacao.equals(usuario.getCodigoVerificacao())) {
            usuario.setVerificado(true);
            repositorio.save(usuario);
            resposta = "Aluno verificado com sucesso!";
        } else {
            resposta = "O código de verificação está incorreto!";
        }

        return resposta;
    }
}
