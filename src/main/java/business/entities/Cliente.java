package business.entities;

/**
 * Representa um cliente que pode realizar compras no sistema.
 */
public class Cliente {
    private int id;
    private int nivel;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String senha;

    /**
     * Construtor para inicializar um cliente com os detalhes fornecidos.
     *
     * @param id       O ID do cliente.
     * @param nivel    O nível de acesso do cliente.
     * @param nome     O nome completo do cliente.
     * @param cpf      O CPF do cliente.
     * @param email    O endereço de email do cliente.
     * @param telefone O número de telefone do cliente.
     * @param senha    A senha do cliente para autenticação.
     */
    public Cliente(int id, int nivel, String nome, String cpf, String email, String telefone, String senha) {
        this.id = id;
        this.nivel = nivel;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    /**
     * Obtém o ID do cliente.
     *
     * @return O ID do cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do cliente.
     *
     * @param id O ID do cliente.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nível de acesso do cliente.
     *
     * @return O nível de acesso do cliente.
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Define o nível de acesso do cliente.
     *
     * @param nivel O nível de acesso do cliente.
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Obtém o nome completo do cliente.
     *
     * @return O nome completo do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome completo do cliente.
     *
     * @param nome O nome completo do cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o CPF do cliente.
     *
     * @return O CPF do cliente.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF do cliente.
     *
     * @param cpf O CPF do cliente.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Obtém o endereço de email do cliente.
     *
     * @return O endereço de email do cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o endereço de email do cliente.
     *
     * @param email O endereço de email do cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o número de telefone do cliente.
     *
     * @return O número de telefone do cliente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o número de telefone do cliente.
     *
     * @param telefone O número de telefone do cliente.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obtém a senha do cliente.
     *
     * @return A senha do cliente.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do cliente.
     *
     * @param senha A senha do cliente.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Retorna uma representação em formato de string do cliente.
     *
     * @return Uma representação textual do cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nivel=" + nivel +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
