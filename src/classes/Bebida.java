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

public class Bebida extends Produto {
    private int tamanhoML;

    public Bebida(int codProduto, String nome, double preco, boolean alcoolica, String descricao, int tempoPreparo, int tamanhoML, boolean vegetariano) {
        super(codProduto, nome, preco, alcoolica, descricao, tamanhoML, vegetariano);
        this.tamanhoML = tamanhoML;
    }

    public int getTamanhoML() {
        return tamanhoML;
    }

}

