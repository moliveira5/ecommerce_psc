package business.services;

import java.util.Scanner;

import business.entities.Cartao;
import data.repository.GerenciadorDeCartao;

public class CartaoService {

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

    public Cartao ObterCartaoPorClienteId(int clienteId)
    {
        GerenciadorDeCartao pagamento = new GerenciadorDeCartao();
        Cartao cartao = pagamento.ObterCartaoPorClienteId(clienteId);
        return cartao;
    }
    
}
