package business.services;

import java.io.Console; 
import java.util.Scanner;
import business.entities.Cliente;
import data.repository.GerenciadorDeCliente;

/**
 * Serviço responsável por operações relacionadas a clientes.
 */
public class ClientesService {
    /**
     * Realiza o processo de login de um cliente.
     *
     * @param scanner       Scanner para ler entrada do usuário.
     * @param WithtNotLogin Boolean para verificar se pode seguir sem login.
     * @return Cliente logado, ou null se o login falhar.
     */
    public Cliente Loggin(Scanner scanner, boolean WithtNotLogin)
    {
        GerenciadorDeCliente gerenciadorDeCliente = new GerenciadorDeCliente();
        Console con = System.console(); 

        System.out.println("Menu de Login:");
        System.out.println("1. Login");
        System.out.println("2. Criar Conta");
        if (WithtNotLogin) System.out.println("3. Seguir sem Login");
        System.out.print("Escolha uma opção: ");
        int opcaoLogin = scanner.nextInt();
        scanner.nextLine();

        Cliente clienteAtual = null;

        switch (opcaoLogin) {
            case 1:
                System.out.print("Email: ");
                String emailLogin = scanner.nextLine();
                System.out.print("Senha: ");
                char[] ch = con.readPassword();
                String senhaLogin = String.valueOf(ch);
                clienteAtual = gerenciadorDeCliente.obterPorEmail(emailLogin);
                if (clienteAtual != null && clienteAtual.getSenha().equals(senhaLogin)) {
                    System.out.println("Login realizado com sucesso.");
                } else {
                    System.out.println("Email ou senha incorretos.");
                    clienteAtual = null;
                }
                break;
            case 2:
                clienteAtual = criarConta(scanner, gerenciadorDeCliente, null);
                break;
            case 3:
            if (WithtNotLogin) {
                System.out.println("Seguindo sem login.");
                clienteAtual = new Cliente(0, 0, "Visitante", "", "", "", "");
                break;
            } else {
                System.out.println("Opção inválida.");
                break;
            }
            default:
                System.out.println("Opção inválida.");
                break;
        }

        return clienteAtual;
    }

    /**
     * Cria uma nova conta de cliente.
     *
     * @param scanner             Scanner para ler entrada do usuário.
     * @param gerenciadorDeCliente Gerenciador de clientes para realizar operações no banco de dados.
     * @param email               Email do cliente (pode ser null se não foi fornecido anteriormente).
     * @return O novo Cliente criado e inserido no banco de dados.
     */
    public Cliente criarConta(Scanner scanner, GerenciadorDeCliente gerenciadorDeCliente, String email) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        if (email == null || email.isEmpty()) {
            System.out.print("Email: ");
            email = scanner.nextLine();
        }
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        

        Cliente novoCliente = new Cliente(0, 1, nome, cpf, email, telefone, senha);
        gerenciadorDeCliente.inserirCliente(novoCliente);
        return novoCliente;
    }
}
