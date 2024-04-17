package com.wprotheus.exportador;

import java.util.function.Function;

public class ColunaCsv<T> extends AbstractColuna<T> {
    public ColunaCsv(Function<T, String> funcaoValorColuna, String titulo) {
        super(funcaoValorColuna, titulo);
    }

    @Override
    public String abrir() {
        return ",";
    }

    @Override
    public String fechar() {
        return "";
    }
}