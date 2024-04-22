package data;

protected class Produto {

    int id;
    String nome;
    String modelo;
    String categoria;
    String marca;
    Double preco;
    int tamanhoNumerico;
    char tamanho;
    
    protected Produto(int idade, float altura, float peso) {
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }
}
