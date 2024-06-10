package business.services;

import java.util.Scanner;

import business.entities.Cartao;
import data.repository.GerenciadorDeCliente;
import data.repository.GerenciadorDePagamento;

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

        GerenciadorDePagamento pagamento = new GerenciadorDePagamento();
        pagamento.SetarNovoPagamentoCartao(cartao, clienteId);

        return cartao;
    }

    public Cartao ObterCartaoPorClienteId(int clienteId)
    {
        GerenciadorDePagamento pagamento = new GerenciadorDePagamento();
        Cartao cartao = pagamento.ObterCartaoPorClienteId(clienteId);
        return cartao;
    }
    
}
