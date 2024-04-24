package data;

public class Checkout {
    
    private Long id;
    private Cliente cliente;
    private double valor;

    protected Checkout (Cliente cliente, double valor) 
    {
        this.cliente = cliente;
        this.valor = valor;
    }
}
