package data.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE_NAME = "loja_esportes";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(URL + DATABASE_NAME, USER, PASSWORD);

            if (!databaseExists(connection, DATABASE_NAME)) {
                createDatabase();
                connection = DriverManager.getConnection(URL + DATABASE_NAME, USER, PASSWORD);
            }

            return connection;
        } catch (SQLException e) {
            System.err.println("Erro ao estabelecer a conexão com o banco de dados: " + e.getMessage());
            return null;
        }
    }

    private static boolean databaseExists(Connection connection, String databaseName) throws SQLException {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SHOW DATABASES")) {
            while (resultSet.next()) {
                String dbName = resultSet.getString(1);
                if (dbName.equals(databaseName)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void createDatabase() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE DATABASE " + DATABASE_NAME);
            System.out.println("Banco de dados '" + DATABASE_NAME + "' criado com sucesso.");
        }
    }

    public static void createTables() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            String createTableProdutos = "CREATE TABLE IF NOT EXISTS produtos ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "nome VARCHAR(100),"
                    + "modelo VARCHAR(100),"
                    + "categoria VARCHAR(100),"
                    + "marca VARCHAR(100),"
                    + "preco DOUBLE,"
                    + "tamanhoNumerico INT,"
                    + "tamanho CHAR(1)"
                    + ")";
            statement.execute(createTableProdutos);

            String createTableClientes = "CREATE TABLE IF NOT EXISTS clientes ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "nome VARCHAR(100),"
                    + "cpf VARCHAR(14),"
                    + "email VARCHAR(100),"
                    + "telefone VARCHAR(20),"
                    + "endereco VARCHAR(255)"
                    + ")";
            statement.execute(createTableClientes);

            String createTableCartoes = "CREATE TABLE IF NOT EXISTS cartoes ("
                    + "numero VARCHAR(16) PRIMARY KEY,"
                    + "nomeTitular VARCHAR(100),"
                    + "dataValidade VARCHAR(7),"
                    + "cvv VARCHAR(3)"
                    + ")";
            statement.execute(createTableCartoes);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createTables();
    }
}
