package business.services;

import java.util.Scanner;
import business.entities.Cartao;
import data.repository.GerenciadorDeCartao;

/**
 * Serviço responsável por gerenciar operações relacionadas aos cartões de pagamento.
 */
public class CartaoService {
    /**
     * Permite cadastrar um novo cartão de pagamento para um cliente.
     *
     * @param scanner   Scanner para ler entrada do usuário.
     * @param clienteId ID do cliente para associar o cartão.
     * @return Cartão cadastrado.
     */
    public Cartao CadastrarNovoPagamentoCartao(Scanner scanner, int clienteId)
    {
        System.out.print("Número do cartão: ");
        String numero = scanner.nextLine();
        System.out.print("Nome do titular: ");
        String nomeTitular = scanner.nextLine();
        System.out.print("Data de validade (MM/AA): ");
        String dataValidade = scanner.nextLine();
        System.out.print("CVV: ");
        String cvv = scanner.nextLine();
        Cartao cartao = new Cartao(numero, nomeTitular, dataValidade, cvv);

        GerenciadorDeCartao pagamento = new GerenciadorDeCartao();
        pagamento.AdicionarNovoCartao(cartao, clienteId);

        return cartao;
    }

    /**
     * Obtém o cartão de pagamento associado a um cliente pelo ID do cliente.
     *
     * @param clienteId ID do cliente.
     * @return Cartão de pagamento encontrado ou null se não encontrado.
     */
    public Cartao ObterCartaoPorClienteId(int clienteId)
    {
        GerenciadorDeCartao pagamento = new GerenciadorDeCartao();
        Cartao cartao = pagamento.ObterCartaoPorClienteId(clienteId);
        return cartao;
    }
    
}
