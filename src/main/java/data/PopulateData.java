package data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import business.entities.Cliente;
import data.repository.GerenciadorDeCliente;

/**
 * Classe responsável por popular o banco de dados com dados iniciais para teste
 * ou inicialização do sistema.
 */
public class PopulateData {
        /**
         * Método estático para popular o banco de dados com dados iniciais.
         */
        public static void populate() {
                try (Connection connection = Database.getConnection();
                                Statement statement = connection.createStatement()) {

                        GerenciadorDeCliente gerenciadorDeCliente = new GerenciadorDeCliente();
                        Cliente cliente = gerenciadorDeCliente.obterPorEmail("marina.guimaraes@gmail.com");
     
                        if (cliente != null)
                                return;

                        String insertClientes = "INSERT INTO loja_esportes.clientes VALUES "
                                        + "(NULL, 0, 'Marina Guimarães', '217.890.027-75', 'marina.guimaraes@gmail.com', '00000000', '(31) 99999-9990'),"
                                        + "(NULL, 0, 'Victor Iki', '328.901.138-86', 'victor.iki@gmail.com', '11111111', '(31) 99999-9991'),"
                                        + "(NULL, 0, 'Giulia Huguinim', '439.012.249-97', 'giulia.huguinim@gmail.com', '22222222', '(31) 99999-9992'),"
                                        + "(NULL, 0, 'João Rodrigues', '540.123.350-08', 'joao.rodrigues@gmail.com', '33333333', '(31) 99999-9993'),"
                                        + "(NULL, 0, 'Felipe Tavares', '651.234.461-19', 'felipe.tavares@gmail.com', '44444444', '(31) 99999-9994');";
                        statement.executeUpdate(insertClientes);

                        String insertProdutos = "INSERT INTO loja_esportes.produtos VALUES "
                                        + "(NULL, 'Camisa Corinthians Nike', 'Corinthians I 2023/24 Torcedor', 'Camisa', 'Nike', 299.00, NULL, 'M'),"
                                        + "(NULL, 'Camisa Corinthians Nike', 'Corinthians I 2023/24 Torcedor', 'Camisa', 'Nike', 299.00, NULL, 'P'),"
                                        + "(NULL, 'Camisa Corinthians Nike', 'Corinthians I 2023/24 Torcedor', 'Camisa', 'Nike', 299.00, NULL, 'G'),"
                                        + "(NULL, 'Camisa PSG Nike', 'PSG I 2023/24 Torcedor', 'Camisa', 'Nike', 399.00, NULL, 'P'),"
                                        + "(NULL, 'Camisa PSG Nike', 'PSG I 2023/24 Torcedor', 'Camisa', 'Nike', 399.00, NULL, 'M'),"
                                        + "(NULL, 'Camisa PSG Nike', 'PSG I 2023/24 Torcedor', 'Camisa', 'Nike', 399.00, NULL, 'G'),"
                                        + "(NULL, 'Camisa Polo Brasil', 'Polo Sportswear Brasil', 'Camisa', 'Nike', 349.00, NULL, 'P'),"
                                        + "(NULL, 'Camisa Polo Brasil', 'Polo Sportswear Brasil', 'Camisa', 'Nike', 349.00, NULL, 'M'),"
                                        + "(NULL, 'Camisa Polo Brasil', 'Polo Sportswear Brasil', 'Camisa', 'Nike', 349.00, NULL, 'G'),"
                                        + "(NULL, 'Bola Nike Futsal Pro', 'Bola Nike Futsal Pro', 'Bola', 'Nike', 299.99, NULL, NULL),"
                                        + "(NULL, 'Boné Jordan Club Unissex', 'Boné Jordan Club Unissex', 'Boné', 'Nike', 179.99, NULL, NULL),"
                                        + "(NULL, 'Tênis Air max', 'Air max', 'Calçados', 'Nike', 560.00, 37, NULL),"
                                        + "(NULL, 'Tênis Air max', 'Air max', 'Calçados', 'Nike', 560.00, 38, NULL),"
                                        + "(NULL, 'Tênis Air max', 'Air max', 'Calçados', 'Nike', 560.00, 39, NULL),"
                                        + "(NULL, 'Tênis Air max', 'Air max', 'Calçados', 'Nike', 560.00, 40, NULL),"
                                        + "(NULL, 'Tênis Air max', 'Air max', 'Calçados', 'Nike', 560.00, 42, NULL),"
                                        + "(NULL, 'Camisa CR Flamengo 24/25', '1 CR Flamengo 24/25', 'Camisa', 'Adidas', 349.00, NULL, 'P'),"
                                        + "(NULL, 'Camisa CR Flamengo 24/25', '1 CR Flamengo 24/25', 'Camisa', 'Adidas', 349.00, NULL, 'M'),"
                                        + "(NULL, 'Camisa CR Flamengo 24/25', '1 CR Flamengo 24/25', 'Camisa', 'Adidas', 349.00, NULL, 'G'),"
                                        + "(NULL, 'Camisa Atlético Mineiro 24/25', '1 Atlético Mineiro 24/25', 'Camisa', 'Adidas', 349.00, NULL, 'P'),"
                                        + "(NULL, 'Camisa Atlético Mineiro 24/25', '1 Atlético Mineiro 24/25', 'Camisa', 'Adidas', 349.00, NULL, 'M'),"
                                        + "(NULL, 'Camisa Atlético Mineiro 24/25', '1 Atlético Mineiro 24/25', 'Camisa', 'Adidas', 349.00, NULL, 'G'),"
                                        + "(NULL, 'Camisa Cruzeiro 24/25', '1 Cruzeiro 24/25', 'Camisa', 'Adidas', 349.00, NULL, 'P'),"
                                        + "(NULL, 'Camisa Cruzeiro 24/25', '1 Cruzeiro 24/25', 'Camisa', 'Adidas', 349.00, NULL, 'M'),"
                                        + "(NULL, 'Camisa Cruzeiro 24/25', '1 Cruzeiro 24/25', 'Camisa', 'Adidas', 349.00, NULL, 'G'),"
                                        + "(NULL, 'Bola de Basquete All Court', 'All Court 3.0', 'Bola', 'Adidas', 279.99, NULL, NULL),"
                                        + "(NULL, 'Bucket Adicolor Classic', 'Adicolor Classic', 'Chapéu', 'Adidas', 199.99, NULL, NULL),"
                                        + "(NULL, 'Tênis Grand Court', 'Grand Court', 'Calçados', 'Adidas', 399.00, 37, NULL),"
                                        + "(NULL, 'Tênis Grand Court', 'Grand Court', 'Calçados', 'Adidas', 399.00, 38, NULL),"
                                        + "(NULL, 'Tênis Grand Court', 'Grand Court', 'Calçados', 'Adidas', 399.00, 39, NULL),"
                                        + "(NULL, 'Tênis Grand Court', 'Grand Court', 'Calçados', 'Adidas', 399.00, 40, NULL),"
                                        + "(NULL, 'Tênis Grand Court', 'Grand Court', 'Calçados', 'Adidas', 399.00, 42, NULL),"
                                        + "(NULL, 'Polo Scuderia Ferrari Team', 'Polo Scuderia Ferrari Team', 'Camisa', 'Puma', 449.90, NULL, 'P'),"
                                        + "(NULL, 'Polo Scuderia Ferrari Team', 'Polo Scuderia Ferrari Team', 'Camisa', 'Puma', 449.90, NULL, 'M'),"
                                        + "(NULL, 'Polo Scuderia Ferrari Team', 'Polo Scuderia Ferrari Team', 'Camisa', 'Puma', 449.90, NULL, 'G'),"
                                        + "(NULL, 'Camisa Manchester City 23/24', 'Manchester City 23/24 HOME Torcedor', 'Camisa', 'Puma', 399.00, NULL, 'P'),"
                                        + "(NULL, 'Camisa Manchester City 23/24', 'Manchester City 23/24 HOME Torcedor', 'Camisa', 'Puma', 399.00, NULL, 'M'),"
                                        + "(NULL, 'Camisa Manchester City 23/24', 'Manchester City 23/24 HOME Torcedor', 'Camisa', 'Puma', 399.00, NULL, 'G'),"
                                        + "(NULL, 'Camisa Al Hilal HOME,', 'Al Hilal HOME', 'Camisa', 'Puma', 399.00, NULL, 'P'),"
                                        + "(NULL, 'Camisa Al Hilal HOME,', 'Al Hilal HOME', 'Camisa', 'Puma', 399.00, NULL, 'M'),"
                                        + "(NULL, 'Camisa Al Hilal HOME,', 'Al Hilal HOME', 'Camisa', 'Puma', 399.00, NULL, 'G'),"
                                        + "(NULL, 'Boné Neymar Jr', 'Neymar Jr', 'Boné', 'Puma', 129.00, NULL, NULL),"
                                        + "(NULL, 'Bola de Futebol Neymar Jr. Voltage Graphic', 'Neymar Jr. Voltage Graphic', 'Bola', 'Puma', 119.00, NULL, NULL),"
                                        + "(NULL, 'Tênis Electrify NITRO3', 'Electrify NITRO3', 'Calçados', 'Puma', 599.00, 37, NULL),"
                                        + "(NULL, 'Tênis Electrify NITRO3', 'Electrify NITRO3', 'Calçados', 'Puma', 599.00, 38, NULL),"
                                        + "(NULL, 'Tênis Electrify NITRO3', 'Electrify NITRO3', 'Calçados', 'Puma', 599.00, 39, NULL),"
                                        + "(NULL, 'Tênis Electrify NITRO3', 'Electrify NITRO3', 'Calçados', 'Puma', 599.00, 40, NULL),"
                                        + "(NULL, 'Tênis Electrify NITRO3', 'Electrify NITRO3', 'Calçados', 'Puma', 599.00, 42, NULL);";
                        statement.executeUpdate(insertProdutos);

                        String insertCartoes = "INSERT INTO loja_esportes.cartoes VALUES "
                                        + "('0000 0000 0000 0001', 'Marina Guimarães', '01/2025', '111', 1),"
                                        + "('0000 0000 0000 0002', 'Victor Iki', '02/2025', '222', 2),"
                                        + "('0000 0000 0000 0003', 'Giulia Huguinim', '03/2025', '333', 3),"
                                        + "('0000 0000 0000 0004', 'João Rodrigues', '04/2025', '444', 4),"
                                        + "('0000 0000 0000 0005', 'Felipe Tavares', '05/2025', '555', 5);";
                        statement.executeUpdate(insertCartoes);

                        String insertCompras = "INSERT INTO loja_esportes.compras VALUES "
                                        + "(NULL, 1, '2024-06-01 12:00:00', 1107.98),"
                                        + "(NULL, 2, '2024-06-05 12:00:00', 657.98),"
                                        + "(NULL, 3, '2024-06-11 12:00:00', 119);";
                        statement.executeUpdate(insertCompras);

                        String insertEnderecos = "INSERT INTO loja_esportes.enderecos VALUES "
                                        + "(NULL, 'Rua Ficticia, 001 - Bairro Inventado, Cidade Qualquer - Estado Algum', 1),"
                                        + "(NULL, 'Rua Ficticia, 002 - Bairro Inventado, Cidade Qualquer - Estado Algum', 2),"
                                        + "(NULL, 'Rua Ficticia, 003 - Bairro Inventado, Cidade Qualquer - Estado Algum', 3),"
                                        + "(NULL, 'Rua Ficticia, 004 - Bairro Inventado, Cidade Qualquer - Estado Algum', 4),"
                                        + "(NULL, 'Rua Ficticia, 005 - Bairro Inventado, Cidade Qualquer - Estado Algum', 5);";
                        statement.executeUpdate(insertEnderecos);

                        String insertItensCompra = "INSERT INTO loja_esportes.itens_compra VALUES "
                                        + "(1, 21, 1),"
                                        + "(1, 11, 2),"
                                        + "(1, 32, 1),"
                                        + "(2, 27, 2),"
                                        + "(2, 42, 2),"
                                        + "(3, 43, 1);";
                        statement.executeUpdate(insertItensCompra);
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
}
