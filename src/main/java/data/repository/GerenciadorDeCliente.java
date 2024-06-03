package data.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.entities.Cliente;
import data.Database;

public class GerenciadorDeCliente {

    public Cliente ObterPorEmail(String email)
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
                                rs.getString("nome"),
                                rs.getString("cpf"),
                                rs.getString("email"),
                                rs.getString("telefone"),
                                rs.getString("endereco")
                        );
                    }
                }
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
        
    }
    
}
