package data.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.entities.Cartao;
import data.Database;

public class GerenciadorDePagamento {

    public void SetarNovoPagamentoCartao(Cartao cartao, int clienteId)
    {
        try (Connection connection = Database.getConnection()) {
            String sql = "INSERT INTO cartoes (numero, nomeTitular, dataValidade, cvv, clienteId) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, cartao.getNumero());
                stmt.setString(2, cartao.getNomeTitular());
                stmt.setString(3, cartao.getDataValidade());
                stmt.setString(4, cartao.getCvv());
                stmt.setInt(5, clienteId);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cartao ObterCartaoPorNumero(String numero)
    {
        Cartao cartao = null;

        try (Connection connection = Database.getConnection()) {
            String sql = "SELECT * FROM cartoes WHERE numero = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, numero);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        cartao = new Cartao(
                                rs.getString("numero"),
                                rs.getString("nomeTitular"),
                                rs.getString("dataValidade"),
                                rs.getString("cvv")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartao;
    }

    public Cartao ObterCartaoPorClienteId(int clienteId)
    {
        Cartao cartao = null;

        try (Connection connection = Database.getConnection()) {
            String sql = "SELECT * FROM cartoes WHERE clienteId = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, clienteId);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        cartao = new Cartao(
                                rs.getString("numero"),
                                rs.getString("nomeTitular"),
                                rs.getString("dataValidade"),
                                rs.getString("cvv")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartao;
    }
    
    
}
