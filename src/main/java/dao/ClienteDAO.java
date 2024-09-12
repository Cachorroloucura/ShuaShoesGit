package dao;
import model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private Connection conexao;

    public ClienteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (Nome, CPF, Email, Telefone, Endereço, Data_Nascimento, Genero, Preferencias, Historico_Compras) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEndereco());
            stmt.setDate(6, new java.sql.Date(cliente.getDataNascimento().getTime()));
            stmt.setString(7, cliente.getGenero());
            stmt.setString(8, cliente.getPreferencias());
            stmt.setString(9, cliente.getHistoricoCompras());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Cliente cliente) throws SQLException {
        String sql = "UPDATE Cliente SET Nome = ?, CPF = ?, Email = ?, Telefone = ?, Endereço = ?, Data_Nascimento = ?, Genero = ?, Preferencias = ?, Historico_Compras = ? WHERE ID_Cliente = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEndereco());
            stmt.setDate(6, new java.sql.Date(cliente.getDataNascimento().getTime()));
            stmt.setString(7, cliente.getGenero());
            stmt.setString(8, cliente.getPreferencias());
            stmt.setString(9, cliente.getHistoricoCompras());
            stmt.setInt(10, cliente.getIdCliente());
            stmt.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM Cliente WHERE ID_Cliente = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public Cliente buscarPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM Cliente WHERE nome = ?";
        Cliente cliente = null;
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("ID_Cliente"));
                cliente.setNome(rs.getString("Nome"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setEmail(rs.getString("Email"));
                cliente.setTelefone(rs.getString("Telefone"));
                cliente.setEndereco(rs.getString("Endereço"));
                cliente.setDataNascimento(rs.getDate("Data_Nascimento"));
                cliente.setGenero(rs.getString("Genero"));
                cliente.setDataCadastro(rs.getDate("Data_Cadastro"));
                cliente.setPreferencias(rs.getString("Preferencias"));
                cliente.setHistoricoCompras(rs.getString("Historico_Compras"));
            }
        }
        return cliente;
    }

    public List<Cliente> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM Cliente";
        List<Cliente> clientes = new ArrayList<>();
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("ID_Cliente"));
                cliente.setNome(rs.getString("Nome"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setEmail(rs.getString("Email"));
                cliente.setTelefone(rs.getString("Telefone"));
                cliente.setEndereco(rs.getString("Endereço"));
                cliente.setDataNascimento(rs.getDate("Data_Nascimento"));
                cliente.setGenero(rs.getString("Genero"));
                cliente.setDataCadastro(rs.getDate("Data_Cadastro"));
                cliente.setPreferencias(rs.getString("Preferencias"));
                cliente.setHistoricoCompras(rs.getString("Historico_Compras"));
                clientes.add(cliente);
            }
        }
        return clientes;
    }
}
