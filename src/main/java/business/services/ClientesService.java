package business.services;

import java.util.Scanner;

import business.entities.Cliente;
import data.repository.GerenciadorDeCliente;

public class ClientesService {

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
