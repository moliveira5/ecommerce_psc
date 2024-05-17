package data;

public class Produto {
    private int id;
    private String nome;
    private String modelo;
    private String categoria;
    private String marca;
    private double preco;
    private int tamanhoNumerico;
    private char tamanho;

    public Produto(int id, String nome, String modelo, String categoria, String marca, double preco, int tamanhoNumerico, char tamanho) {
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
        this.categoria = categoria;
        this.marca = marca;
        this.preco = preco;
        this.tamanhoNumerico = tamanhoNumerico;
        this.tamanho = tamanho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getTamanhoNumerico() {
        return tamanhoNumerico;
    }

    public void setTamanhoNumerico(int tamanhoNumerico) {
        this.tamanhoNumerico = tamanhoNumerico;
    }

    public char getTamanho() {
        return tamanho;
    }

    public void setTamanho(char tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", modelo='" + modelo + '\'' +
                ", categoria='" + categoria + '\'' +
                ", marca='" + marca + '\'' +
                ", preco=" + preco +
                ", tamanhoNumerico=" + tamanhoNumerico +
                ", tamanho=" + tamanho +
                '}';
    }
}
