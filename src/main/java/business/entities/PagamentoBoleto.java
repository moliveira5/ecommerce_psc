package business.entities;


public class PagamentoBoleto {
    private Cliente cliente;

    public PagamentoBoleto (Cliente cliente)
    {
        this.cliente = cliente;
    }

    public Cliente getClienteBoleto()
    {
        return cliente;
    }
    
}
