package com.siteDoJogo.security.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class EnvLoader {

    public static String EnvLoaderVariable(String variable) {

        Path path = Path.of(".env");

        // ele lê o env e procura pela variable dentro dele e devolve a chave
        try {
            var teste = Files.readAllLines(path);

            for (String key : teste) {

                if(key.contains(variable)) {
                    var result = key.split("=");

                    return result[1];
                }

            }

        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler .env", e);
        }
    return null;

    }
}
