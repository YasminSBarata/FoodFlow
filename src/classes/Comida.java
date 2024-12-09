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
    private boolean vegetariano;

    public Comida(String nome, double preco, int tempoPreparo, String tipoCozinha, boolean vegetariano) {
        super(nome, preco, tempoPreparo);
        this.tipoCozinha = tipoCozinha;
        this.vegetariano = vegetariano;
    }

    public String getTipoCozinha() {
        return tipoCozinha;
    }

    public boolean isVegetariano() {
        return vegetariano;
    }
}
