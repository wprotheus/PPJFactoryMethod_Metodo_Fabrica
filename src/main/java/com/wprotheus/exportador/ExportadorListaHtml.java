package com.wprotheus.exportador;

import com.wprotheus.model.Produto;

import java.util.List;
import java.util.function.Function;

public class ExportadorListaHtml<T> extends AbstractExportadorLista<T> {
    public ExportadorListaHtml(List<T> lista) {
        super(lista);
    }

    @Override
    public String abrirTabela() {
        return "<table>\n";
    }

    @Override
    public String fecharTabela() {
        return "</table>\n";
    }

    @Override
    public String abrirLinha() {
        return "<tr>\n";
    }

    @Override
    public String fecharLinha() {
        return "\n</tr>\n";
    }

    @Override
    public String abrirLinhaTitulos() {
        return "<th>" + String.join("<th>", TITULOS_COLUNAS);
    }

    @Override
    public String fecharLinhaTitulos() {
        return "</th>\n";
    }

    @Override
    public void addNewColuna(Function<T, String> funcaoValorColuna, String titulo) {
        addColuna(new ColunaHtml<T>(funcaoValorColuna, titulo));
    }
}