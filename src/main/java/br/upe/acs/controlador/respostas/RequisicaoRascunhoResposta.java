package br.upe.acs.controlador.respostas;

import br.upe.acs.dominio.RequisicaoRascunho;
import lombok.Getter;

import java.util.List;

@Getter
public class RequisicaoRascunhoResposta {

    private final Long id;

    private final int semestre;

    private final int qtdCertificados;

    private final String requisicaoStatus = "RASCUNHO";

    private final List<CertificadoRascunhoResposta> certificados;

    public RequisicaoRascunhoResposta(RequisicaoRascunho requisicaoRascunho) {
        this.id = requisicaoRascunho.getId();
        this.semestre = requisicaoRascunho.getSemestre();
        this.qtdCertificados = requisicaoRascunho.getQtdCertificados();
        this.certificados = requisicaoRascunho.getCertificadosRascunho().stream().map(CertificadoRascunhoResposta::new).toList();
    }
}