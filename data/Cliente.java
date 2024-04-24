package data;

public class Cliente {
    
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private int telefone;
    private Endereco endereco;
    
    protected Cliente (String nome
                      ,String cpf
                      ,String email
                      ,int telefone
                      ,Endereco endereco) 
    {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }
}
