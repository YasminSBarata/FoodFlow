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

public class Pedido {
    private Cliente cliente;
    private List<Produto> produtos;
    private double totalPreco;
    private int totalTempo;

    public Pedido(Cliente cliente, List<Produto> produtos) {
        this.cliente = cliente;
        this.produtos = new ArrayList<>(produtos);
        this.totalPreco = calcularPrecoTotal();
        this.totalTempo = calcularTempoTotal();
    }

    private double calcularPrecoTotal() {
        return produtos.stream().mapToDouble(Produto::getPreco).sum();
    }

    private int calcularTempoTotal() {
        return produtos.stream().mapToInt(Produto::getTempoPreparo).sum();
    }

    public void exibirResumo() {
        System.out.println("Resumo do Pedido:");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Produtos:");
        for (Produto produto : produtos) {
            System.out.println("- " + produto.getNome() + ": R$" + produto.getPreco());
        }
        System.out.println("Total: R$" + totalPreco);
        System.out.println("Tempo estimado: " + totalTempo + " min");
    }
}
