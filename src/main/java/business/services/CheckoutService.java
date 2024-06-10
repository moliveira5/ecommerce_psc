package business.services;

import java.util.Scanner;

import business.entities.Carrinho;
import business.entities.Checkout;
import business.entities.Cliente;
import business.entities.Compra;
import business.entities.Endereco;
import business.entities.Pagamento;
import business.entities.Cartao;
import business.entities.Parcela;
import business.entities.Produto;
import business.settings.MetodoPagamentoEnum;
import data.repository.GerenciadorDeCliente;
import data.repository.GerenciadorDeCompras;
import data.repository.GerenciadorDeEndereco;
import data.repository.GerenciadorDePagamento;

public class CheckoutService {

    public void FazerCheckout(Scanner scanner, Carrinho carrinho)
    {
        System.out.print("Informe seu email: ");
        String email = scanner.nextLine().toLowerCase();
        Cliente clienteAtual = DefinirClienteDaCompra(scanner, email);

        if (!carrinho.estaVazio()) {
            carrinho.listarProdutosDetalhado();

            double valorTotal = carrinho.calcularTotal();
            System.out.println("\nValor total da compra: " + valorTotal);

            Pagamento metodoPagamento = DefinirMetodoDePagamento(scanner, clienteAtual.getId());

            Checkout checkout = new Checkout(carrinho, clienteAtual, metodoPagamento);
            checkout.finalizarCompra();

            GerenciadorDeCompras gerenciadorDeCompras = new GerenciadorDeCompras();
            Compra novaCompra = new Compra(0, clienteAtual.getId(), null, valorTotal);
            gerenciadorDeCompras.inserirCompra(novaCompra);

            // carrinho.getItens().forEach(produto -> {
            //     int quantidade = carrinho.contarQuantidadePorId(produto.getId());

            //     gerenciadorDeCompras.inserirItemCompra(novaCompra.getId(), produto.getId(), quantidade);
            // });

            carrinho.limparCarrinho();
        } else {
            System.out.println("Carrinho vazio. Adicione produtos ao carrinho antes de finalizar a compra.");
        }
    }

    public Cliente DefinirClienteDaCompra(Scanner scanner, String emailCliente)
    {
        GerenciadorDeCliente gerenciadorDeCliente = new GerenciadorDeCliente();

        Cliente clienteAtual = gerenciadorDeCliente.obterPorEmail(emailCliente);

        if (clienteAtual == null) {
            ClientesService clientesService = new ClientesService();
            clienteAtual = clientesService.criarConta(scanner, gerenciadorDeCliente, emailCliente);

            System.out.print("Endereço: ");
            String enderecoStr = scanner.nextLine();

            Endereco endereco = new Endereco(enderecoStr);
            GerenciadorDeEndereco gerenciadorDeEndereco = new GerenciadorDeEndereco();
            gerenciadorDeEndereco.inserirEndereco(endereco, clienteAtual.getId());
        }

        return clienteAtual;
    }

    public Pagamento DefinirMetodoDePagamento(Scanner scanner, int clienteId) {
        System.out.println("Escolha o método de pagamento:");
        System.out.println("0 - Cadastrar novo cartão");
        System.out.println("1 - Cartão");
        System.out.println("2 - Boleto");
        int metodoPagamento = scanner.nextInt();
        scanner.nextLine();

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
