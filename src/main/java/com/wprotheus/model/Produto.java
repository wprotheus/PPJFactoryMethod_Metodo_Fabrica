package com.wprotheus.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Produto implements Serializable {
    private int id;
    private String nomeProduto;
    private String marcaProduto;
    private String valorProduto;
    private int estoqueProtduto;

    public Produto(int id, String nomeProduto, String marcaProduto, String valorProduto, int estoqueProtduto) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.marcaProduto = marcaProduto;
        this.valorProduto = valorProduto;
        this.estoqueProtduto = estoqueProtduto;
    }
}