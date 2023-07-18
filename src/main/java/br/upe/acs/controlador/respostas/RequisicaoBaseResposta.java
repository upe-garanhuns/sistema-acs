package br.upe.acs.controlador.respostas;

import br.upe.acs.dominio.Certificado;
import br.upe.acs.dominio.CertificadoRascunho;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.RequisicaoRascunho;
import lombok.Getter;

import java.util.Date;

@Getter
public class RequisicaoBaseResposta {

    private final Long id;

    private final String status;

    private final Date DataDaSolicitacao;

    private final int quantidadeDeHoras;

    public RequisicaoBaseResposta(Requisicao requisicao) {
        this.id = requisicao.getId();
        this.status = requisicao.getStatusRequisicao().name();
        DataDaSolicitacao = requisicao.getDataDeSubmissao();
        this.quantidadeDeHoras = requisicao.getCertificados().stream().mapToInt(Certificado::getQuantidadeDeHoras).sum();
    }

    public RequisicaoBaseResposta(RequisicaoRascunho requisicaoRascunho) {
        this.id = requisicaoRascunho.getId();
        this.status = "RASCUNHO";
        DataDaSolicitacao = requisicaoRascunho.getDataCriacao();
        this.quantidadeDeHoras = requisicaoRascunho.getCertificadosRascunho().stream().mapToInt(CertificadoRascunho::getQuantidadeDeHoras).sum();
    }
}
