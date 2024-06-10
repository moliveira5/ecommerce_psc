package business.entities;

public class Endereco {
    private int id;
    private String enderecoCompleto;

    public Endereco(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", enderecoCompleto='" + enderecoCompleto + '\'' +
                '}';
    }
}
