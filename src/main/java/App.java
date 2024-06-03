
import java.util.Scanner;

import business.entities.Carrinho;
import business.entities.Cliente;
import business.entities.Produto;
import business.services.CheckoutService;
import data.Database;
import data.repository.GerenciadorDeProdutos;

public class App {
    public static void main(String[] args) {
        Database.createTables();

        Scanner scanner = new Scanner(System.in);
        GerenciadorDeProdutos gerenciadorDeProdutos = new GerenciadorDeProdutos();
        CheckoutService checkout = new CheckoutService();
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
                    checkout.FazerCheckout(scanner, carrinho);
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
