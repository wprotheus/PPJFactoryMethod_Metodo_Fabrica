package com.wprotheus.exportador;

import com.wprotheus.model.Produto;

import java.util.function.Function;

class ExportadorListaProdutoMd extends AbstractExportadorListaProduto {
    @Override
    public Coluna newColuna(Function<Produto, Object> funcaoValorColuna, String titulo) {
        return new ColunaMd(funcaoValorColuna, titulo);
    }

    @Override
    protected void setSeparadorCol(String separadorCol) {
        super.setSeparadorCol(separadorCol);
        this.setSeparadorCol("|");
    }

    @Override
    public String abrirTabela() {
        return "";
    }

    @Override
    public String fecharTabela() {
        return "";
    }


    public String abrirLinha() {
        return "";
    }

    @Override
    public String fecharLinha() {
        return "";
    }

    @Override
    public String fecharLinhaTitulos() {
        StringBuilder sb = new StringBuilder();
        for (String t : TITULOS_COLUNAS)
            sb.append("| ").append(t).append(" ");
        sb.append("\n");
        for (String t : TITULOS_COLUNAS)
            sb.append("--------").append(" ");
        return sb.toString() + "\n";
    }
}