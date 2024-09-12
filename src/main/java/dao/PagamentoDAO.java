package dao;
import model.Pagamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO {

    private Connection conexao;

    public PagamentoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir(Pagamento pagamento) throws SQLException {
        String sql = "INSERT INTO Pagamento (ID_Pedido, Data_Pagamento, Valor, Metodo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, pagamento.getIdPedido());
            stmt.setDate(2, new java.sql.Date(pagamento.getDataPagamento().getTime()));
            stmt.setDouble(3, pagamento.getValorPago());
            stmt.setString(4, pagamento.getMetodoPagamento());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Pagamento pagamento) throws SQLException {
        String sql = "UPDATE Pagamento SET ID_Pedido = ?, Data_Pagamento = ?, Valor = ?, Metodo = ? WHERE ID_Pagamento = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, pagamento.getIdPedido());
            stmt.setDate(2, new java.sql.Date(pagamento.getDataPagamento().getTime()));
            stmt.setDouble(3, pagamento.getValorPago());
            stmt.setString(4, pagamento.getMetodoPagamento());
            stmt.setInt(5, pagamento.getIdPagamento());
            stmt.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM Pagamento WHERE ID_Pagamento = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public Pagamento buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM Pagamento WHERE ID_Pagamento = ?";
        Pagamento pagamento = null;
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                pagamento = new Pagamento();
                pagamento.setIdPagamento(rs.getInt("ID_Pagamento"));
                pagamento.setIdPedido(rs.getInt("ID_Pedido"));
                pagamento.setDataPagamento(rs.getDate("Data_Pagamento"));
                pagamento.setValorPago(rs.getDouble("Valor"));
                pagamento.setMetodoPagamento(rs.getString("Metodo"));
            }
        }
        return pagamento;
    }

    public List<Pagamento> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM Pagamento";
        List<Pagamento> pagamentos = new ArrayList<>();
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Pagamento pagamento = new Pagamento();
                pagamento.setIdPagamento(rs.getInt("ID_Pagamento"));
                pagamento.setIdPedido(rs.getInt("ID_Pedido"));
                pagamento.setDataPagamento(rs.getDate("Data_Pagamento"));
                pagamento.setValorPago(rs.getDouble("Valor"));
                pagamento.setMetodoPagamento(rs.getString("Metodo"));
                pagamentos.add(pagamento);
            }
        }
        return pagamentos;
    }
}

