package business.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um carrinho de compras que contém produtos.
 */
public class Carrinho {
    private List<Produto> produtos;

    /**
     * Construtor para inicializar um carrinho vazio.
     */
    public Carrinho() {
        this.produtos = new ArrayList<>();
    }

    /**
     * Adiciona um produto ao carrinho.
     *
     * @param produto O produto a ser adicionado.
     */
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    /**
     * Verifica se o carrinho está vazio.
     *
     * @return true se o carrinho estiver vazio, false caso contrário.
     */
    public boolean estaVazio() {
        return produtos.isEmpty();
    }

    /**
     * Busca um produto pelo seu ID no carrinho.
     *
     * @param produtoId ID do produto a ser buscado.
     * @return O produto encontrado no carrinho ou null se não encontrado.
     */
    public Produto buscarProdutoPorId(int produtoId) {
        for (Produto produto : produtos) {
            if (produto.getId() == produtoId) {
                return produto;
            }
        }
        return null;
    }

    /**
     * Remove um produto do carrinho.
     *
     * @param produto O produto a ser removido.
     */
    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    /**
     * Calcula o total do carrinho somando o preço de todos os produtos.
     *
     * @return O valor total do carrinho.
     */
    public double calcularTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }

    /**
     * Lista todos os produtos no carrinho.
     */
    public void listarProdutos() {
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    /**
     * Limpa o carrinho, removendo todos os produtos.
     */
    public void limparCarrinho() {
        produtos.clear();
    }

    /**
     * Obtém a lista de produtos no carrinho.
     *
     * @return A lista de produtos no carrinho.
     */
    public List<Produto> getItens() {
        return produtos;
    }

    /**
     * Lista os produtos no carrinho com detalhes, incluindo quantidade de cada produto.
     */
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

    /**
     * Conta a quantidade de um produto específico no carrinho.
     *
     * @param produto O produto cuja quantidade será contada.
     * @return A quantidade de unidades do produto no carrinho.
     */
    public int contarQuantidade(Produto produto) {
        int quantidade = 0;
        for (Produto p : produtos) {
            if (p.equals(produto)) {
                quantidade++;
            }
        }
        return quantidade;
    }

    /**
     * Conta a quantidade de um produto pelo seu ID no carrinho.
     *
     * @param produtoId O ID do produto cuja quantidade será contada.
     * @return A quantidade de unidades do produto no carrinho.
     */
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
