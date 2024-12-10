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

public abstract class Produto {
    protected String nome;
    protected double preco;
    protected int tempoPreparo;
    
public static String[] categorias = { "Comida", "Bebida" };

    public Produto(String nome, double preco, int tempoPreparo) {
        this.nome = nome;
        this.preco = preco;
        this.tempoPreparo = tempoPreparo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }
}

