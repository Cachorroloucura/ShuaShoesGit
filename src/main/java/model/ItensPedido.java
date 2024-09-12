package model;

public class ItensPedido {
    private int idItem;
    private int idPedido;
    private int idProduto;
    private int quantidade;
    private double precoUnitario;

    // GETTERS
    public int getIdItem() {
        return idItem;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    // SETTERS
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}

