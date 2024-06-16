package business.settings;

/**
 * Enumeração que define os métodos de pagamento disponíveis.
 */
public enum MetodoPagamentoEnum {
    /**
     * Opções para pagamento.
     */
    AVISTA(0),
    PARCELADO(1);

    private final int valor;

    /**
     * Construtor privado para inicializar o valor de cada método de pagamento.
     *
     * @param valor Valor associado ao método de pagamento
     */
    MetodoPagamentoEnum(final int valor)
    {
        this.valor = valor;
    }

    /**
     * Obtém o valor associado ao método de pagamento.
     *
     * @return O valor do método de pagamento
     */
    public int getValor()
    {
        return valor;
    }
}
