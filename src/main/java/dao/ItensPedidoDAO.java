package dao;
import model.ItensPedido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItensPedidoDAO {

    private Connection conexao;

    public ItensPedidoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir(ItensPedido itensPedido) throws SQLException {
        String sql = "INSERT INTO ItensPedido (ID_Pedido, ID_Produto, Quantidade, Preco_Unidade) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, itensPedido.getIdPedido());
            stmt.setInt(2, itensPedido.getIdProduto());
            stmt.setInt(3, itensPedido.getQuantidade());
            stmt.setDouble(4, itensPedido.getPrecoUnitario());
            stmt.executeUpdate();
        }
    }

    public void atualizar(ItensPedido itensPedido) throws SQLException {
        String sql = "UPDATE ItensPedido SET ID_Pedido = ?, ID_Produto = ?, Quantidade = ?, Preco_Unidade = ? WHERE ID_Item = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, itensPedido.getIdPedido());
            stmt.setInt(2, itensPedido.getIdProduto());
            stmt.setInt(3, itensPedido.getQuantidade());
            stmt.setDouble(4, itensPedido.getPrecoUnitario());
            stmt.setInt(5, itensPedido.getIdItem());
            stmt.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM ItensPedido WHERE ID_Item = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public ItensPedido buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM ItensPedido WHERE ID_Item = ?";
        ItensPedido itensPedido = null;
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                itensPedido = new ItensPedido();
                itensPedido.setIdItem(rs.getInt("ID_Item"));
                itensPedido.setIdPedido(rs.getInt("ID_Pedido"));
                itensPedido.setIdProduto(rs.getInt("ID_Produto"));
                itensPedido.setQuantidade(rs.getInt("Quantidade"));
                itensPedido.setPrecoUnitario(rs.getDouble("Preco_Unidade"));
            }
        }
        return itensPedido;
    }

    public List<ItensPedido> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM ItensPedido";
        List<ItensPedido> itensPedidos = new ArrayList<>();
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ItensPedido itensPedido = new ItensPedido();
                itensPedido.setIdItem(rs.getInt("ID_Item"));
                itensPedido.setIdPedido(rs.getInt("ID_Pedido"));
                itensPedido.setIdProduto(rs.getInt("ID_Produto"));
                itensPedido.setQuantidade(rs.getInt("Quantidade"));
                itensPedido.setPrecoUnitario(rs.getDouble("Preco_Unidade"));
                itensPedidos.add(itensPedido);
            }
        }
        return itensPedidos;
    }
}


