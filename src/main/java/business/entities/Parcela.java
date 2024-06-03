package business.entities;

public class Parcela {
    private int numeroParcelas;
    private double valorParcela;

    public Parcela(int numeroParcelas, double valorParcela) {
        this.numeroParcelas = numeroParcelas;
        this.valorParcela = valorParcela;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    @Override
    public String toString() {
        return "Parcela{" +
                "numeroParcelas=" + numeroParcelas +
                ", valorParcela=" + valorParcela +
                '}';
    }
}
