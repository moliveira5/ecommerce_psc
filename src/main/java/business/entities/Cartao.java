package business.entities;

public class Cartao {
    private String numero;
    private String nomeTitular;
    private String dataValidade;
    private String cvv;
    private int clienteId;

    public Cartao(String numero, String nomeTitular, String dataValidade, String cvv) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.dataValidade = dataValidade;
        this.cvv = cvv;
    }

    public String getNumero() 
    {
        return numero;
    }

    public void setNumero(String numero) 
    {
        this.numero = numero;
    }

    public String getNomeTitular() 
    {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) 
    {
        this.nomeTitular = nomeTitular;
    }

    public String getDataValidade() 
    {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) 
    {
        this.dataValidade = dataValidade;
    }

    public String getCvv() 
    {
        return cvv;
    }

    public void setCvv(String cvv) {

        this.cvv = cvv;
    }


    @Override
    public String toString() 
    {
        return "Cartao{" +
                "numero='" + numero + '\'' +
                ", nomeTitular='" + nomeTitular + '\'' +
                ", dataValidade='" + dataValidade + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
