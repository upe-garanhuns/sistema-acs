package br.upe.acs.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroDTO {
	
	private String nomeCompleto;
	
	private String cpf;
	
	private int periodo;
	
	private String telefone;
	
	private String email;
	
	private String senha;
	
	private String cep;
	
	private String rua;
	
	private String bairro;
	
	private String cidade;
	
	private String UF;
	
	private int numero;
	
	private Long cursoId;
}
