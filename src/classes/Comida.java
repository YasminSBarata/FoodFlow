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

public class Comida extends Produto {
    private String tipoCozinha;

    public Comida(int codProduto, String nome, double preco, boolean alcoolica, String descricao, String tipoCozinha, int tempoPreparo, boolean vegetariano, String categoria) {
        super(codProduto, nome, preco, alcoolica, descricao, tempoPreparo, vegetariano, categoria);
        this.tipoCozinha = tipoCozinha;
    }

    public String getTipoCozinha() {
        return tipoCozinha;
    }

}
