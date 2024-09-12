package model;
import java.util.Date;
public class Pedido {
    private int idPedido;
    private int idCliente;
    private Date dataPedido;
    private double valorTotal;
    private String Status;
    // GETTERS
    public int getIdPedido() {
        return idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }
    public String getStatus() {
        return Status;
    }
    // SETTERS
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public void setStatus(String Status) {
        this.Status = Status;
    }
}

