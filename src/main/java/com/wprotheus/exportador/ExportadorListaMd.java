package com.wprotheus.exportador;

import java.util.List;
import java.util.function.Function;

public class ExportadorListaMd<T> extends AbstractExportadorLista<T> {
    public ExportadorListaMd(List<T> lista) {
        super(lista);
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
    public String abrirLinha() {
        return "";
    }

    @Override
    public String fecharLinha() {
        return "\n";
    }

    @Override
    public String abrirLinhaTitulos() {
        return "";
    }

    @Override
    public String fecharLinhaTitulos() {
        StringBuilder sb = new StringBuilder();
        for (String t : TITULOS_COLUNAS)
            sb.append("| ").append(t).append(" ");
        sb.append("\n");
        for (String t : TITULOS_COLUNAS)
            sb.append("|--------").append(" ");
        return sb.toString() + "\n";
    }

    @Override
    public void addNewColuna(Function<T, String> funcaoValorColuna, String titulo) {
        addColuna(new ColunaMd<T>(funcaoValorColuna, titulo));
    }
}