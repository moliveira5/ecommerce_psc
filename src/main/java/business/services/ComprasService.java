package business.services;

import java.util.Scanner;
import business.entities.Cliente;
import business.entities.Compra;
import data.repository.GerenciadorDeCompras;

/**
 * Serviço responsável por operações relacionadas a compras.
 */
public class ComprasService {
    /**
     * Realiza uma nova compra para o cliente especificado.
     *
     * @param scanner             Scanner para ler entrada do usuário.
     * @param gerenciadorDeCompras Gerenciador de compras para realizar operações no banco de dados.
     * @param cliente             Cliente que está realizando a compra.
     * @return O objeto Compra criado e inserido no banco de dados.
     */
    public Compra realizarCompra(Scanner scanner, GerenciadorDeCompras gerenciadorDeCompras, Cliente cliente) {
        System.out.print("Total da Compra: ");
        double totalCompra = scanner.nextDouble();
        scanner.nextLine();

        Compra novaCompra = new Compra(0, cliente.getId(), null, totalCompra);
        gerenciadorDeCompras.inserirCompra(novaCompra);

        while (true) {
            System.out.print("Adicionar produto (ID) à compra (ou '0' para finalizar): ");
            int produtoId = scanner.nextInt();
            if (produtoId == 0) {
                break;
            }
            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();

            gerenciadorDeCompras.inserirItemCompra(novaCompra.getId(), produtoId, quantidade);
        }

        return novaCompra;
    }

    /**
     * Lista todas as compras realizadas pelo cliente especificado.
     *
     * @param scanner             Scanner para ler entrada do usuário.
     * @param gerenciadorDeCompras Gerenciador de compras para realizar operações no banco de dados.
     * @param cliente             Cliente do qual as compras serão listadas.
     */
    public void listarComprasPorCliente(Scanner scanner, GerenciadorDeCompras gerenciadorDeCompras, Cliente cliente) {
        System.out.println("Compras do cliente: " + cliente.getNome());
        gerenciadorDeCompras.listarComprasPorCliente(cliente.getId());
    }
}
