/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author yasmi
 */
import java.io.*;
import java.util.*;

public class FileUtil {

    // Salva uma lista de strings em um arquivo
    public static void salvarEmArquivo(String caminhoArquivo, List<String> conteudo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (String linha : conteudo) {
                writer.write(linha);
                writer.newLine();
            }
            System.out.println("Dados salvos no arquivo: " + caminhoArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    // Lê o conteúdo de um arquivo e retorna como lista de strings
    public static List<String> carregarDoArquivo(String caminhoArquivo) {
        List<String> conteudo = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                conteudo.add(linha);
            }
            System.out.println("Dados carregados do arquivo: " + caminhoArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao carregar os dados: " + e.getMessage());
        }
        return conteudo;
    }
}

