package com.wprotheus.util;

import java.io.*;
import java.nio.file.*;

public class SalvarArquivoExportado implements Serializable {
    private final String NOME_ARQ = "produtos.";

    public SalvarArquivoExportado(String respostaExportador, String extensao) {
        Path path = Paths.get(NOME_ARQ + extensao);
        try {
            Files.writeString(path, respostaExportador, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}