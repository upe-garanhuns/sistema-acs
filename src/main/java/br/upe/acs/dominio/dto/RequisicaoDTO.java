package br.upe.acs.dominio.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequisicaoDTO {
	
	private int qtdCertificados;
	
	private MultipartFile[] certificados;
	
	private MultipartFile certificadosMetadados;
}
