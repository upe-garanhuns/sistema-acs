package br.upe.acs.dominio;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;

	private int horasComplementares;
	
	@OneToMany(mappedBy = "curso")
	private List<Requisicao> requisicoes;
	
	@OneToMany(mappedBy = "curso")
	private List<Aluno> alunos;

	@OneToMany(mappedBy = "curso")
	private List<Coordenador> coordenadores;

	@OneToMany(mappedBy = "curso")
	private List<Comissao> comissao;

	@OneToMany(mappedBy = "curso")
	private List<Administrador> administradores;
}
