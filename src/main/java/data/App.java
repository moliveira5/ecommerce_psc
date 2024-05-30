package data;
import java.util.Scanner;
import data.resources.Database;

public class App {
    public static void main(String[] args) {
        Database.createTables();

        Scanner scanner = new Scanner(System.in);
        GerenciadorDeProdutos gerenciadorDeProdutos = new GerenciadorDeProdutos();
        Carrinho carrinho = new Carrinho();
        Cliente clienteAtual = null;

        int opcao = 0;
        while (opcao != 7) {
            System.out.println("Menu de opções:");
            System.out.println("1. Inserir Produto");
            System.out.println("2. Alterar Produto");
            System.out.println("3. Remover Produto");
            System.out.println("4. Listar Produtos");
            System.out.println("5. Adicionar Produto ao Carrinho");
            System.out.println("6. Finalizar Compra");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    gerenciadorDeProdutos.inserirProduto(scanner);
                    break;
                case 2:
                    gerenciadorDeProdutos.alterarProduto(scanner);
                    break;
                case 3:
                    gerenciadorDeProdutos.removerProduto(scanner);
                    break;
                case 4:
                    gerenciadorDeProdutos.listarProdutos();
                    break;
                case 5:
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
                case 6:
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

                        clienteAtual = new Cliente(nome, cpf, email, telefone, new Endereco(endereco));
                    }

                    if (!carrinho.estaVazio()) {
                        double valorTotal = carrinho.calcularTotal();
                        System.out.println("Valor total da compra: " + valorTotal);

                        System.out.println("Escolha o método de pagamento:");
                        System.out.print("Número do cartão: ");
                        String numero = scanner.nextLine();
                        System.out.print("Nome do titular: ");
                        String nomeTitular = scanner.nextLine();
                        System.out.print("Data de validade (MM/AA): ");
                        String dataValidade = scanner.nextLine();
                        System.out.print("CVV: ");
                        String cvv = scanner.nextLine();
                        Cartao cartao = new Cartao(numero, nomeTitular, dataValidade, cvv);

                        System.out.print("Número de parcelas: ");
                        int numeroParcelas = scanner.nextInt();
                        System.out.print("Valor da parcela: ");
                        double valorParcela = scanner.nextDouble();
                        Parcela parcela = new Parcela(numeroParcelas, valorParcela);

                        MetodoPagamento metodoPagamento = new MetodoPagamento(cartao, parcela);

                        Checkout checkout = new Checkout(carrinho, clienteAtual, metodoPagamento);
                        checkout.finalizarCompra();
                        carrinho.limparCarrinho();
                    } else {
                        System.out.println("Carrinho vazio. Adicione produtos ao carrinho antes de finalizar a compra.");
                    }
                    break;
                case 7:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }
}
