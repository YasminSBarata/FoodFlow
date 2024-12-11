
package classes;

/**
 *
 * @author yasmi
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

 // Classe Cliente, herdando de Usuario
public class Cliente extends Usuario {
    private List<Produto> carrinho;
       private int codCliente;

    
    public Cliente(int codCliente, String nome, String email) {
        super(nome, email);
        this.codCliente = codCliente;
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

    public void init() throws IOException {
        // decidi o id (único) do cliente e o salva no banco de dados
        int curr_id = 0;
        
        try {
            ArrayList<Cliente> clientes = Manipulador.carregarClientes();
            
            if (clientes.size() > 0)
                curr_id = clientes.get(clientes.size()-1).getCodCliente()+1;
        } catch(IOException ex) {
            curr_id = 0;
        }
        
        this.setCodCliente(curr_id);
        Manipulador.armazenar(this);
    }
    
    @Override
    public String toString() {
        
        return String.valueOf(this.codCliente) + ";"
                + this.nome + ";"
                + this.email + ";";
                }
    
    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

}

