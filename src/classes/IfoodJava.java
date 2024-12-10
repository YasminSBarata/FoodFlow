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
import telas.Inicial;

public class IfoodJava {
    public static void main(String[] args) {
        // Dono Restaurante
        DonoRestaurante dono = new DonoRestaurante("Ingrid imbiriba", "Ingrid@email.com");
        String caminhoArquivo = "restaurantes.txt";
        
        // Carregar dados do arquivo
        dono.carregarRestaurantes(caminhoArquivo);

        Restaurante restaurante = new Restaurante("Pizzaria da ingrid", "cidade nova 123","Pizza");
        dono.cadastrarRestaurante(restaurante);

        Comida pizza = new Comida(0,"Pizza Margherita", 40.0, false, "Massa de fermentação natral, molho de tomate caseiro, queijo mussarela, tomate e manjericão", "Italiana", 30, true, "Comida");
        Bebida suco = new Bebida(1,"Suco de Laranja", 10.0, false, "Suco natural, feito na hora", 5, 500, false, "Bebida");
        restaurante.adicionarProduto(pizza);
        restaurante.adicionarProduto(suco);

        // Salvar dados no arquivo
        dono.salvarRestaurantes(caminhoArquivo);
        
        // Cliente
        Cliente cliente = new Cliente(0,"nalice dias", "nalice@email.com");

        // Cliente interagindo com o sistema
        cliente.visualizarRestaurantes(dono.getRestaurantes());
        cliente.selecionarProdutos(restaurante);
        cliente.exibirCarrinho();

        // Finalizando o pedido
        cliente.finalizarPedido();
new Inicial().setVisible(true);
        }
    }
