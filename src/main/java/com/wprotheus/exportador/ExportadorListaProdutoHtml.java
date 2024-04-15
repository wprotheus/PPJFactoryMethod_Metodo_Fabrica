package com.wprotheus.exportador;

import com.wprotheus.model.Produto;
import java.util.function.Function;

class ExportadorListaProdutoHtml extends AbstractExportadorListaProduto {
    @Override
    public Coluna newColuna(Function<Produto, Object> funcaoValorColuna, String titulo) {
        return new ColunaHtml(funcaoValorColuna, titulo);
    }

    @Override
    public String abrirTabela() {
        return "<table>\n";
    }

    public String abrirLinha() {
        return "\n<tr>\n";
    }

    public String abrirLinhaTitulos() {
        return "<th>" + String.join("<th>", TITULOS_COLUNAS);
    }

    @Override
    public String fecharLinhaTitulos() {
        return "</th>\n";
    }

    @Override
    public String fecharLinha() {
        return "</tr>";
    }

    @Override
    public String fecharTabela() {
        return "</table>\n";
    }
}