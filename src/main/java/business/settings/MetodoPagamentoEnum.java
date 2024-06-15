package business.settings;

public enum MetodoPagamentoEnum {

    AVISTA(0),
    PARCELADO(1);

    private final int valor;

    MetodoPagamentoEnum(final int valor)
    {
        this.valor = valor;
    }

    public int getValor()
    {
        return valor;
    }
}
