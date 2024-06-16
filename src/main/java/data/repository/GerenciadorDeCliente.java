package data.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.entities.Cartao;
import business.entities.Cliente;
import business.entities.Endereco;
import data.Database;

public class GerenciadorDeCliente {

    public Cliente obterPorEmail(String email)
    {
        Cliente cliente = null;
        try (Connection connection = Database.getConnection()) {
            String sql = "SELECT * FROM clientes WHERE email = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, email);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        cliente = new Cliente(
                                rs.getInt("id"),
                                rs.getInt("nivel"),
                                rs.getString("nome"),
                                rs.getString("cpf"),
                                rs.getString("email"),
                                rs.getString("telefone"),
                                rs.getString("senha")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }

    public void inserirCliente(Cliente cliente)
    {
        try (Connection connection = Database.getConnection()) {
            String sql = "INSERT INTO clientes (nivel, nome, cpf, email, senha, telefone) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, cliente.getNivel());
                stmt.setString(2, cliente.getNome());
                stmt.setString(3, cliente.getCpf());
                stmt.setString(4, cliente.getEmail());
                stmt.setString(5, cliente.getSenha());
                stmt.setString(6, cliente.getTelefone());
                stmt.executeUpdate();

                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        cliente.setId(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Endereco> obterEnderecosPorClienteId(int clienteId) {
        List<Endereco> enderecos = new ArrayList<>();
        try (Connection connection = Database.getConnection()) {
            String sql = "SELECT * FROM enderecos WHERE clienteId = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, clienteId);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Endereco endereco = new Endereco(
                            rs.getString("enderecoCompleto")
                        );
                        enderecos.add(endereco);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enderecos;
    }

    public List<Cartao> obterCartoesPorClienteId(int clienteId) {
        List<Cartao> cartoes = new ArrayList<>();
        try (Connection connection = Database.getConnection()) {
            String sql = "SELECT * FROM cartoes WHERE clienteId = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, clienteId);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Cartao cartao = new Cartao(
                            rs.getString("numero"),
                            rs.getString("dataValidade"),
                            rs.getString("cvv"),
                            rs.getString("nomeTitular")
                        );
                        cartoes.add(cartao);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartoes;
    }

    public void exibirDadosCliente(String email) {
        Cliente cliente = obterPorEmail(email);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.println("Dados do Cliente:");
        String clienteFormat = "| %-26s | %-15s | %-30s | %-15s |%n";
        System.out.format("+----------------------------+-----------------+--------------------------------+-----------------+%n");
        System.out.format("| Nome                       | CPF             | Email                          | Telefone        |%n");
        System.out.format("+----------------------------+-----------------+--------------------------------+-----------------+%n");
        System.out.format(clienteFormat,
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getTelefone());
        System.out.format("+----------------------------+-----------------+--------------------------------+-----------------+%n");

        List<Endereco> enderecos = obterEnderecosPorClienteId(cliente.getId());
        System.out.println("\nEndereços:");
        String enderecoFormat = "| %-95s |%n";
        System.out.format("+-------------------------------------------------------------------------------------------------+%n");
        System.out.format("| Endereço                                                                                        |%n");
        System.out.format("+-------------------------------------------------------------------------------------------------+%n");
        if (enderecos.isEmpty()) {
            System.out.println("Nenhum endereço cadastrado.");
        } else {
            for (Endereco endereco : enderecos) {
                System.out.format(enderecoFormat,
                        endereco.getEnderecoCompleto());
            }
        }
        System.out.format("+-------------------------------------------------------------------------------------------------+%n");

        List<Cartao> cartoes = obterCartoesPorClienteId(cliente.getId());
        System.out.println("\nCartões:");
        String cartaoFormat = "| %-38s | %-11s | %-27s | %10s |%n";
        System.out.format("+----------------------------------------+-------------+-----------------------------+------------+%n");
        System.out.format("| Número                                 | Validade    | Nome do Titular             | CVV        |%n");
        System.out.format("+----------------------------------------+-------------+-----------------------------+------------+%n");
        if (cartoes.isEmpty()) {
            System.out.println("| Nenhum cartão cadastrado.");
        } else {
            for (Cartao cartao : cartoes) {
                System.out.format(cartaoFormat,
                        cartao.getNumero(),
                        cartao.getNomeTitular(),
                        cartao.getCvv(),
                        cartao.getDataValidade());
            }
        }
        System.out.format("+----------------------------------------+-------------+-----------------------------+------------+%n");
    }
    
}
