package br.upe.acs.repositorio;

import br.upe.acs.dominio.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepositorio extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByEmail(String email);

    Optional<Aluno> findByCpf(String cpf);
    
    Optional<Aluno> findByTokenRecuperacaoSenha(String token);

}
