package com.wprotheus;

import com.wprotheus.exportador.ExportadorListaProduto;
import com.wprotheus.model.Produto;
import com.wprotheus.util.SalvarArquivoExportado;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Produto> produtos = List.of(new Produto(1, "TV", "LG", "2600", 100),
                new Produto(2, "Tablet", "Samsung", "1700", 80),
                new Produto(3, "PC", "Daten", "7600", 10),
                new Produto(4, "TV", "Sony", "6600", 17),
                new Produto(5, "MacPro", "Apple", "21200", 8));

        final String extensao = "csv";
        String respostaExportador = ExportadorListaProduto.newInstace(extensao).exportar(produtos);
        salvar(respostaExportador, extensao);
    }

    private static void salvar(String respostaExportador, String extensao) {
        new SalvarArquivoExportado(respostaExportador, extensao);
    }
}