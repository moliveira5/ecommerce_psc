package data.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import business.entities.Cartao;
import data.Database;

/**
 * Esta classe contém métodos para realizar operações de gerenciamento de cartões no banco de dados.
 */
public class GerenciadorDeCartao {
    /**
     * Adiciona um novo cartão ao banco de dados para um cliente específico.
     *
     * @param cartao    Objeto Cartao contendo as informações do cartão a ser adicionado
     * @param clienteId ID do cliente ao qual o cartão está associado
     */
    public void AdicionarNovoCartao(Cartao cartao, int clienteId)
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

    /**
     * Obtém um cartão do banco de dados com base no número do cartão.
     *
     * @param numero Número do cartão a ser procurado
     * @return Objeto Cartao correspondente ao número fornecido, ou null se não encontrado
     */
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

    /**
     * Obtém o cartão associado a um cliente específico no banco de dados.
     *
     * @param clienteId ID do cliente para o qual o cartão será obtido
     * @return Objeto Cartao associado ao cliente fornecido, ou null se não encontrado
     */
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
