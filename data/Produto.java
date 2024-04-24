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
    
    protected Produto (String nome
                      ,String modelo
                      ,String categoria
                      ,String marca
                      ,double preco
                      ,int tamanhoNumerico
                      ,char tamanho) 
    {
        this.nome = nome;
        this.modelo = modelo;
        this.categoria = categoria;
        this.marca = marca;
        this.preco = preco;
        this.tamanhoNumerico = tamanhoNumerico;
        this.tamanho = tamanho;
    }
}
