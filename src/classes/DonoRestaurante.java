/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author yasmi
 */

import java.util.ArrayList;
import java.util.List;

public class DonoRestaurante extends Usuario {
    private List<Restaurante> restaurantes;

    public DonoRestaurante(String nome, String email) {
        super(nome, email);
        this.restaurantes = new ArrayList<>();
    }

    public void cadastrarRestaurante(Restaurante restaurante) {
        restaurantes.add(restaurante);
        System.out.println("Restaurante cadastrado: " + restaurante.getNome());
    }

    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }
    
    public void salvarRestaurantes(String caminhoArquivo) {
    List<String> dados = new ArrayList<>();
    for (Restaurante restaurante : restaurantes) {
        dados.add("Restaurante:" + restaurante.getNome() + ";" + restaurante.getEndereco());
        for (Produto produto : restaurante.getProdutos()) {
            if (produto instanceof Comida) {
                Comida comida = (Comida) produto;
                dados.add("Comida:" + comida.getNome() + ";" + comida.getPreco() + ";" + comida.getTempoPreparo() + ";" +
                          comida.getTipoCozinha() + ";" + comida.isVegetariano());
            } else if (produto instanceof Bebida) {
                Bebida bebida = (Bebida) produto;
                dados.add("Bebida:" + bebida.getNome() + ";" + bebida.getPreco() + ";" + bebida.getTempoPreparo() + ";" +
                          bebida.getTamanhoML() + ";" + bebida.isAlcoolica());
            }
        }
    }
    FileUtil.salvarEmArquivo(caminhoArquivo, dados);
}
    public void carregarRestaurantes(String caminhoArquivo) {
    List<String> dados = FileUtil.carregarDoArquivo(caminhoArquivo);
    Restaurante restauranteAtual = null;

    for (String linha : dados) {
        String[] partes = linha.split(";");
        if (linha.startsWith("Restaurante:")) {
            String nome = partes[0].replace("Restaurante:", "");
            String endereco = partes[1];
            restauranteAtual = new Restaurante(nome, endereco);
            restaurantes.add(restauranteAtual);
        } else if (linha.startsWith("Comida:") && restauranteAtual != null) {
            String nome = partes[0].replace("Comida:", "");
            double preco = Double.parseDouble(partes[1]);
            int tempo = Integer.parseInt(partes[2]);
            String tipoCozinha = partes[3];
            boolean vegetariano = Boolean.parseBoolean(partes[4]);
            restauranteAtual.adicionarProduto(new Comida(nome, preco, tempo, tipoCozinha, vegetariano));
        } else if (linha.startsWith("Bebida:") && restauranteAtual != null) {
            String nome = partes[0].replace("Bebida:", "");
            double preco = Double.parseDouble(partes[1]);
            int tempo = Integer.parseInt(partes[2]);
            int tamanhoML = Integer.parseInt(partes[3]);
            boolean alcoolica = Boolean.parseBoolean(partes[4]);
            restauranteAtual.adicionarProduto(new Bebida(nome, preco, tempo, tamanhoML, alcoolica));
        }
    }
}

}

