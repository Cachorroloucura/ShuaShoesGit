package dao;

import model.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private Connection conexao;

    public CategoriaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO Categoria (Nome_Categoria, Descricao) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNomeCategoria());
            stmt.setString(2, categoria.getDescricao());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Categoria categoria) throws SQLException {
        String sql = "UPDATE Categoria SET Nome_Categoria = ?, Descricao = ? WHERE ID_Categoria = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNomeCategoria());
            stmt.setString(2, categoria.getDescricao());
            stmt.setInt(3, categoria.getIdCategoria());
            stmt.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM Categoria WHERE ID_Categoria = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public Categoria buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM Categoria WHERE ID_Categoria = ?";
        Categoria categoria = null;
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("ID_Categoria"));
                categoria.setNomeCategoria(rs.getString("Nome_Categoria"));
                categoria.setDescricao(rs.getString("Descricao"));
            }
        }
        return categoria;
    }

    public List<Categoria> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM Categoria";
        List<Categoria> categorias = new ArrayList<>();
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("ID_Categoria"));
                categoria.setNomeCategoria(rs.getString("Nome_Categoria"));
                categoria.setDescricao(rs.getString("Descricao"));
                categorias.add(categoria);
            }
        }
        return categorias;
    }
}

