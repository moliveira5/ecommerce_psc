package business.settings;

public enum OpcaoCartaoEnum {

    NOVO(0),
    EXISTENTE(1);

    private final int valor;

    OpcaoCartaoEnum(final int valor)
    {
        this.valor = valor;
    }

    public int getValor()
    {
        return valor;
    }
    
}
