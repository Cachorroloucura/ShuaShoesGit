package dao;
import model.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    private Connection conexao;

    public PedidoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir(Pedido pedido) throws SQLException {
        String sql = "INSERT INTO Pedido (ID_Cliente, Data_Pedido, Status, Total) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, pedido.getIdCliente());
            stmt.setDate(2, new java.sql.Date(pedido.getDataPedido().getTime()));
            stmt.setString(3, pedido.getStatus());
            stmt.setDouble(4, pedido.getValorTotal());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Pedido pedido) throws SQLException {
        String sql = "UPDATE Pedido SET ID_Cliente = ?, Data_Pedido = ?, Status = ?, Total = ? WHERE ID_Pedido = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, pedido.getIdCliente());
            stmt.setDate(2, new java.sql.Date(pedido.getDataPedido().getTime()));
            stmt.setString(3, pedido.getStatus());
            stmt.setDouble(4, pedido.getValorTotal());
            stmt.setInt(5, pedido.getIdPedido());
            stmt.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM Pedido WHERE ID_Pedido = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public Pedido buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM Pedido WHERE ID_Pedido = ?";
        Pedido pedido = null;
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("ID_Pedido"));
                pedido.setIdCliente(rs.getInt("ID_Cliente"));
                pedido.setDataPedido(rs.getDate("Data_Pedido"));
                pedido.setStatus(rs.getString("Status"));
                pedido.setValorTotal(rs.getDouble("Total"));
            }
        }
        return pedido;
    }

    public List<Pedido> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM Pedido";
        List<Pedido> pedidos = new ArrayList<>();
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("ID_Pedido"));
                pedido.setIdCliente(rs.getInt("ID_Cliente"));
                pedido.setDataPedido(rs.getDate("Data_Pedido"));
                pedido.setStatus(rs.getString("Status"));
                pedido.setValorTotal(rs.getDouble("Total"));
                pedidos.add(pedido);
            }
        }
        return pedidos;
    }
}
