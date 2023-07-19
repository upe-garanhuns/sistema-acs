package br.upe.acs.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno extends Usuario {

    private int periodo;

    private String matricula;

    private String codigoVerificacao;

    private int horasEnsino;

    private int horasExtensao;

    private int horasGestao;

    private int horasPesquisa;

    private boolean verificado;
    

    @OneToMany(mappedBy = "aluno")
    private List<Requisicao> requisicoes;

    @ManyToOne
    private Endereco endereco;
    

}
