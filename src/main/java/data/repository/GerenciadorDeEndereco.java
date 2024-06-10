package data.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import business.entities.Endereco;
import data.Database;

public class GerenciadorDeEndereco {

    public Endereco obterPorId(int id) {
        Endereco endereco = null;
        try (Connection connection = Database.getConnection()) {
            String sql = "SELECT * FROM enderecos WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        endereco = new Endereco(
                                rs.getString("enderecoCompleto")
                        );
                        endereco.setId(rs.getInt("id"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return endereco;
    }

    public void inserirEndereco(Endereco endereco, int clienteId) {
        try (Connection connection = Database.getConnection()) {
            String sql = "INSERT INTO enderecos (enderecoCompleto, clienteId) VALUES (?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, endereco.getEnderecoCompleto());
                stmt.setInt(2, clienteId);
                stmt.executeUpdate();

                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        endereco.setId(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarEnderecoPorId(int id, String novoEnderecoCompleto) {
        try (Connection connection = Database.getConnection()) {
            String sql = "UPDATE enderecos SET enderecoCompleto = ? WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, novoEnderecoCompleto);
                stmt.setInt(2, id);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
