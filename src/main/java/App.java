
import java.util.Scanner;
import business.entities.Carrinho;
import business.entities.Cliente;
import business.entities.Produto;
import business.services.CartaoService;
import business.services.CheckoutService;
import business.services.ClientesService;
import business.services.ComprasService;
import business.services.EnderecosService;
import data.Database;
import data.repository.GerenciadorDeCliente;
import data.repository.GerenciadorDeCompras;
import data.repository.GerenciadorDeEndereco;
import data.repository.GerenciadorDeProdutos;

public class App {
    public static void main(String[] args) {
        Database.createTables();

        Scanner scanner = new Scanner(System.in);
        GerenciadorDeProdutos gerenciadorDeProdutos = new GerenciadorDeProdutos();

        GerenciadorDeCliente gerenciadorDeCliente = new GerenciadorDeCliente();
        ClientesService clientesService = new ClientesService();

        CartaoService cartaoService = new CartaoService();

        GerenciadorDeEndereco gerenciadorDeEndereco = new GerenciadorDeEndereco();
        EnderecosService enderecosService = new EnderecosService();

        CheckoutService checkout = new CheckoutService();
        Carrinho carrinho = new Carrinho();

        GerenciadorDeCompras gerenciadorDeCompras = new GerenciadorDeCompras();
        ComprasService comprasService = new ComprasService();

        Cliente clienteAtual = null;

        while (clienteAtual == null) {
            clienteAtual = clientesService.Loggin(scanner);
        }

        if (clienteAtual.getId() != 0) {
            printLoggedMenu(scanner, gerenciadorDeProdutos, carrinho, clienteAtual, cartaoService, enderecosService, checkout, gerenciadorDeCompras, comprasService, gerenciadorDeEndereco, gerenciadorDeCliente);
        } else {
            printGuestMenu(scanner, gerenciadorDeProdutos, carrinho, clienteAtual, cartaoService, enderecosService, checkout, gerenciadorDeCompras, comprasService, gerenciadorDeEndereco, gerenciadorDeCliente);
        }

        scanner.close();
    }

    private static void printLoggedMenu(Scanner scanner, GerenciadorDeProdutos gerenciadorDeProdutos, Carrinho carrinho, Cliente clienteAtual, CartaoService cartaoService, EnderecosService enderecosService, CheckoutService checkout, GerenciadorDeCompras gerenciadorDeCompras, ComprasService comprasService, GerenciadorDeEndereco gerenciadorDeEndereco, GerenciadorDeCliente gerenciadorDeCliente) {
        int opcao = 0;
        while (opcao != 9) {
            System.out.println("Menu de opções:");
            System.out.println("1. Listar Produtos");
            System.out.println("2. Adicionar Produto ao Carrinho");
            System.out.println("3. Ver Carrinho");
            System.out.println("4. Adicionar cartão");
            System.out.println("5. Adicionar Endereço");
            System.out.println("6. Finalizar Compra");
            System.out.println("7. Verificar Compras Anteriores");
            System.out.println("8. Ver seus dados");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    gerenciadorDeProdutos.listarProdutos();
                    break;
                case 2:
                    System.out.print("ID do produto a adicionar ao carrinho: ");
                    int idProduto = scanner.nextInt();
                    scanner.nextLine();
                    Produto produto = gerenciadorDeProdutos.getProdutoById(idProduto);
                    if (produto != null) {
                        carrinho.adicionarProduto(produto);
                        System.out.println("Produto adicionado ao carrinho.");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 3:
                    if (!carrinho.estaVazio()) {
                        carrinho.listarProdutosDetalhado();
                        carrinho.calcularTotal();
                    } else {
                        System.out.println("Carrinho vazio.");
                    }
                    break;
                case 4:
                    cartaoService.CadastrarNovoPagamentoCartao(scanner, clienteAtual.getId());
                    break;
                case 5:
                    enderecosService.criarEndereco(scanner, gerenciadorDeEndereco, clienteAtual.getId());
                    break;
                case 6:
                    if (!carrinho.estaVazio()) {
                        checkout.FazerCheckout(scanner, carrinho, clienteAtual);
                    } else {
                        System.out.println("Carrinho vazio.");
                    }
                    break;
                case 7:
                    comprasService.listarComprasPorCliente(scanner, gerenciadorDeCompras, clienteAtual);
                    break;
                case 8:
                    gerenciadorDeCliente.exibirDadosCliente(clienteAtual.getEmail());
                    break;
                case 9:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private static void printGuestMenu(Scanner scanner, GerenciadorDeProdutos gerenciadorDeProdutos, Carrinho carrinho, Cliente clienteAtual, CartaoService cartaoService, EnderecosService enderecosService, CheckoutService checkout, GerenciadorDeCompras gerenciadorDeCompras, ComprasService comprasService, GerenciadorDeEndereco gerenciadorDeEndereco, GerenciadorDeCliente gerenciadorDeCliente) {
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("Menu de opções:");
            System.out.println("1. Listar Produtos");
            System.out.println("2. Adicionar Produto ao Carrinho");
            System.out.println("3. Ver Carrinho");
            System.out.println("4. Finalizar Compra");
            System.out.println("5. Fazer Login");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    gerenciadorDeProdutos.listarProdutos();
                    break;
                case 2:
                    System.out.print("ID do produto a adicionar ao carrinho: ");
                    int idProduto = scanner.nextInt();
                    scanner.nextLine();
                    Produto produto = gerenciadorDeProdutos.getProdutoById(idProduto);
                    if (produto != null) {
                        carrinho.adicionarProduto(produto);
                        System.out.println("Produto adicionado ao carrinho.");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 3:
                    if (!carrinho.estaVazio()) {
                        carrinho.listarProdutosDetalhado();
                        carrinho.calcularTotal();
                    } else {
                        System.out.println("Carrinho vazio.");
                    }
                    break;
                case 4:
                    if (!carrinho.estaVazio()) {
                        checkout.FazerCheckout(scanner, carrinho, clienteAtual);
                    } else {
                        System.out.println("Carrinho vazio. Adicione produtos antes de fazer checkout.");
                    }
                    break;
                case 5:
                    System.out.print("Email: ");
                    String emailLogin = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senhaLogin = scanner.nextLine();
                    clienteAtual = gerenciadorDeCliente.obterPorEmail(emailLogin);
                    if (clienteAtual != null && clienteAtual.getSenha().equals(senhaLogin)) {
                        System.out.println("Login realizado com sucesso.");
                        printLoggedMenu(scanner, gerenciadorDeProdutos, carrinho, clienteAtual, cartaoService, enderecosService, checkout, gerenciadorDeCompras, comprasService, gerenciadorDeEndereco, gerenciadorDeCliente);
                        return;
                    } else {
                        System.out.println("Email ou senha incorretos.");
                        clienteAtual = null;
                    }
                    break;
                case 6:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
