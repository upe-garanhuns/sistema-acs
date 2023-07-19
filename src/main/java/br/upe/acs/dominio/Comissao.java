package br.upe.acs.dominio;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Comissao extends Usuario {

}
