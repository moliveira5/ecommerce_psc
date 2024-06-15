package business.services;

import java.util.Scanner;

import business.entities.Cliente;
import data.repository.GerenciadorDeCliente;

public class ClientesService {

    public Cliente Loggin(Scanner scanner)
    {
        GerenciadorDeCliente gerenciadorDeCliente = new GerenciadorDeCliente();

        System.out.println("Menu de Login:");
        System.out.println("1. Login");
        System.out.println("2. Criar Conta");
        System.out.println("3. Seguir sem Login");
        System.out.print("Escolha uma opção: ");
        int opcaoLogin = scanner.nextInt();
        scanner.nextLine();

        Cliente clienteAtual = null;

        switch (opcaoLogin) {
            case 1:
                System.out.print("Email: ");
                String emailLogin = scanner.nextLine();
                System.out.print("Senha: ");
                String senhaLogin = scanner.nextLine();
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
                System.out.println("Seguindo sem login.");
                clienteAtual = new Cliente(0, 0, "Visitante", "", "", "", "");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }

        return clienteAtual;
    }

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
