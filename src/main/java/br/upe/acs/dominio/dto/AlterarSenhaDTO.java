package br.upe.acs.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlterarSenhaDTO {

    private String senha;

    private String novaSenha;

}
