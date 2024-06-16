import java.io.Console;
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

/**
 * Esta classe representa a aplicação principal do sistema de compras online.
 * Ela gerencia a interação com o usuário através de menus, realiza operações de
 * gerenciamento de produtos, carrinho de compras, checkout, login de clientes,
 * entre outras funcionalidades relacionadas a um sistema de e-commerce.
 */
public class App {
    private Scanner scanner;
    private GerenciadorDeProdutos gerenciadorDeProdutos;
    private GerenciadorDeCliente gerenciadorDeCliente;
    private ClientesService clientesService;
    private CartaoService cartaoService;
    private EnderecosService enderecosService;
    private CheckoutService checkout;
    private GerenciadorDeCompras gerenciadorDeCompras;
    private ComprasService comprasService;
    private GerenciadorDeEndereco gerenciadorDeEndereco;
    private Carrinho carrinho;
    private Cliente clienteAtual;

    /**
     * Construtor da classe App. Inicializa todos os serviços e recursos necessários
     * para o funcionamento da aplicação.
     */
    public App() {
        this.scanner = new Scanner(System.in);
        this.gerenciadorDeProdutos = new GerenciadorDeProdutos();
        this.gerenciadorDeCliente = new GerenciadorDeCliente();
        this.clientesService = new ClientesService();
        this.cartaoService = new CartaoService();
        this.enderecosService = new EnderecosService();
        this.checkout = new CheckoutService();
        this.gerenciadorDeCompras = new GerenciadorDeCompras();
        this.comprasService = new ComprasService();
        this.gerenciadorDeEndereco = new GerenciadorDeEndereco();
        this.carrinho = new Carrinho();
        this.clienteAtual = null;
    }

    /**
     * Método principal que inicia a aplicação. Responsável por criar as tabelas caso não as tenha no
     * banco de dados, realiza o login do cliente e direciona para o menu adequado
     * com base no estado do login.
     */
    public void startApp() {
        Database.createTables();

        while (clienteAtual == null) {
            clienteAtual = clientesService.Loggin(scanner);
        }

        if (clienteAtual.getId() != 0) {
            printLoggedMenu();
        } else {
            printGuestMenu();
        }

        scanner.close();
    }

    /**
     * Imprime o menu principal para clientes logados, permitindo a interação com
     * as funcionalidades do sistema.
     */
    private void printLoggedMenu() {
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

    /**
     * Imprime o menu principal para clientes não logados (visitantes), permitindo
     * a interação com funcionalidades limitadas do sistema.
     */
    private void printGuestMenu() {
        Console con = System.console(); 
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
                    char[] ch = con.readPassword();
                    String senhaLogin = String.valueOf(ch);
                    clienteAtual = gerenciadorDeCliente.obterPorEmail(emailLogin);
                    if (clienteAtual != null && clienteAtual.getSenha().equals(senhaLogin)) {
                        System.out.println("Login realizado com sucesso.");
                        printLoggedMenu();
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

    /**
     * Método main da aplicação. Cria uma instância de App e inicia a execução do
     * sistema de compras online.
     */
    public static void main(String[] args) {
        App app = new App();
        app.startApp();
    }
}
