package business.entities;

public class Pagamento {
    private static Cartao pagamentoCartao;
    private Parcela parcelas;

    public Pagamento(Cartao cartao, Parcela parcelas) 
    {
        this.pagamentoCartao = cartao;
        this.parcelas = parcelas;
    }

    public static Cartao getCartao() {
        return pagamentoCartao;
    }

    public void setCartao(Cartao cartao) {
        this.pagamentoCartao = cartao;
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
                ", parcelas=" + parcelas +
                '}';
    }
}
