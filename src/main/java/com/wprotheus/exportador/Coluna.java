package com.wprotheus.exportador;

import com.wprotheus.model.Produto;

public interface Coluna {
    String getTitulo();
    String abrir();
    String fechar();
    String exportarCabecalho();
    String exportarDado(Produto produto);
}