package business.entities;

public class Checkout {
    private Carrinho carrinho;
    private Cliente cliente;
    private Pagamento metodoPagamento;

    public Checkout(Carrinho carrinho, Cliente cliente, Pagamento metodoPagamento) {
        this.carrinho = carrinho;
        this.cliente = cliente;
        this.metodoPagamento = metodoPagamento;
    }

    public void finalizarCompra() {
        
        System.out.println("Compra finalizada com sucesso!");
    }
}
