package business.services;

import java.util.Scanner;
import business.entities.Carrinho;
import business.entities.Produto;
import data.repository.GerenciadorDeProdutos;

/**
 * Serviço responsável por gerenciar operações no carrinho de compras.
 */
public class CarrinhoService {
    /**
     * Permite adicionar produtos ao carrinho.
     *
     * @param scanner   Scanner para ler entrada do usuário.
     * @param carrinho  Carrinho onde os produtos serão adicionados.
     * @param produtos  Gerenciador de produtos para obter informações dos produtos.
     */
    public void AdicionarProduto(Scanner scanner, Carrinho carrinho, GerenciadorDeProdutos produtos){
        boolean adicionarProduto = true;

        while(adicionarProduto)
        {
            System.out.print("Código do produto a adicionar no carrinho: ");
            int produtoId = scanner.nextInt();
            scanner.nextLine();

            Produto produto = produtos.getProdutoById(produtoId);

            if (produto != null) {
                carrinho.adicionarProduto(produto);
                System.out.println("Produto adicionado ao carrinho.");
            } else {
                System.out.println("Produto não encontrado.");
            }

            System.out.println("\nAdicionar mais produtos? (S/N)");
            Character inputUsuario = scanner.next().charAt(0);
            while (inputUsuario != 'S' && inputUsuario != 'N') {
                System.out.print("Utilize S ou N para confirmar se deseja adicionar mais produtos: ");
                inputUsuario = scanner.next().charAt(0);
            }

            if (inputUsuario != 'S')
                adicionarProduto = false;
            
        }
        
    }

    /**
     * Permite remover produtos do carrinho.
     *
     * @param scanner   Scanner para ler entrada do usuário.
     * @param carrinho  Carrinho de onde os produtos serão removidos.
     * @param produtos  Gerenciador de produtos para obter informações dos produtos.
     */
    public void RemoverProduto(Scanner scanner, Carrinho carrinho, GerenciadorDeProdutos produtos)
    {

        boolean removerProduto = true;

        while(removerProduto)
        {
            System.out.print("Código do produto a remover do carrinho: ");
            int produtoId = scanner.nextInt();
            scanner.nextLine();

            Produto produto = ObterProduto(carrinho, produtoId);

            if (produto != null) {
                carrinho.removerProduto(produto);
                System.out.println("Produto removido do carrinho.");
            } else {
                System.out.println("Produto não esta no carrinho.");
            }

            System.out.println("\nRemover mais produtos? (S/N)");
            Character inputUsuario = scanner.next().charAt(0);
            while (inputUsuario != 'S' && inputUsuario != 'N') {
                System.out.print("Utilize S ou N para confirmar se deseja remover mais produtos: ");
                inputUsuario = scanner.next().charAt(0);
            }

            if (inputUsuario != 'S')
                removerProduto = false;
        }

    }

    /**
     * Obtém um produto do carrinho pelo seu ID.
     *
     * @param carrinho   Carrinho onde buscar o produto.
     * @param produtoId  ID do produto a ser obtido.
     * @return Produto encontrado no carrinho ou null se não encontrado.
     */
    public Produto ObterProduto (Carrinho carrinho, int produtoId)
    {
        carrinho.listarProdutos();

        return null;
    }


    
}
