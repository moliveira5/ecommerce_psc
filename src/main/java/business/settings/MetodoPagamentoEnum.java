package business.settings;

public enum MetodoPagamentoEnum {

    NOVO(0),
    CARTAO(1),
    BOLETO(2);

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
