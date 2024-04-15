package com.wprotheus.exportador;

import com.wprotheus.model.Produto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractExportadorListaProduto implements ExportadorListaProduto {
    protected final List<String> TITULOS_COLUNAS = List.of("CÓDIGO", "NOME", "MARCA", "VALOR", "ESTOQUE");
    private List<Coluna> colunas;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String separadorCol = "";

    public AbstractExportadorListaProduto() {
        colunas = new ArrayList<>();
        colunas.add(newColuna(Produto::getId, TITULOS_COLUNAS.get(0)));
        colunas.add(newColuna(Produto::getNomeProduto, TITULOS_COLUNAS.get(1)));
        colunas.add(newColuna(Produto::getMarcaProduto, TITULOS_COLUNAS.get(2)));
        colunas.add(newColuna(Produto::getValorProduto, TITULOS_COLUNAS.get(3)));
        colunas.add(newColuna(Produto::getEstoqueProtduto, TITULOS_COLUNAS.get(4)));
    }

    @Override
    public void addColuna(Coluna coluna) {
        colunas.add(coluna);
    }

    @Override
    public final String exportar(List<Produto> Listaproduto) {
        return new StringBuilder(abrirTabela())
                .append(fecharLinhaTitulos())
                .append(gerarLinhaProduto(Listaproduto))
                .append(fecharTabela()).toString();
    }

    protected String gerarLinhaProduto(List<Produto> listaproduto) {
        return listaproduto
                .stream()
                .map(this::gerarColunasProduto)
                .collect(Collectors.joining());
    }

    protected String gerarColunasProduto(Produto produto) {
        StringBuilder sb = new StringBuilder();
        for (Coluna coluna : colunas)
            sb.append(coluna.abrir())
                    .append(String.join(separadorCol, coluna.exportarDado(produto)))
                    .append(coluna.fechar());
        if (colunas.get(0).abrir().equals(","))
            sb.deleteCharAt(0);

        return sb.append("\n").toString();
    }
}