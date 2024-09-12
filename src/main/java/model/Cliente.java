package model;
import java.util.Date;


public class Cliente {
    private int idCliente;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private Date dataNascimento;
    private String genero;
    private Date dataCadastro;
    private String preferencias;
    private String historicoCompras;

    // GETTERS
    public int getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public String getHistoricoCompras() {
        return historicoCompras;
    }

    // SETTERS
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public void setHistoricoCompras(String historicoCompras) {
        this.historicoCompras = historicoCompras;
    }
}
