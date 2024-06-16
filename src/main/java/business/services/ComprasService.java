package business.services;

import java.util.Scanner;
import business.entities.Cliente;
import business.entities.Compra;
import data.repository.GerenciadorDeCompras;

public class ComprasService {

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

    public void listarComprasPorCliente(Scanner scanner, GerenciadorDeCompras gerenciadorDeCompras, Cliente cliente) {
        System.out.println("Compras do cliente: " + cliente.getNome());
        gerenciadorDeCompras.listarComprasPorCliente(cliente.getId());
    }
}
