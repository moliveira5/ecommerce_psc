package business.entities;

/**
 * Representa um cartão de crédito utilizado para pagamentos.
 */
public class Cartao {
    private String numero;
    private String nomeTitular;
    private String dataValidade;
    private String cvv;

    /**
     * Construtor para inicializar um objeto Cartao com o número, nome do titular, data de validade e CVV fornecidos.
     *
     * @param numero      O número do cartão.
     * @param nomeTitular O nome do titular do cartão.
     * @param dataValidade A data de validade do cartão (no formato MM/AA).
     * @param cvv         O código de segurança do cartão.
     */
    public Cartao(String numero, String nomeTitular, String dataValidade, String cvv) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.dataValidade = dataValidade;
        this.cvv = cvv;
    }

    /**
     * Obtém o número do cartão.
     *
     * @return O número do cartão.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Define o número do cartão.
     *
     * @param numero O número do cartão a ser definido.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtém o nome do titular do cartão.
     *
     * @return O nome do titular do cartão.
     */
    public String getNomeTitular() {
        return nomeTitular;
    }

    /**
     * Define o nome do titular do cartão.
     *
     * @param nomeTitular O nome do titular do cartão a ser definido.
     */
    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    /**
     * Obtém a data de validade do cartão.
     *
     * @return A data de validade do cartão.
     */
    public String getDataValidade() {
        return dataValidade;
    }

    /**
     * Define a data de validade do cartão.
     *
     * @param dataValidade A data de validade do cartão a ser definida.
     */
    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    /**
     * Obtém o código de segurança (CVV) do cartão.
     *
     * @return O CVV do cartão.
     */
    public String getCvv() {
        return cvv;
    }

    /**
     * Define o código de segurança (CVV) do cartão.
     *
     * @param cvv O CVV do cartão a ser definido.
     */
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "numero='" + numero + '\'' +
                ", nomeTitular='" + nomeTitular + '\'' +
                ", dataValidade='" + dataValidade + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
