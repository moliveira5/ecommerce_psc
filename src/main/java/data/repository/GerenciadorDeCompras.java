package data.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import business.entities.Compra;
import data.Database;

public class GerenciadorDeCompras {

    public Compra inserirCompra(Compra compra) {
        try (Connection connection = Database.getConnection()) {
            String sql = "INSERT INTO compras (clienteId, totalCompra) VALUES (?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, compra.getClienteId());
                stmt.setDouble(2, compra.getTotalCompra());
                stmt.executeUpdate();

                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        compra.setId(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return compra;
    }

    public void inserirItemCompra(int compraId, int produtoId, int quantidade) {
        try (Connection connection = Database.getConnection()) {
            String sql = "INSERT INTO itens_compra (compraId, produtoId, quantidade) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, compraId);
                stmt.setInt(2, produtoId);
                stmt.setInt(3, quantidade);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarComprasPorCliente(int clienteId) {
        try (Connection connection = Database.getConnection()) {
            String sql = "SELECT * FROM compras WHERE clienteId = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, clienteId);
                try (ResultSet rs = stmt.executeQuery()) {

                    if (!rs.isBeforeFirst()) {
                        System.out.println("Não há compras passadas para este cliente.");
                        return;
                    }

                    String leftAlignFormat = "| %-4d | %-20s | %-15.2f |%n";
                    System.out.format("+------+----------------------+------------------+%n");
                    System.out.format("| ID   | Data da Compra       | Total da Compra  |%n");
                    System.out.format("+------+----------------------+------------------+%n");

                    while (rs.next()) {
                        System.out.format(leftAlignFormat,
                                rs.getInt("id"),
                                rs.getTimestamp("dataCompra"),
                                rs.getDouble("totalCompra"));
                    }

                    System.out.format("+------+----------------------+------------------+%n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
