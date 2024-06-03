package business.entities;


public class Pagamento {
    private PagamentoCartao pagamentoCartao;
    private PagamentoBoleto pagamentoBoleto;
    private Parcela parcelas;

    public Pagamento(PagamentoCartao cartao, Parcela parcelas) 
    {
        this.pagamentoCartao = cartao;
        this.parcelas = parcelas;
    }

    public Pagamento(PagamentoBoleto boleto, Parcela parcelas)
    {
        this.pagamentoBoleto = boleto;
        this.parcelas = parcelas;

    }

    public PagamentoCartao getCartao() {
        return pagamentoCartao;
    }

    public PagamentoBoleto getBoleto() {
        return pagamentoBoleto;
    }

    public void setCartao(PagamentoCartao cartao) {
        this.pagamentoCartao = cartao;
    }

    public void setBoleto(PagamentoBoleto boleto) {
        this.pagamentoBoleto = boleto;
    }

    public Parcela getParcelas() {
        return parcelas;
    }

    public void setParcelas(Parcela parcelas) {
        this.parcelas = parcelas;
    }

    @Override
    public String toString() {
        return "MetodoPagamento{" +
                "cartao=" + pagamentoCartao +
                "boleto=" + pagamentoBoleto +
                ", parcelas=" + parcelas +
                '}';
    }
}
