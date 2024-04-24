package data;

import java.util.Date;

public class Cartao {
    
    private Long id;
    private Long numeroCartao;
    private String nomeImpresso;
    private Date vencimento;
    private int cvv;
    private String cpf; 

    protected Cartao (Long numeroCartao
                    ,String nomeImpresso
                    ,Date vencimento
                    ,int cvv
                    ,String cpf) 
    {
        this.numeroCartao = numeroCartao;
        this.nomeImpresso = nomeImpresso;
        this.vencimento = vencimento;
        this.cvv = cvv;
        this.cpf = cpf;
    }
}
