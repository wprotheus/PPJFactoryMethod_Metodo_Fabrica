package com.wprotheus.exportador;

import com.wprotheus.model.Produto;
import lombok.Data;

import java.util.function.Function;

@Data
public abstract class AbstractColuna implements Coluna {
    private final Function<Produto, Object> obtemValorColuna;
    private String titulo;

    public AbstractColuna(Function<Produto, Object> obtemValorColuna, String titulo) {
        this.obtemValorColuna = obtemValorColuna;
        this.titulo = titulo;
    }

    @Override
    public String exportarCabecalho() {
        return getTitulo();
    }

    @Override
    public String exportarDado(Produto produto) {
        return obtemValorColuna.apply(produto).toString();
    }
}