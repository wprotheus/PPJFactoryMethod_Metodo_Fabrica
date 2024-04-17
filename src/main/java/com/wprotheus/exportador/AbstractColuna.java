package com.wprotheus.exportador;

import lombok.Getter;
import lombok.Setter;

import java.util.function.Function;

@Getter
@Setter
public abstract class AbstractColuna<T> implements Coluna<T> {
    private Function<T, String> funcaoValorColuna;
    private String titulo;

    public AbstractColuna(Function<T, String> funcaoValorColuna, String titulo) {
        this.funcaoValorColuna = funcaoValorColuna;
        this.titulo = titulo;
    }

    @Override
    public String exportarCabecalho() {
        return abrir() + titulo + fechar();
    }

    @Override
    public String exportarDado(T produto) {
        return abrir() + funcaoValorColuna.apply(produto) + fechar();
    }
}