package br.upe.acs.servico;

import br.upe.acs.dominio.Atividade;
import br.upe.acs.dominio.CertificadoRascunho;
import br.upe.acs.dominio.RequisicaoRascunho;
import br.upe.acs.dominio.dto.CertificadoDTO;
import br.upe.acs.repositorio.AtividadeRepositorio;
import br.upe.acs.repositorio.CertificadoRascunhoRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CertificadoRascunhoServico {

    private final CertificadoRascunhoRepositorio repositorio;
    private final AtividadeRepositorio atividadeRepositorio;
    private final RequisicaoRascunhoServico requisicaoRascunhoServicoServico;

    public void adicionarCertificadoRascunho(CertificadoDTO certificado, MultipartFile arquivo) throws IOException, ParseException, AcsExcecao {
        Optional<RequisicaoRascunho> requisicaoRascunhoSalvar = requisicaoRascunhoServicoServico.buscarRequisicaoRascunhoPorId(certificado.getRequisicaoId());

        CertificadoRascunho certificadoRascunhoSalvar = new CertificadoRascunho();
        if (certificado.getTitulo() != null) {
            certificadoRascunhoSalvar.setTitulo(certificado.getTitulo());
        }
        if (certificado.getDescricao() != null) {
            certificadoRascunhoSalvar.setDescricao(certificado.getDescricao());
        }

        if (certificado.getQuantidadeDeHoras() != null) {
            certificadoRascunhoSalvar.setQuantidadeDeHoras(certificado.getQuantidadeDeHoras());
        }
        if (arquivo != null) {
            byte[] certificadoArquivo = arquivo.getBytes();
            certificadoRascunhoSalvar.setCertificado(certificadoArquivo);
        }
        if (certificado.getAtividadeId() != null) {
            Optional<Atividade> atividadeSalvar = atividadeRepositorio.findById(certificado.getAtividadeId());
            if (atividadeRepositorio.findById(certificado.getAtividadeId()).isEmpty()) {
                certificadoRascunhoSalvar.setChMaxima(atividadeSalvar.orElseThrow().getChMaxima());
                certificadoRascunhoSalvar.setEixoAtividade(atividadeSalvar.orElseThrow().getEixo());
                certificadoRascunhoSalvar.setDescricaoAtividade(atividadeSalvar.orElseThrow().getDescricao());
            }
            certificadoRascunhoSalvar.setRequisicaoRascunho(requisicaoRascunhoSalvar.orElseThrow());
        }

        repositorio.save(certificadoRascunhoSalvar);
    }

    private static Date converterParaData(String dataString) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formato.parse(dataString);
    }
}
