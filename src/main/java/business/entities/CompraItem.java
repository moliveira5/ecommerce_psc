package business.entities;

/**
 * Representa um item de compra associado a um produto.
 */
public class CompraItem {
    private int compraId;
    private int produtoId;
    private int quantidade;

    /**
     * Construtor para inicializar um item de compra com os IDs da compra, do produto e a quantidade comprada.
     *
     * @param compraId   O ID da compra à qual o item está associado.
     * @param produtoId  O ID do produto comprado.
     * @param quantidade A quantidade do produto comprado.
     */
    public CompraItem(int compraId, int produtoId, int quantidade) {
        this.compraId = compraId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    /**
     * Obtém o ID da compra à qual o item está associado.
     *
     * @return O ID da compra.
     */
    public int getCompraId() {
        return compraId;
    }

    /**
     * Define o ID da compra à qual o item está associado.
     *
     * @param compraId O ID da compra.
     */
    public void setCompraId(int compraId) {
        this.compraId = compraId;
    }

    /**
     * Obtém o ID do produto comprado.
     *
     * @return O ID do produto.
     */
    public int getProdutoId() {
        return produtoId;
    }

    /**
     * Define o ID do produto comprado.
     *
     * @param produtoId O ID do produto.
     */
    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    /**
     * Obtém a quantidade do produto comprado.
     *
     * @return A quantidade do produto.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade do produto comprado.
     *
     * @param quantidade A quantidade do produto.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Retorna uma representação em formato de string do item de compra.
     *
     * @return Uma representação textual do item de compra.
     */
    @Override
    public String toString() {
        return "CompraItem{" +
                "compraId=" + compraId +
                ", produtoId=" + produtoId +
                ", quantidade=" + quantidade +
                '}';
    }
}
