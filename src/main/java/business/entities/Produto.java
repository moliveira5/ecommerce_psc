package business.entities;

/**
 * Representa um produto disponível para venda.
 */
public class Produto {
    private int id;
    private String nome;
    private String modelo;
    private String categoria;
    private String marca;
    private double preco;
    private int tamanhoNumerico;
    private char tamanho;

    /**
     * Construtor para inicializar um objeto Produto.
     *
     * @param id Identificador único do produto.
     * @param nome Nome do produto.
     * @param modelo Modelo específico do produto.
     * @param categoria Categoria à qual o produto pertence.
     * @param marca Marca do produto.
     * @param preco Preço do produto.
     * @param tamanhoNumerico Tamanho numérico do produto (se aplicável).
     * @param tamanho Tamanho textual ou simbólico do produto (se aplicável).
     */
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

    /**
     * Obtém o ID do produto.
     *
     * @return O ID do produto.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do produto.
     *
     * @param id O ID do produto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do produto.
     *
     * @return O nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do produto.
     *
     * @param nome O nome do produto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o modelo do produto.
     *
     * @return O modelo do produto.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Define o modelo do produto.
     *
     * @param modelo O modelo do produto.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtém a categoria do produto.
     *
     * @return A categoria do produto.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Define a categoria do produto.
     *
     * @param categoria A categoria do produto.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtém a marca do produto.
     *
     * @return A marca do produto.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Define a marca do produto.
     *
     * @param marca A marca do produto.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtém o preço do produto.
     *
     * @return O preço do produto.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço do produto.
     *
     * @param preco O preço do produto.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Obtém o tamanho numérico do produto.
     *
     * @return O tamanho numérico do produto.
     */
    public int getTamanhoNumerico() {
        return tamanhoNumerico;
    }

    /**
     * Define o tamanho numérico do produto.
     *
     * @param tamanhoNumerico O tamanho numérico do produto.
     */
    public void setTamanhoNumerico(int tamanhoNumerico) {
        this.tamanhoNumerico = tamanhoNumerico;
    }

    /**
     * Obtém o tamanho do produto.
     *
     * @return O tamanho do produto.
     */
    public char getTamanho() {
        return tamanho;
    }

    /**
     * Define o tamanho do produto.
     *
     * @param tamanho O tamanho do produto.
     */
    public void setTamanho(char tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * Retorna uma representação em formato de string do produto.
     *
     * @return Uma representação textual do produto.
     */
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
