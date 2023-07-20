package br.upe.acs.dominio;

import java.util.Date;

import br.upe.acs.dominio.enums.CertificadoStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Certificado extends CertificadoBase {
	
	@Column(columnDefinition = "TEXT")
	private String observacao;
	
	@Temporal(TemporalType.DATE)
	private Date dataDeSubmissao;
	
	@Enumerated(EnumType.STRING)
	private CertificadoStatusEnum statusCertificado;
	
	@ManyToOne
	private Requisicao requisicao;
	
	@ManyToOne
	private Atividade atividade;

}
