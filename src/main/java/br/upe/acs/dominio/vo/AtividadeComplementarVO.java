package br.upe.acs.dominio.vo;

import br.upe.acs.dominio.Aluno;
import lombok.Getter;

@Getter
public class AtividadeComplementarVO {

    private final int horasExtensao;

    private final int horasGestao;

    private final int horasEnsino;

    private final int horasPesquisa;

    private final String horasExtensaoPercentual;

    private final String horasGestaoPercentual;

    private final String horasEnsinoPercentual;

    private final String horasPesquisaPercentual;

    private final int horasTotaisCurso;

    public AtividadeComplementarVO(Aluno aluno) {
        this.horasExtensao = aluno.getHorasExtensao();
        this.horasGestao = aluno.getHorasGestao();
        this.horasEnsino = aluno.getHorasEnsino();
        this.horasPesquisa = aluno.getHorasPesquisa();
        this.horasExtensaoPercentual = percentual(aluno.getHorasExtensao(), aluno.getCurso().getHorasComplementares());
        this.horasGestaoPercentual = percentual(aluno.getHorasGestao(), aluno.getCurso().getHorasComplementares());
        this.horasEnsinoPercentual = percentual(aluno.getHorasEnsino(), aluno.getCurso().getHorasComplementares());
        this.horasPesquisaPercentual = percentual(aluno.getHorasPesquisa(), aluno.getCurso().getHorasComplementares());
        this.horasTotaisCurso = aluno.getCurso().getHorasComplementares();
    }

    private String percentual(int dividendo, int divisor) {
        return Math.round(((double) dividendo /divisor) * 100.0) + "%";
    }
}