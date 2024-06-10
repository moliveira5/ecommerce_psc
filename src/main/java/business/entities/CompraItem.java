package business.entities;

public class CompraItem {
    private int compraId;
    private int produtoId;
    private int quantidade;

    public CompraItem(int compraId, int produtoId, int quantidade) {
        this.compraId = compraId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public int getCompraId() {
        return compraId;
    }

    public void setCompraId(int compraId) {
        this.compraId = compraId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "CompraItem{" +
                "compraId=" + compraId +
                ", produtoId=" + produtoId +
                ", quantidade=" + quantidade +
                '}';
    }
}
