package com.wprotheus.exportador;

import com.wprotheus.model.Produto;

import java.util.function.Function;

class ColunaMd extends AbstractColuna{
    public ColunaMd(Function<Produto, Object> obtemValorColuna, String titulo) {
        super(obtemValorColuna, titulo);
    }

    @Override
    public String abrir() {
        return "|";
    }

    @Override
    public String fechar() {
        return "";
    }
}