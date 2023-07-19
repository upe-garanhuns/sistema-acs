package br.upe.acs.utils;

import java.io.Serial;

public class CepInvalidoExcecao extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public CepInvalidoExcecao(String mensagem) {
        super(mensagem);
    }
}
