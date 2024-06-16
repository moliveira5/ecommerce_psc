package business.entities;

/**
 * Representa um endereço associado a um cliente.
 */
public class Endereco {
    private int id;
    private String enderecoCompleto;

    /**
     * Construtor para inicializar um endereço completo.
     *
     * @param enderecoCompleto O endereço completo (rua, número, complemento, etc.).
     */
    public Endereco(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

    /**
     * Obtém o ID do endereço.
     *
     * @return O ID do endereço.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do endereço.
     *
     * @param id O ID do endereço.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o endereço completo.
     *
     * @return O endereço completo.
     */
    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    /**
     * Define o endereço completo.
     *
     * @param enderecoCompleto O endereço completo.
     */
    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

    /**
     * Retorna uma representação em formato de string do endereço.
     *
     * @return Uma representação textual do endereço.
     */
    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", enderecoCompleto='" + enderecoCompleto + '\'' +
                '}';
    }
}
