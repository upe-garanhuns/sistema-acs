package br.upe.acs.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public  abstract class CertificadoBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Temporal(TemporalType.DATE)
    private Date dataInicial;

    @Temporal(TemporalType.DATE)
    private Date dataFinal;

    //TODO AS: Quantidade de horas não deveria ser float? O figma da a ideia de inteiro.
    private int quantidadeDeHoras;

    private int chMaxima;

    private int chTotal;

    private byte[] certificado;

}
