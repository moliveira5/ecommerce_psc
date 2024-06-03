package business.services;

import java.util.Scanner;

import javax.management.InvalidApplicationException;

import business.entities.Carrinho;
import business.entities.Checkout;
import business.entities.Cliente;
import business.entities.Endereco;
import business.entities.Pagamento;
import business.entities.PagamentoCartao;
import business.entities.Parcela;
import business.settings.MetodoPagamentoEnum;
import data.repository.GerenciadorDeCliente;

public class CheckoutService {

    public void FazerCheckout(Scanner scanner, Carrinho carrinho)
    {
        System.out.print("Informe seu email: ");
        String email = scanner.nextLine().toLowerCase();
        Cliente clienteAtual = DefinirClienteDaCompra(scanner, email);

        if (!carrinho.estaVazio()) {
            double valorTotal = carrinho.calcularTotal();
            System.out.println("\nValor total da compra: " + valorTotal);

            
            



                        System.out.print("Número do cartão: ");
                        String numero = scanner.nextLine();
                        System.out.print("Nome do titular: ");
                        String nomeTitular = scanner.nextLine();
                        System.out.print("Data de validade (MM/AA): ");
                        String dataValidade = scanner.nextLine();
                        System.out.print("CVV: ");
                        String cvv = scanner.nextLine();
                        PagamentoCartao cartao = new PagamentoCartao(numero, nomeTitular, dataValidade, cvv);

                        System.out.print("Número de parcelas: ");
                        int numeroParcelas = scanner.nextInt();
                        System.out.print("Valor da parcela: ");
                        double valorParcela = scanner.nextDouble();
                        Parcela parcela = new Parcela(numeroParcelas, valorParcela);

                        Pagamento metodoPagamento = new Pagamento(cartao, parcela);

                        Checkout checkout = new Checkout(carrinho, clienteAtual, metodoPagamento);
                        checkout.finalizarCompra();
                        carrinho.limparCarrinho();
        } else {
            System.out.println("Carrinho vazio. Adicione produtos ao carrinho antes de finalizar a compra.");
        }
    }

    public Cliente DefinirClienteDaCompra (Scanner scanner, String emailCliente)
    {
        GerenciadorDeCliente gerenciadorDeCliente = new GerenciadorDeCliente();

        Cliente clienteAtual = gerenciadorDeCliente.ObterPorEmail(emailCliente);

        if (clienteAtual == null) {
            System.out.print("Informe seu nome: ");
            String nome = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();

            clienteAtual = new Cliente(0, nome, cpf, email, telefone, new Endereco(endereco).toString());
        }

        return clienteAtual;
    }

    public Pagamento DefinirMetodoDePagamento (Scanner scanner)
    {
        System.out.println("Escolha o método de pagamento:");
        System.out.println("0 - Cadastrar novo pagamento");
        System.out.println("1 - Cartão");
        System.out.println("2 - Boleto");
        int metodoPagamento = scanner.nextInt();

        if (metodoPagamento == MetodoPagamentoEnum.NOVO.getValor())
        {
            //Chama construtor para criar novo metodo pagamento
        }
        else if (metodoPagamento == MetodoPagamentoEnum.CARTAO.getValor())
        {
            //retorna dados do cartao e pergunta se quer utilizar esse mesmo
        }
        else if (metodoPagamento == MetodoPagamentoEnum.BOLETO.getValor())
        {

        }
        else 
            return null;
            //InvalidApplicationException("Método de Pagamento Inválido!");



        return null;
    }


    
}
