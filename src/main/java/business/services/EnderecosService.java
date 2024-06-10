package business.services;

import java.util.Scanner;

import business.entities.Endereco;
import data.repository.GerenciadorDeEndereco;

public class EnderecosService {

    public Endereco criarEndereco(Scanner scanner, GerenciadorDeEndereco gerenciadorDeEndereco, int clienteId) {
        System.out.print("Endereço Completo: ");
        String enderecoCompleto = scanner.nextLine();

        Endereco novoEndereco = new Endereco(enderecoCompleto);
        gerenciadorDeEndereco.inserirEndereco(novoEndereco, clienteId);
        return novoEndereco;
    }
}
