package com.wprotheus.exportador;

import com.wprotheus.model.Produto;

import java.util.function.Function;

class ExportadorListaProdutoCsv extends AbstractExportadorListaProduto {
    @Override
    public Coluna newColuna(Function<Produto, Object> funcaoValorColuna, String titulo) {
        return new ColunaCsv(funcaoValorColuna, titulo);
    }

    @Override
    public String abrirTabela() {
        return "";
    }

    @Override
    public String fecharTabela() {
        return "";
    }

    @Override
    public String fecharLinha() {
        return "";
    }

    @Override
    public String fecharLinhaTitulos() {
        return String.join(",", TITULOS_COLUNAS) + "\n";
    }
}