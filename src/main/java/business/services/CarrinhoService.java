package business.services;

import java.util.ArrayList;
import java.util.Scanner;

import business.entities.Carrinho;
import business.entities.Produto;
import data.repository.GerenciadorDeProdutos;

public class CarrinhoService {

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

    public Produto ObterProduto (Carrinho carrinho, int produtoId)
    {
        carrinho.listarProdutos();

        return null;
    }


    
}
