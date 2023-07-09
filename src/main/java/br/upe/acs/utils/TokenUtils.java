package br.upe.acs.utils;

import java.security.SecureRandom;
import java.util.Base64;

public class TokenUtils {

    private static final int TOKEN_LENGTH = 16;

    public static String gerarToken() {
        byte[] tokenBytes = new byte[TOKEN_LENGTH];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(tokenBytes);

        String token = Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);

        return token;
    }
}