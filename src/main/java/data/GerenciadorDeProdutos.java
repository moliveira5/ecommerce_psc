package data;

import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.Json;
import javax.json.JsonValue;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeProdutos {
    private List<Produto> produtos;
    private static final String FILE_PATH = "src/main/resources/produtos.json";

    public GerenciadorDeProdutos() {
        this.produtos = new ArrayList<>();
        carregarProdutos();
    }

    public void inserirProduto(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        System.out.print("Tamanho Numérico: ");
        int tamanhoNumerico = scanner.nextInt();
        System.out.print("Tamanho: ");
        char tamanho = scanner.next().charAt(0);

        Produto produto = new Produto(1 , nome, modelo, categoria, marca, preco, tamanhoNumerico, tamanho);
        produtos.add(produto);
        System.out.println("Produto inserido com sucesso.");
        salvarProdutos();
    }

    public void alterarProduto(Scanner scanner) {
        System.out.print("ID do produto a alterar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                System.out.print("Novo nome: ");
                produto.setNome(scanner.nextLine());
                System.out.print("Novo modelo: ");
                produto.setModelo(scanner.nextLine());
                System.out.print("Nova categoria: ");
                produto.setCategoria(scanner.nextLine());
                System.out.print("Nova marca: ");
                produto.setMarca(scanner.nextLine());
                System.out.print("Novo preço: ");
                produto.setPreco(scanner.nextDouble());
                System.out.print("Novo tamanho numérico: ");
                produto.setTamanhoNumerico(scanner.nextInt());
                System.out.print("Novo tamanho: ");
                produto.setTamanho(scanner.next().charAt(0));
                scanner.nextLine();

                System.out.println("Produto alterado com sucesso.");
                salvarProdutos();
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    public void removerProduto(Scanner scanner) {
        System.out.print("ID do produto a remover: ");
        int id = scanner.nextInt();

        produtos.removeIf(produto -> produto.getId() == id);
        System.out.println("Produto removido com sucesso.");
        salvarProdutos();
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto disponível.");
            return;
        }
    
        String leftAlignFormat = "| %-4d | %-20s | %-10s | %-15s | %-10s | %-10.2f | %-15d | %-7s |%n";
    
        System.out.format("+------+----------------------+------------+-----------------+------------+------------+-----------------+---------+%n");
        System.out.format("| ID   | Nome                 | Modelo     | Categoria       | Marca      | Preço      | Tamanho Numérico| Tamanho |%n");
        System.out.format("+------+----------------------+------------+-----------------+------------+------------+-----------------+---------+%n");
    
        for (Produto produto : produtos) {
            System.out.format(leftAlignFormat, 
                produto.getId(),
                produto.getNome(), 
                produto.getModelo(), 
                produto.getCategoria(), 
                produto.getMarca(), 
                produto.getPreco(), 
                produto.getTamanhoNumerico(), 
                produto.getTamanho()
            );
        }
    
        System.out.format("+------+----------------------+------------+-----------------+------------+------------+-----------------+---------+%n");
    }
    
    private void salvarProdutos() {
        try (JsonWriter writer = Json.createWriter(new FileWriter(FILE_PATH))) {
            JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
            for (Produto produto : produtos) {
                JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder()
                        .add("id", produto.getId())
                        .add("nome", produto.getNome())
                        .add("modelo", produto.getModelo())
                        .add("categoria", produto.getCategoria())
                        .add("marca", produto.getMarca())
                        .add("preco", produto.getPreco())
                        .add("tamanhoNumerico", produto.getTamanhoNumerico())
                        .add("tamanho", String.valueOf(produto.getTamanho()));

                jsonArrayBuilder.add(jsonObjectBuilder);
            }

            JsonArray jsonArray = jsonArrayBuilder.build();
            writer.writeArray(jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarProdutos() {
        try (JsonReader reader = Json.createReader(new FileReader(FILE_PATH))) {
            JsonArray jsonArray = reader.readArray();
            for (JsonValue jsonValue : jsonArray) {
                JsonObject jsonObject = (JsonObject) jsonValue;
                Produto produto = new Produto(
                        jsonObject.getInt("id"),
                        jsonObject.getString("nome"),
                        jsonObject.getString("modelo"),
                        jsonObject.getString("categoria"),
                        jsonObject.getString("marca"),
                        jsonObject.getJsonNumber("preco").doubleValue(),
                        jsonObject.getInt("tamanhoNumerico"),
                        jsonObject.getString("tamanho").charAt(0)
                );
                produtos.add(produto);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de produtos não encontrado. Criando novo arquivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Produto getProdutoById(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }
}
