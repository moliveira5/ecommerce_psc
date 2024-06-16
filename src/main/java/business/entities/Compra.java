package business.entities;

import java.sql.Timestamp;

/**
 * Representa uma compra realizada por um cliente.
 */
public class Compra {
    private int id;
    private int clienteId;
    private Timestamp dataCompra;
    private double totalCompra;

    /**
     * Construtor para inicializar uma compra com os detalhes fornecidos.
     *
     * @param id          O ID da compra.
     * @param clienteId   O ID do cliente que realizou a compra.
     * @param dataCompra  A data e hora em que a compra foi realizada.
     * @param totalCompra O valor total da compra.
     */
    public Compra(int id, int clienteId, Timestamp dataCompra, double totalCompra) {
        this.id = id;
        this.clienteId = clienteId;
        this.dataCompra = dataCompra;
        this.totalCompra = totalCompra;
    }

    /**
     * Obtém o ID da compra.
     *
     * @return O ID da compra.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID da compra.
     *
     * @param id O ID da compra.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o ID do cliente que realizou a compra.
     *
     * @return O ID do cliente.
     */
    public int getClienteId() {
        return clienteId;
    }

    /**
     * Define o ID do cliente que realizou a compra.
     *
     * @param clienteId O ID do cliente.
     */
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    /**
     * Obtém a data e hora em que a compra foi realizada.
     *
     * @return A data da compra.
     */
    public Timestamp getDataCompra() {
        return dataCompra;
    }

    /**
     * Define a data e hora em que a compra foi realizada.
     *
     * @param dataCompra A data da compra.
     */
    public void setDataCompra(Timestamp dataCompra) {
        this.dataCompra = dataCompra;
    }

    /**
     * Obtém o valor total da compra.
     *
     * @return O valor total da compra.
     */
    public double getTotalCompra() {
        return totalCompra;
    }

    /**
     * Define o valor total da compra.
     *
     * @param totalCompra O valor total da compra.
     */
    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    /**
     * Retorna uma representação em formato de string da compra.
     *
     * @return Uma representação textual da compra.
     */
    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", clienteId=" + clienteId +
                ", dataCompra=" + dataCompra +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
