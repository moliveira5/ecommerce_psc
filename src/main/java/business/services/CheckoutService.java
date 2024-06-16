package business.services;

import java.util.Scanner;
import business.entities.Carrinho;
import business.entities.Checkout;
import business.entities.Cliente;
import business.entities.Compra;
import business.entities.Pagamento;
import business.entities.Cartao;
import business.entities.Parcela;
import business.settings.MetodoPagamentoEnum;
import business.settings.OpcaoCartaoEnum;
import data.repository.GerenciadorDeCompras;

/**
 * Serviço responsável por gerenciar o processo de checkout de uma compra.
 */
public class CheckoutService {
    /**
     * Realiza o processo de checkout da compra.
     *
     * @param scanner      Scanner para ler entrada do usuário.
     * @param carrinho     Carrinho contendo os produtos para a compra.
     * @param clienteAtual Cliente que está realizando a compra.
     */
    public void FazerCheckout(Scanner scanner, Carrinho carrinho, Cliente clienteAtual)
    {
        ClientesService clientesService = new ClientesService();

        if(clienteAtual.getNome() == "Visitante")
        {
            do
            {
                clienteAtual = clientesService.Loggin(scanner);
            } while(clienteAtual == null);
        }
            

        if (clienteAtual != null) {
            carrinho.listarProdutosDetalhado();

            double valorTotal = carrinho.calcularTotal();
            System.out.println("\nValor total da compra: " + valorTotal);

            Cartao cartao = DefinirCartaoParaPagamento(scanner, clienteAtual.getId());

            Pagamento pagamento = DefinirPagamento(scanner, clienteAtual.getId(), cartao, valorTotal);

            Checkout checkout = new Checkout(carrinho, clienteAtual, pagamento);
            checkout.finalizarCompra();

            GerenciadorDeCompras gerenciadorDeCompras = new GerenciadorDeCompras();
            Compra novaCompra = new Compra(0, clienteAtual.getId(), null, valorTotal);

            gerenciadorDeCompras.inserirCompra(novaCompra);

            carrinho.getItens().forEach(produto -> {
                int quantidade = carrinho.contarQuantidadePorId(produto.getId());

                gerenciadorDeCompras.inserirItemCompra(novaCompra.getId(), produto.getId(), quantidade);
            });

            carrinho.limparCarrinho();
        } 
    }

    /**
     * Define qual cartão será utilizado para o pagamento.
     *
     * @param scanner   Scanner para ler entrada do usuário.
     * @param clienteId ID do cliente que está realizando a compra.
     * @return Cartão escolhido para o pagamento.
     */
    public Cartao DefinirCartaoParaPagamento(Scanner scanner, int clienteId)
    {
        System.out.println("Escolha o método de pagamento:");
        System.out.println("0 - Novo cartão");
        System.out.println("1 - Cartão");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        CartaoService cartaoService = new CartaoService();
        Cartao dadosCartao = null;

        if (opcao == OpcaoCartaoEnum.NOVO.getValor())
        {
            dadosCartao = cartaoService.CadastrarNovoPagamentoCartao(scanner, clienteId);
        }
        else if (opcao == OpcaoCartaoEnum.EXISTENTE.getValor())
        {
            dadosCartao = cartaoService.ObterCartaoPorClienteId(clienteId);
            System.out.println(dadosCartao.getNumero() + "|" + dadosCartao.getNomeTitular());
        }
        else 
        {
            System.out.println("Opção inválida. Tente novamente:");
            DefinirCartaoParaPagamento(scanner, clienteId);
        }
            
        return dadosCartao;
    }

    /**
     * Define as opções de pagamento (à vista ou parcelado) e calcula as parcelas.
     *
     * @param scanner           Scanner para ler entrada do usuário.
     * @param clienteId         ID do cliente que está realizando a compra.
     * @param cartao            Cartão escolhido para o pagamento.
     * @param valorTotalCompra  Valor total da compra.
     * @return Pagamento definido com o método e parcelamento escolhidos.
     */
    public Pagamento DefinirPagamento(Scanner scanner, int clienteId, Cartao cartao, double valorTotalCompra) {

        System.out.println("\nEscolha a forma de pagamento:");
        System.out.println("0 - A Vista");
        System.out.println("1 - Parcelado");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        Parcela parcela = null;
        double valorParcela = 0;
        double valorParcelaMinima = 50.0;
        int maximoParcelasPermitido = 12;

        if (opcao == MetodoPagamentoEnum.PARCELADO.getValor())
        {
            int maximoParcelas = (int)(valorTotalCompra / valorParcelaMinima);

            if (maximoParcelas > maximoParcelasPermitido)
               maximoParcelas = maximoParcelasPermitido;

            System.out.println("\nNúmero máximo de parcelas para o valor da compra: " + maximoParcelas);

            System.out.println("Deseja parcelar a compra em quantas vezes?");
            int numeroParcelas = scanner.nextInt();

            while(numeroParcelas > maximoParcelas || numeroParcelas == 0)
            {
                System.out.println("Valor inválido, informe a quantidade de parcelas novamente: ");
                numeroParcelas = scanner.nextInt();
            }

            valorParcela = valorTotalCompra / numeroParcelas;

            parcela = new Parcela(numeroParcelas, valorParcela);
        }
        else
        {
            parcela = new Parcela(MetodoPagamentoEnum.AVISTA.getValor(), valorTotalCompra);
        }

        return new Pagamento(cartao, parcela);
    }
}
