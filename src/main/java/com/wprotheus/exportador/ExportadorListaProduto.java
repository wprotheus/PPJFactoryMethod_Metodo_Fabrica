package com.wprotheus.exportador;

import com.wprotheus.model.Produto;

import java.util.List;
import java.util.function.Function;

public interface ExportadorListaProduto {
    static ExportadorListaProduto newInstace() {
        return newInstace("html");
    }

    static ExportadorListaProduto newInstace(String extensao) {
        return switch (extensao.toLowerCase()) {
            case "html" -> new ExportadorListaProdutoHtml();
            case "md" -> new ExportadorListaProdutoMd();
            case "csv" -> new ExportadorListaProdutoCsv();
            default -> throw new UnsupportedOperationException(
                    "Formato de exportação não suportado: " + extensao);
        };
    }

//    static ExportadorListaProduto newInstace(String extensao) {
//        String ext = extensao.toLowerCase();
//        ext = Character.toUpperCase(ext.charAt(0)) + ext.substring(1) ;
//        var className = ExportadorListaProduto.class.getName() + ext;
//        System.out.println(className);
//
//        try {
//            var clazz = Class.forName(className);
//            var constructor = clazz.getConstructor();
//            Object obj = constructor.newInstance();
//            if(obj instanceof ExportadorListaProduto exportador)
//                return exportador;
//        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
//                 InstantiationException | IllegalAccessException e) {
//            e.printStackTrace(); //("A classe localizada para exportar produtos nao implementa ");
//        }
//        return null;
//    }

    Coluna newColuna(Function<Produto, Object> funcaoValorColuna, String titulo);

    void addColuna(Coluna coluna);

    String abrirTabela();

    String fecharTabela();

//    String abrirLinha();

    String fecharLinha();

//    String abrirLinhaTitulos();

    String fecharLinhaTitulos();

//    String criarColuna(Object valor);

    String exportar(List<Produto> produto);
}