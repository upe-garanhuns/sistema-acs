package br.upe.acs.dominio;

import java.util.Date;
import java.util.List;

import br.upe.acs.dominio.enums.RequisicaoStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Requisicao extends RequisicaoBase {

	@Temporal(TemporalType.DATE)
	private Date dataDeSubmissao;
	
	@Column(columnDefinition = "TEXT")
	private String observacao;

	private String token;

	private byte[] requisicaoArquivoAssinada;
	
	@Enumerated(EnumType.STRING)
	private RequisicaoStatusEnum statusRequisicao;

	@ManyToOne
	private Aluno aluno;

	@ManyToOne
	private Curso curso;

	@OneToMany(mappedBy = "requisicao")
	private List<Certificado> certificados;
}
