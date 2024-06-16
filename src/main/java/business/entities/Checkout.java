package business.entities;

/**
 * Representa o processo de checkout de uma compra.
 */
public class Checkout {
    private Carrinho carrinho;
    private Cliente cliente;
    private Pagamento metodoPagamento;

    /**
     * Construtor para inicializar um objeto Checkout com o carrinho, cliente e método de pagamento fornecidos.
     *
     * @param carrinho        O carrinho que contém os produtos para compra.
     * @param cliente         O cliente que está realizando a compra.
     * @param metodoPagamento O método de pagamento escolhido pelo cliente.
     */
    public Checkout(Carrinho carrinho, Cliente cliente, Pagamento metodoPagamento) {
        this.carrinho = carrinho;
        this.cliente = cliente;
        this.metodoPagamento = metodoPagamento;
    }

    /**
     * Finaliza o processo de compra, imprimindo uma mensagem de sucesso no console.
     */
    public void finalizarCompra() {
        System.out.println("Compra finalizada com sucesso!");
    }
}
