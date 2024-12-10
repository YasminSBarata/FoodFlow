package classes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DonoRestaurante extends Usuario {
    private List<Restaurante> restaurantes;

    public DonoRestaurante(String nome, String email) {
        super(nome, email);
        this.restaurantes = new ArrayList<>();
    }

    public void cadastrarRestaurante(Restaurante restaurante) {
        restaurantes.add(restaurante);
        System.out.println("Restaurante cadastrado: " + restaurante.getNome());
    }

    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void salvarRestaurantes(String caminhoArquivo) {
        List<String> dados = new ArrayList<>();
        for (Restaurante restaurante : restaurantes) {
            dados.add("Restaurante:" + restaurante.getNome() + ";" + restaurante.getEndereco() + ";" + restaurante.getCategoria());
            for (Produto produto : restaurante.getProdutos()) {
                if (produto instanceof Comida) {
                    Comida comida = (Comida) produto;
                    dados.add("Comida:" + comida.getCodProduto() + ";" + comida.getNome() + ";" + comida.getPreco() + ";" + 
                              comida.getTempoPreparo() + ";" + comida.getTipoCozinha() + ";" + comida.isVegetariano());
                } else if (produto instanceof Bebida) {
                    Bebida bebida = (Bebida) produto;
                    dados.add("Bebida:" + bebida.getCodProduto() + ";" + bebida.getNome() + ";" + bebida.getPreco() + ";" + 
                              bebida.getTempoPreparo() + ";" + bebida.getTamanhoML() + ";" + bebida.isAlcoolica());
                }
            }
        }
        try {
            Path caminho = Paths.get(caminhoArquivo);
            Files.write(caminho, dados, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.err.println("Erro ao salvar restaurantes: " + e.getMessage());
        }
    }

    public void carregarRestaurantes(String caminhoArquivo) {
        try {
            List<String> dados = Files.readAllLines(Paths.get(caminhoArquivo), StandardCharsets.UTF_8);
            Restaurante restauranteAtual = null;

            for (String linha : dados) {
                String[] partes = linha.split(";");
                if (linha.startsWith("Restaurante:")) {
                    String nome = partes[0].replace("Restaurante:", "");
                    String endereco = partes[1];
                    String categoria = partes[2];
                    restauranteAtual = new Restaurante(nome, endereco, categoria);
                    restaurantes.add(restauranteAtual);
                } else if (linha.startsWith("Comida:") && restauranteAtual != null) {
                    int codProduto = Integer.parseInt(partes[1]);
                    String nome = partes[2];
                    double preco = Double.parseDouble(partes[3]);
                    boolean alcoolica = Boolean.parseBoolean(partes[4]);
                    String descricao = partes[5];
                    int tempoPreparo = Integer.parseInt(partes[6]);
                    String tipoCozinha = partes[7];
                    boolean vegetariano = Boolean.parseBoolean(partes[8]);
                    restauranteAtual.adicionarProduto(new Comida(codProduto, nome, preco, alcoolica, descricao, tipoCozinha, tempoPreparo, vegetariano));
                } else if (linha.startsWith("Bebida:") && restauranteAtual != null) {
                    int codProduto = Integer.parseInt(partes[1]);
                    String nome = partes[2];
                    double preco = Double.parseDouble(partes[3]);
                    boolean alcoolica = Boolean.parseBoolean(partes[4]);
                    String descricao = partes[5];
                    int tempoPreparo = Integer.parseInt(partes[6]);
                    int tamanhoML = Integer.parseInt(partes[7]);
                    boolean vegetariano = Boolean.parseBoolean(partes[8]);
                    restauranteAtual.adicionarProduto(new Bebida(codProduto, nome, preco, alcoolica, descricao, tempoPreparo, tamanhoML, vegetariano));
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar restaurantes: " + e.getMessage());
        }
    }
}
