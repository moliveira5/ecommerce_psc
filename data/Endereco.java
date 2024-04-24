package data;

public class Endereco {
    
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private int cep;
    private int numero;

    protected Endereco (String logradouro
                        ,String bairro
                        ,String cidade
                        ,String estado
                        ,int cep
                        ,int numero) 
    {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.numero = numero;
    }
}
