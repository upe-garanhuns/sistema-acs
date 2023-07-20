package br.upe.acs.controlador.respostas;

import br.upe.acs.dominio.CertificadoRascunho;
import br.upe.acs.dominio.RequisicaoRascunho;
import br.upe.acs.dominio.enums.EixoEnum;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Getter
public class CertificadoRascunhoResposta {

    private final Long id;

    private final String titulo;

    private final int horas;

    private final Date data;

    private final byte[] certificadoArquivo;

    private final EixoEnum eixoAtividade;

    private final String atividade;

    public CertificadoRascunhoResposta(CertificadoRascunho certificadoRascunho) {
        this.id = certificadoRascunho.getId();
        this.titulo = certificadoRascunho.getTitulo();
        this.horas = certificadoRascunho.getQuantidadeDeHoras();
        this.certificadoArquivo = certificadoRascunho.getCertificado();
        this.eixoAtividade = certificadoRascunho.getEixoAtividade();
        this.data = certificadoRascunho.getDataInicial();
        this.atividade = certificadoRascunho.getDescricaoAtividade();
    }
}
