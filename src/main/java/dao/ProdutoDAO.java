package dao;
import model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection conexao;

    public ProdutoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir(Produto produto) throws SQLException {
        String sql = "INSERT INTO Produto (Nome, Marca, Tamanho, Cor, Preco, Estoque, ID_Categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getMarca());
            stmt.setString(3, produto.getTamanho());
            stmt.setString(4, produto.getCor());
            stmt.setDouble(5, produto.getPreco());
            stmt.setInt(6, produto.getEstoque());
            stmt.setInt(7, produto.getIdCategoria());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Produto produto) throws SQLException {
        String sql = "UPDATE Produto SET Nome = ?, Marca = ?, Tamanho = ?, Cor = ?, Preco = ?, Estoque = ?, ID_Categoria = ? WHERE ID_Produto = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getMarca());
            stmt.setString(3, produto.getTamanho());
            stmt.setString(4, produto.getCor());
            stmt.setDouble(5, produto.getPreco());
            stmt.setInt(6, produto.getEstoque());
            stmt.setInt(7, produto.getIdCategoria());
            stmt.setInt(8, produto.getIdProduto());
            stmt.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM Produto WHERE ID_Produto = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public Produto buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM Produto WHERE ID_Produto = ?";
        Produto produto = null;
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                produto = new Produto();
                produto.setIdProduto(rs.getInt("ID_Produto"));
                produto.setNome(rs.getString("Nome"));
                produto.setMarca(rs.getString("Marca"));
                produto.setTamanho(rs.getString("Tamanho"));
                produto.setCor(rs.getString("Cor"));
                produto.setPreco(rs.getDouble("Preco"));
                produto.setEstoque(rs.getInt("Estoque"));
                produto.setIdCategoria(rs.getInt("ID_Categoria"));
            }
        }
        return produto;
    }

    public List<Produto> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM Produto";
        List<Produto> produtos = new ArrayList<>();
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("ID_Produto"));
                produto.setNome(rs.getString("Nome"));
                produto.setMarca(rs.getString("Marca"));
                produto.setTamanho(rs.getString("Tamanho"));
                produto.setCor(rs.getString("Cor"));
                produto.setPreco(rs.getDouble("Preco"));
                produto.setEstoque(rs.getInt("Estoque"));
                produto.setIdCategoria(rs.getInt("ID_Categoria"));
                produtos.add(produto);
            }
        }
        return produtos;
    }
}

