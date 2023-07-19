package br.upe.acs.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequisicaoRascunhoDTO {

    private int semestre;

    private int qtdCertificados;

    private Long usuarioId;
    
    private String observacao;

    private Long cursoId;

    private MultipartFile[] certificadoArquivos;

    private MultipartFile certificadosMetadados;
}
