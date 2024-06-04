package business.services;

import java.util.Scanner;

import javax.management.InvalidApplicationException;

import business.entities.Carrinho;
import business.entities.Checkout;
import business.entities.Cliente;
import business.entities.Endereco;
import business.entities.Pagamento;
import business.entities.Cartao;
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
            carrinho.listarProdutos();
            double valorTotal = carrinho.calcularTotal();
            System.out.println("\nValor total da compra: " + valorTotal);

            Pagamento metodoPagamento = DefinirMetodoDePagamento(scanner, clienteAtual.getId());


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

    public Pagamento DefinirMetodoDePagamento (Scanner scanner, int clienteId)
    {
        System.out.println("Escolha o método de pagamento:");
        System.out.println("0 - Cadastrar novo cartão");
        System.out.println("1 - Cartão");
        System.out.println("2 - Boleto");
        int metodoPagamento = scanner.nextInt();

        CartaoService cartao = new CartaoService();

        if (metodoPagamento == MetodoPagamentoEnum.NOVO.getValor())
        {
            Cartao dadosCartao = cartao.CadastrarNovoPagamentoCartao(scanner, clienteId);

            System.out.print("Número de parcelas: ");
            int numeroParcelas = scanner.nextInt();
            System.out.print("Valor da parcela: ");
            double valorParcela = scanner.nextDouble();
            Parcela parcela = new Parcela(numeroParcelas, valorParcela);

            return new Pagamento(dadosCartao, parcela);
        }
        else if (metodoPagamento == MetodoPagamentoEnum.CARTAO.getValor())
        {
            Cartao pagamentoCartao = cartao.ObterCartaoPorClienteId(clienteId);
            System.out.println(pagamentoCartao.toString());
            System.out.println("\n Deseja usar esse método de pagamento? (S/N)");
            Character inputUsuario = scanner.next().charAt(0);
            while (inputUsuario != 'S' && inputUsuario != 'N') {
                System.out.print("Utilize S ou N para confirmar o método de pagamento: ");
                inputUsuario = scanner.next().charAt(0);
            }

            if (inputUsuario == 'N')
            {
                cartao.CadastrarNovoPagamentoCartao(scanner, clienteId);
            }
            else
            {
                System.out.print("Número de parcelas: ");
                int numeroParcelas = scanner.nextInt();
                System.out.print("Valor da parcela: ");
                double valorParcela = scanner.nextDouble();
                Parcela parcela = new Parcela(numeroParcelas, valorParcela);

                return new Pagamento(pagamentoCartao, parcela);
            }


        }
        else 
            return null;
            //InvalidApplicationException("Método de Pagamento Inválido!");



        return null;
    }


    
}
