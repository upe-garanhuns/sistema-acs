package br.upe.acs.controlador.respostas;

import br.upe.acs.dominio.Aluno;
import br.upe.acs.dominio.Endereco;
import br.upe.acs.dominio.Requisicao;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AlunoResposta {

	private final Long id;

	private final String nomeCompleto;

	private final String cpf;

	private final String matricula;

	private final String telefone;

	private final String email;

	private final String senha;

	private final CursoResposta curso;

	private final int periodo;

	private final String codigoVerificacao;

	private final boolean verificado;

	private final List<RequisicaoResposta> requisicoes;

	private final EnderecoResposta endereco;

	public AlunoResposta(Aluno aluno) {
		this.id = aluno.getId();
		this.nomeCompleto = aluno.getNomeCompleto();
		this.cpf = aluno.getCpf();
		this.telefone = aluno.getTelefone();
		this.email = aluno.getEmail();
		this.senha = aluno.getSenha();
		this.curso = new CursoResposta(aluno.getCurso());
		this.periodo = aluno.getPeriodo();
		this.matricula = aluno.getMatricula();
		this.codigoVerificacao = aluno.getCodigoVerificacao();
		this.verificado = aluno.isVerificado();
		this.requisicoes = converterRequisicoes(aluno.getRequisicoes());
		this.endereco = converterEndereco(aluno.getEndereco());
	}

	private List<RequisicaoResposta> converterRequisicoes(List<Requisicao> requisicoesAluno) {
		return requisicoesAluno.stream().map(RequisicaoResposta::new).collect(Collectors.toList());
	}

	private EnderecoResposta converterEndereco(Endereco enderecoAluno) {
		return new EnderecoResposta(enderecoAluno);
	}
}
