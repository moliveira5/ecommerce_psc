package business.entities;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Produto> produtos;

    public Carrinho() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public boolean estaVazio() {
        return produtos.isEmpty();
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }

    public void listarProdutos() {
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    public void limparCarrinho() {
        produtos.clear();
    }

    public List<Produto> getItens() {
        return produtos;
    }

    public void listarProdutosDetalhado() {
        String leftAlignFormat = "| %-4d | %-20s | %-10s | %-15s | %-10s | %-10.2f | %-15d | %-7s | %-10d |%n";
        System.out.format("+------+----------------------+------------+-----------------+------------+------------+-----------------+---------+------------+%n");
        System.out.format("| ID   | Nome                 | Modelo     | Categoria       | Marca      | Preço      | Tamanho Numérico| Tamanho | Quantidade |%n");
        System.out.format("+------+----------------------+------------+-----------------+------------+------------+-----------------+---------+------------+%n");

        produtos.stream().distinct().forEach(produto -> {
            int quantidade = contarQuantidade(produto);
            System.out.format(leftAlignFormat,
                    produto.getId(),
                    produto.getNome(),
                    produto.getModelo(),
                    produto.getCategoria(),
                    produto.getMarca(),
                    produto.getPreco(),
                    produto.getTamanhoNumerico(),
                    produto.getTamanho(),
                    quantidade);
        });

        System.out.format("+------+----------------------+------------+-----------------+------------+------------+-----------------+---------+------------+%n");
    }

    public int contarQuantidade(Produto produto) {
        int quantidade = 0;
        for (Produto p : produtos) {
            if (p.equals(produto)) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public int contarQuantidadePorId(int produtoId) {
        int quantidade = 0;
        for (Produto p : produtos) {
            if (p.getId() == produtoId) {
                quantidade++;
            }
        }
        return quantidade;
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "produtos=" + produtos +
                '}';
    }
}

