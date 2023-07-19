package br.upe.acs.repositorio;

import br.upe.acs.dominio.RequisicaoRascunho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequisicaoRascunhoRepositorio extends JpaRepository<RequisicaoRascunho, Long> {
    List<RequisicaoRascunho> findRequisicaoRascunhoByUsuarioId(Long UsuarioId);
}
