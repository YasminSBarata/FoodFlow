/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import classes.Manipulador;

public abstract class Produto {
    private int codProduto;
    private String nome;
    private double preco;
    boolean alcoolica;
    private String descricao;
    protected int tempoPreparo;
    boolean vegetariano;
    String categoria;
    
public static String[] categorias = { "Comida", "Bebida" };

public Produto(int codProduto, String nome, double preco, boolean alcoolica, String descricao, int tempoPreparo, boolean vegetariano, String categoria) {
        this.codProduto = codProduto;
        this.nome = nome;
        this.preco = preco;
        this.alcoolica = alcoolica;
        this.descricao = descricao;
        this.tempoPreparo = tempoPreparo;
        this.vegetariano = vegetariano;
        this.categoria = categoria;
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
        
    public String getDescricao(){
        return descricao;
    }
    
    public boolean isAlcoolica(){
        return alcoolica;
    }

    public boolean isVegetariano(){
        return vegetariano;
    }
    public int getCodProduto() {
        return codProduto;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }
        public void init() throws IOException {
        int curr_id = 0;
        
        try {
            ArrayList<Produto> produtos = Manipulador.carregarProdutos();
            
            if (produtos.size() > 0)
                curr_id = produtos.get(produtos.size()-1).getCodProduto()+1;
        } catch(IOException ex) {
            curr_id = 0;
        }
        
        this.setCodProduto(curr_id);
        Manipulador.armazenar(this);
    }
}

