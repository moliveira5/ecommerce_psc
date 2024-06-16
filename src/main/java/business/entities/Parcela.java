package business.entities;

/**
 * Representa uma parcela de pagamento.
 */
public class Parcela {
    private int numeroParcelas;
    private double valorParcela;

    /**
     * Construtor para inicializar uma Parcela.
     *
     * @param numeroParcelas Número de parcelas em que a compra foi dividida.
     * @param valorParcela Valor de cada parcela.
     */
    public Parcela(int numeroParcelas, double valorParcela) {
        this.numeroParcelas = numeroParcelas;
        this.valorParcela = valorParcela;
    }

    /**
     * Obtém o número de parcelas.
     *
     * @return O número de parcelas.
     */
    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    /**
     * Define o número de parcelas.
     *
     * @param numeroParcelas O número de parcelas.
     */
    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    /**
     * Obtém o valor de cada parcela.
     *
     * @return O valor de cada parcela.
     */
    public double getValorParcela() {
        return valorParcela;
    }

    /**
     * Define o valor de cada parcela.
     *
     * @param valorParcela O valor de cada parcela.
     */
    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    /**
     * Retorna uma representação em formato de string da parcela.
     *
     * @return Uma representação textual da parcela.
     */
    @Override
    public String toString() {
        return "Parcela{" +
                "numeroParcelas=" + numeroParcelas +
                ", valorParcela=" + valorParcela +
                '}';
    }
}
