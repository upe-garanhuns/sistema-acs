package br.upe.acs.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class RequisicaoBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int semestre;

    private int qtdCertificados;

}
