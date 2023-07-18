package br.upe.acs.controlador.respostas;

import java.util.Date;

import br.upe.acs.dominio.Certificado;
import br.upe.acs.dominio.enums.CertificadoStatusEnum;
import br.upe.acs.dominio.enums.EixoEnum;
import lombok.Getter;

@Getter
public class CertificadoResposta {
	
	private final Long id;
	
	private final String titulo;
	
	private final String descricao;
	
	private final Date dataInicial;

	private final Date dataFinal;

	private final Date dataDeSubmissao;

	private final EixoEnum eixoAtividade;

	private final String atividade;
	
	private final CertificadoStatusEnum statusCertificado;
	
	private final int horas;
	
	private final int chMaxima;
	
	private final int chTotal;
	
	private final byte[] certificadoArquivo;

	public CertificadoResposta(Certificado certificado) {
		super();
		this.id = certificado.getId();
		this.titulo = certificado.getTitulo();
		this.descricao = certificado.getDescricao();
		this.dataInicial = certificado.getDataInicial();
		this.dataFinal = certificado.getDataFinal();
		this.dataDeSubmissao = certificado.getDataDeSubmissao();
		this.horas = certificado.getQuantidadeDeHoras();
		this.chMaxima = certificado.getChMaxima();
		this.chTotal = certificado.getChTotal();
		this.atividade = certificado.getAtividade().getDescricao();
		this.eixoAtividade = certificado.getAtividade().getEixo();
		this.certificadoArquivo = certificado.getCertificado();
		this.statusCertificado = certificado.getStatusCertificado();
	}
}
