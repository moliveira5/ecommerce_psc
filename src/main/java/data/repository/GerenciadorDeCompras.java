package data.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import business.entities.Compra;
import data.Database;

/**
 * Esta classe contém métodos para gerenciar operações relacionadas a compras no banco de dados.
 */
public class GerenciadorDeCompras {
    /**
     * Insere uma nova compra no banco de dados.
     *
     * @param compra Objeto Compra contendo as informações da compra a ser inserida
     * @return Objeto Compra atualizado com o ID gerado no banco de dados
     */
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

    /**
     * Insere um item de compra associado a uma compra existente no banco de dados.
     *
     * @param compraId   ID da compra associada ao item
     * @param produtoId  ID do produto a ser associado ao item de compra
     * @param quantidade Quantidade do produto comprada
     */
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

    /**
     * Lista todas as compras realizadas por um cliente específico.
     *
     * @param clienteId ID do cliente para o qual as compras serão listadas
     */
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
