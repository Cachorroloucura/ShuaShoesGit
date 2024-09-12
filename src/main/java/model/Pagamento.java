package model;
import java.util.Date;
public class Pagamento {
    private int idPagamento;
    private int idPedido;
    private String metodoPagamento;
    private double valorPago;
    private Date dataPagamento;

    // GETTERS
    public int getIdPagamento() {
        return idPagamento;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    // SETTERS
    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}

