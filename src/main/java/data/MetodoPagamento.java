package data;

public class MetodoPagamento {
    private Cartao cartao;
    private Parcela parcelas;

    public MetodoPagamento(Cartao cartao, Parcela parcelas) {
        this.cartao = cartao;
        this.parcelas = parcelas;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
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
                "cartao=" + cartao +
                ", parcelas=" + parcelas +
                '}';
    }
}
