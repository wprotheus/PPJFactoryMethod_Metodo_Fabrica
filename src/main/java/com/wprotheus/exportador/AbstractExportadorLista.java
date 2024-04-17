package com.wprotheus.exportador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractExportadorLista<T> implements ExportadorLista<T> {
    protected final List<String> TITULOS_COLUNAS = List.of("CODIGO", "NOME", "MARCA", "VALOR", "ESTOQUE");
    private List<Coluna<T>> colunas;
    private List<T> lista;

    public AbstractExportadorLista(List<T> lista) {
        this.colunas = new ArrayList<>();
        this.lista = lista;
    }

    protected void addColuna(Coluna<T> coluna) {
        colunas.add(coluna);
    }

    public final String exportar() {
        return new StringBuilder(abrirTabela())
                .append(abrirLinhaTitulos())
                .append(fecharLinhaTitulos())
                .append(gerarLinhas(lista))
                .append(fecharTabela()).toString();
    }

    protected String gerarLinhas(List<T> lista) {
        return lista
                .stream()
                .map(produto -> abrirLinha() + gerarColunas(produto) + fecharLinha())
                .collect(Collectors.joining());
    }

    protected String gerarColunas(T produto) {
        var colunasGeradas = new StringBuilder();
        for (Coluna coluna : colunas)
            colunasGeradas.append(coluna.exportarDado(produto));
        if (colunas.get(0).abrir().equals(","))
            colunasGeradas.deleteCharAt(0);
        return colunasGeradas.toString();
    }
}