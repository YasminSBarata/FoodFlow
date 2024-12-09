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
    private boolean alcoolica;

    public Bebida(String nome, double preco, int tempoPreparo, int tamanhoML, boolean alcoolica) {
        super(nome, preco, tempoPreparo);
        this.tamanhoML = tamanhoML;
        this.alcoolica = alcoolica;
    }

    public int getTamanhoML() {
        return tamanhoML;
    }

    public boolean isAlcoolica() {
        return alcoolica;
    }
}

