package com.wprotheus.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
    private String id;
    private String nomeProduto;
    private String marcaProduto;
    private String valorProduto;
    private String estoqueProtduto;

    public Produto(String id, String nomeProduto, String marcaProduto,
                   String valorProduto, String estoqueProtduto) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.marcaProduto = marcaProduto;
        this.valorProduto = valorProduto;
        this.estoqueProtduto = estoqueProtduto;
    }
}