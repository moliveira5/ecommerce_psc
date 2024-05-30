package entities;

public class Endereco {
    private String enderecoCompleto;

    public Endereco(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "enderecoCompleto='" + enderecoCompleto + '\'' +
                '}';
    }
}
