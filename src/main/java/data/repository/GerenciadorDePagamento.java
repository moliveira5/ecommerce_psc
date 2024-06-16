package data.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import business.entities.Cartao;
import data.Database;

/**
 * Esta classe contém métodos para gerenciar operações relacionadas a pagamentos com cartão no banco de dados.
 */
public class GerenciadorDePagamento {
    /**
     * Insere um novo cartão de pagamento associado a um cliente no banco de dados.
     *
     * @param cartao    Objeto Cartao contendo as informações do cartão a ser inserido
     * @param clienteId ID do cliente associado ao cartão
     */
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

    /**
     * Obtém um cartão de pagamento pelo número do cartão.
     *
     * @param numero Número do cartão a ser procurado
     * @return Objeto Cartao se encontrado, caso contrário null
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
     * Obtém um cartão de pagamento pelo ID do cliente associado.
     *
     * @param clienteId ID do cliente associado ao cartão
     * @return Objeto Cartao se encontrado, caso contrário null
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
