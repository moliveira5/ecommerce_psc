package business.services;

import java.util.Scanner;
import business.entities.Endereco;
import data.repository.GerenciadorDeEndereco;

/**
 * Serviço responsável por operações relacionadas a endereços.
 */
public class EnderecosService {
    /**
     * Cria um novo endereço a partir dos dados fornecidos pelo usuário e o insere no banco de dados.
     *
     * @param scanner              Scanner para ler entrada do usuário.
     * @param gerenciadorDeEndereco Gerenciador de endereços para realizar operações no banco de dados.
     * @param clienteId            ID do cliente associado ao endereço.
     * @return O objeto Endereco criado e inserido.
     */
    public Endereco criarEndereco(Scanner scanner, GerenciadorDeEndereco gerenciadorDeEndereco, int clienteId) {
        System.out.print("Endereço Completo: ");
        String enderecoCompleto = scanner.nextLine();

        Endereco novoEndereco = new Endereco(enderecoCompleto);
        gerenciadorDeEndereco.inserirEndereco(novoEndereco, clienteId);
        return novoEndereco;
    }
}
