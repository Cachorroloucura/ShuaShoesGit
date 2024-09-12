package model;

public class Categoria {
    private int idCategoria;
    private String nomeCategoria;
    private String descricao;

    // GETTERS
    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    // SETTERS
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

