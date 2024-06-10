package business.entities;

import java.sql.Timestamp;

public class Compra {
    private int id;
    private int clienteId;
    private Timestamp dataCompra;
    private double totalCompra;

    public Compra(int id, int clienteId, Timestamp dataCompra, double totalCompra) {
        this.id = id;
        this.clienteId = clienteId;
        this.dataCompra = dataCompra;
        this.totalCompra = totalCompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public Timestamp getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Timestamp dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

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
