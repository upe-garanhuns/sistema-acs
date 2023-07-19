package br.upe.acs.controlador.respostas;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.dominio.Certificado;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.enums.RequisicaoStatusEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;

@Getter
public class RequisicaoResposta {

	private final Long id;
	
	@Temporal(TemporalType.DATE)
	private final Date data;
	
	private final int semestre;
	
	private final int qtdCertificados;
	
	private final String token;

	private final String observacao;
	
	@Enumerated(EnumType.STRING)
	private final RequisicaoStatusEnum requisicaoStatus;
	
	private final byte[] requisicaoArquivo;
	
	private final List<CertificadoResposta> certificados;

	public RequisicaoResposta(Requisicao requisicao) {
		super();
		this.id = requisicao.getId();
		this.data = requisicao.getData();
		this.semestre = requisicao.getSemestre();
		this.qtdCertificados = requisicao.getQtdCertificados();
		this.token = requisicao.getToken();
		this.requisicaoStatus = requisicao.getStatusRequisicao();
		this.requisicaoArquivo = requisicao.getRequisicaoArquivoAssinada();
		this.certificados = converterCertificados(requisicao.getCertificados());
		this.observacao = requisicao.getObservacao();
	}
	
	private List<CertificadoResposta> converterCertificados(List<Certificado> certificados) {
		return certificados.stream()
				.map(CertificadoResposta::new).collect(Collectors.toList());
	}
}
