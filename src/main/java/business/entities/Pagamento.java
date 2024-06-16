package business.entities;

/**
 * Representa um pagamento realizado, contendo informações sobre o cartão utilizado e as parcelas, se houver.
 */
public class Pagamento {
    private static Cartao pagamentoCartao;
    private Parcela parcelas;

    /**
     * Construtor para inicializar um Pagamento.
     *
     * @param cartao O cartão utilizado para o pagamento.
     * @param parcelas As parcelas relacionadas ao pagamento, se houver.
     */
    public Pagamento(Cartao cartao, Parcela parcelas) {
        this.pagamentoCartao = cartao;
        this.parcelas = parcelas;
    }

    /**
     * Obtém o cartão utilizado no pagamento.
     *
     * @return O cartão utilizado no pagamento.
     */
    public static Cartao getCartao() {
        return pagamentoCartao;
    }

    /**
     * Define o cartão utilizado no pagamento.
     *
     * @param cartao O cartão utilizado no pagamento.
     */
    public void setCartao(Cartao cartao) {
        this.pagamentoCartao = cartao;
    }

    /**
     * Obtém as parcelas relacionadas ao pagamento.
     *
     * @return As parcelas relacionadas ao pagamento.
     */
    public Parcela getParcelas() {
        return parcelas;
    }

    /**
     * Define as parcelas relacionadas ao pagamento.
     *
     * @param parcelas As parcelas relacionadas ao pagamento.
     */
    public void setParcelas(Parcela parcelas) {
        this.parcelas = parcelas;
    }

    /**
     * Retorna uma representação em formato de string do pagamento.
     *
     * @return Uma representação textual do pagamento.
     */
    @Override
    public String toString() {
        return "Pagamento{" +
                "cartao=" + pagamentoCartao +
                ", parcelas=" + parcelas +
                '}';
    }
}
