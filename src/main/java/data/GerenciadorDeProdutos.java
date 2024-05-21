package data;

import java.sql.*;
import java.util.Scanner;

public class GerenciadorDeProdutos {
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
        scanner.nextLine();

        try (Connection connection = Database.getConnection()) {
            String sql = "INSERT INTO produtos (nome, modelo, categoria, marca, preco, tamanhoNumerico, tamanho) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, nome);
                stmt.setString(2, modelo);
                stmt.setString(3, categoria);
                stmt.setString(4, marca);
                stmt.setDouble(5, preco);
                stmt.setInt(6, tamanhoNumerico);
                stmt.setString(7, String.valueOf(tamanho));
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterarProduto(Scanner scanner) {
        System.out.print("ID do produto a alterar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try (Connection connection = Database.getConnection()) {
            String sql = "UPDATE produtos SET nome = ?, modelo = ?, categoria = ?, marca = ?, preco = ?, tamanhoNumerico = ?, tamanho = ? WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                System.out.print("Novo nome: ");
                stmt.setString(1, scanner.nextLine());
                System.out.print("Novo modelo: ");
                stmt.setString(2, scanner.nextLine());
                System.out.print("Nova categoria: ");
                stmt.setString(3, scanner.nextLine());
                System.out.print("Nova marca: ");
                stmt.setString(4, scanner.nextLine());
                System.out.print("Novo preço: ");
                stmt.setDouble(5, scanner.nextDouble());
                System.out.print("Novo tamanho numérico: ");
                stmt.setInt(6, scanner.nextInt());
                System.out.print("Novo tamanho: ");
                stmt.setString(7, String.valueOf(scanner.next().charAt(0)));
                scanner.nextLine();
                stmt.setInt(8, id);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Produto alterado com sucesso.");
                } else {
                    System.out.println("Produto não encontrado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerProduto(Scanner scanner) {
        System.out.print("ID do produto a remover: ");
        int id = scanner.nextInt();

        try (Connection connection = Database.getConnection()) {
            String sql = "DELETE FROM produtos WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Produto removido com sucesso.");
                } else {
                    System.out.println("Produto não encontrado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarProdutos() {
        try (Connection connection = Database.getConnection()) {
            String sql = "SELECT * FROM produtos";
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                String leftAlignFormat = "| %-4d | %-20s | %-10s | %-15s | %-10s | %-10.2f | %-15d | %-7s |%n";
                System.out.format("+------+----------------------+------------+-----------------+------------+------------+-----------------+---------+%n");
                System.out.format("| ID   | Nome                 | Modelo     | Categoria       | Marca      | Preço      | Tamanho Numérico| Tamanho |%n");
                System.out.format("+------+----------------------+------------+-----------------+------------+------------+-----------------+---------+%n");

                while (rs.next()) {
                    System.out.format(leftAlignFormat,
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("modelo"),
                            rs.getString("categoria"),
                            rs.getString("marca"),
                            rs.getDouble("preco"),
                            rs.getInt("tamanhoNumerico"),
                            rs.getString("tamanho"));
                }

                System.out.format("+------+----------------------+------------+-----------------+------------+------------+-----------------+---------+%n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Produto getProdutoById(int id) {
        Produto produto = null;
        try (Connection connection = Database.getConnection()) {
            String sql = "SELECT * FROM produtos WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        produto = new Produto(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("modelo"),
                                rs.getString("categoria"),
                                rs.getString("marca"),
                                rs.getDouble("preco"),
                                rs.getInt("tamanhoNumerico"),
                                rs.getString("tamanho").charAt(0)
                        );
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produto;
    }
}
