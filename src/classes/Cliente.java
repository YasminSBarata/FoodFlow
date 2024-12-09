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

 // Classe Cliente, herdando de Usuario
public class Cliente extends Usuario {
    private List<Produto> carrinho;

    public Cliente(String nome, String email) {
        super(nome, email);
        this.carrinho = new ArrayList<>();
    }

    public void visualizarRestaurantes(List<Restaurante> restaurantes) {
        System.out.println("Restaurantes disponíveis:");
        for (Restaurante restaurante : restaurantes) {
            System.out.println("- " + restaurante.getNome() + " (" + restaurante.getEndereco() + ")");
        }
    }

    public void selecionarProdutos(Restaurante restaurante) {
        System.out.println("Produtos disponíveis no restaurante " + restaurante.getNome() + ":");
        for (Produto produto : restaurante.getProdutos()) {
            System.out.println("- " + produto.getNome() + ": R$" + produto.getPreco() + " | Tempo de preparo: " + produto.getTempoPreparo() + " min");
        }

        // Simulando seleção de produtos
        if (!restaurante.getProdutos().isEmpty()) {
            Produto produto = restaurante.getProdutos().get(0); // Seleciona o primeiro produto como exemplo
            carrinho.add(produto);
            System.out.println("Produto adicionado ao carrinho: " + produto.getNome());
        }
    }

    public void exibirCarrinho() {
        System.out.println("Carrinho de compras:");
        for (Produto produto : carrinho) {
            System.out.println("- " + produto.getNome() + ": R$" + produto.getPreco());
        }
    }

    public void finalizarPedido() {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio! Adicione produtos antes de finalizar o pedido.");
            return;
        }

        Pedido pedido = new Pedido(this, carrinho);
        pedido.exibirResumo();
        carrinho.clear();
        System.out.println("Pedido finalizado com sucesso!");
    }
}


