package data;

public class MetodoPagamento {
    
    private Cartao cartao;
    private Parcela parcelas;

    protected MetodoPagamento (Cartao cartao, Parcela parcela) 
    {
        this.cartao = cartao;
        this.parcelas = parcela;
    }
}
