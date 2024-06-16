package business.settings;

/**
 * Enumeração que define as opções disponíveis para escolha de cartão.
 */
public enum OpcaoCartaoEnum {
    /**
     * Opções para escolha.
     */
    NOVO(0),
    EXISTENTE(1);

    private final int valor;

    /**
     * Construtor privado para inicializar o valor de cada opção.
     *
     * @param valor Valor associado à opção
     */
    OpcaoCartaoEnum(final int valor)
    {
        this.valor = valor;
    }

    /**
     * Construtor privado para inicializar o valor de cada opção.
     *
     * @param valor Valor associado à opção
     */
    public int getValor()
    {
        return valor;
    }
    
}
