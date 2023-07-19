package br.upe.acs.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CertificadoDTO {

	private String titulo;
	
	private String descricao;
	
	private String observacao;
	
	private String data;
	
	private Integer horas;
	
	private Long atividadeId;
	
	private Long requisicaoId;
}
