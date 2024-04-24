package data;

public class Carrinho {
    
    private Long id;
    private Produto produto;
    private int quantidade;
    private double valor;

    protected Carrinho (Produto produto, int quantidade, double valor) 
    {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
    }
}
