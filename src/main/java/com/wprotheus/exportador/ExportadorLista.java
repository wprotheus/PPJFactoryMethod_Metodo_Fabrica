package com.wprotheus.exportador;

import java.util.List;
import java.util.function.Function;

public interface ExportadorLista<T> {

    static <T> ExportadorLista newInstace(List<T> lista) {
        return newInstace(lista, "html");
    }

    static <T> ExportadorLista newInstace(List<T> lista, String extensao) {
        return switch (extensao.toLowerCase()) {
            case "html" -> new ExportadorListaHtml(lista);
            case "md" -> new ExportadorListaMd(lista);
            case "csv" -> new ExportadorListaCsv(lista);
            default -> throw new UnsupportedOperationException(
                    "Formato de exportação não suportado: " + extensao);
        };
    }

    String abrirTabela();

    String fecharTabela();

    String abrirLinha();

    String fecharLinha();

    String abrirLinhaTitulos();

    String fecharLinhaTitulos();

    String exportar();

    void addNewColuna(Function<T, String> funcaoValorColuna, String titulo);
}