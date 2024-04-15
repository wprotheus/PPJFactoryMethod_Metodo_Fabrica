package com.wprotheus.exportador;

import com.wprotheus.model.Produto;

import java.util.function.Function;

class ColunaHtml extends AbstractColuna{
    public ColunaHtml(Function<Produto, Object> obtemValorColuna, String titulo) {
        super(obtemValorColuna, titulo);
    }

    @Override
    public String abrir() {
        return "<td>";
    }

    @Override
    public String fechar() {
        return  "</td>";
    }
}