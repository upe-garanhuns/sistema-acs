package br.upe.acs.dominio;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class RequisicaoRascunho extends RequisicaoBase {

    private Long usuarioId;

    private Long cursoId;

    private Date dataCriacao;

    @Temporal(TemporalType.DATE)
    private Date dataExpiracao;

    @OneToMany(mappedBy = "requisicaoRascunho")
    private List<CertificadoRascunho> certificadosRascunho;
}
