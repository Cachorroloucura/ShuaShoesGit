package br.com.shuashoeswebapp;
import dao.ClienteDAO;
import model.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            // Configuração da conexão com o banco de dados
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shuashoesbd2", "shua", "5505");


            // Instância do ClienteDAO
            ClienteDAO clienteDAO = new ClienteDAO(conexao);

            // Scanner para interação via terminal
            Scanner scanner = new Scanner(System.in);

            // Loop principal
            while (true) {
                System.out.println("Operações com Cliente:");
                System.out.println("1 - Criar Cliente");
                System.out.println("2 - Ler Cliente por ID");
                System.out.println("3 - Atualizar Cliente");
                System.out.println("4 - Deletar Cliente");
                System.out.println("5 - Listar Todos os Clientes");
                System.out.println("0 - Sair");

                int escolha = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                switch (escolha) {
                    case 1:
                        criarCliente(scanner, clienteDAO);
                        break;

                    case 2:
                        lerClientePorId(scanner, clienteDAO);
                        break;

                    case 3:
                        atualizarCliente(scanner, clienteDAO);
                        break;

                    case 4:
                        deletarCliente(scanner, clienteDAO);
                        break;

                    case 5:
                        listarTodosOsClientes(clienteDAO);
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        return;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void criarCliente(Scanner scanner, ClienteDAO clienteDAO) throws SQLException {
        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite o CPF:");
        String cpf = scanner.nextLine();
        System.out.println("Digite o email:");
        String email = scanner.nextLine();
        System.out.println("Digite o telefone:");
        String telefone = scanner.nextLine();
        System.out.println("Digite o endereço:");
        String endereco = scanner.nextLine();
        System.out.println("Digite a data de nascimento (YYYY-MM-DD):");
        String dataNascimentoStr = scanner.nextLine();
        java.sql.Date dataNascimento = java.sql.Date.valueOf(dataNascimentoStr);
        System.out.println("Digite o gênero:");
        String genero = scanner.nextLine();
        System.out.println("Digite as preferências:");
        String preferencias = scanner.nextLine();
        System.out.println("Digite o histórico de compras:");
        String historicoCompras = scanner.nextLine();

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setEndereco(endereco);
        cliente.setDataNascimento(dataNascimento);
        cliente.setGenero(genero);
        cliente.setPreferencias(preferencias);
        cliente.setHistoricoCompras(historicoCompras);

        clienteDAO.inserir(cliente);
        System.out.println("Cliente criado com sucesso!");
    }

    private static void lerClientePorId(Scanner scanner, ClienteDAO clienteDAO) throws SQLException {
        System.out.println("Digite o ID do cliente para ler:");
        String usuario = scanner.nextLine();

        Cliente cliente = clienteDAO.buscarPorNome(usuario);
        if (cliente != null) {
            System.out.println("ID: " + cliente.getIdCliente());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
            System.out.println("Gênero: " + cliente.getGenero());
            System.out.println("Preferências: " + cliente.getPreferencias());
            System.out.println("Histórico de Compras: " + cliente.getHistoricoCompras());
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    private static void atualizarCliente(Scanner scanner, ClienteDAO clienteDAO) throws SQLException {
        System.out.println("Digite o nome do cliente para atualizar:");
        String usuario = scanner.nextLine();
        scanner.nextLine(); // Consumir nova linha

        Cliente cliente = clienteDAO.buscarPorNome(usuario);
        if (cliente != null) {
            System.out.println("Digite o novo nome (atual: " + cliente.getNome() + "):");
            String nome = scanner.nextLine();
            System.out.println("Digite o novo CPF (atual: " + cliente.getCpf() + "):");
            String cpf = scanner.nextLine();
            System.out.println("Digite o novo email (atual: " + cliente.getEmail() + "):");
            String email = scanner.nextLine();
            System.out.println("Digite o novo telefone (atual: " + cliente.getTelefone() + "):");
            String telefone = scanner.nextLine();
            System.out.println("Digite o novo endereço (atual: " + cliente.getEndereco() + "):");
            String endereco = scanner.nextLine();
            System.out.println("Digite a nova data de nascimento (atual: " + cliente.getDataNascimento() + ") (YYYY-MM-DD):");
            String dataNascimentoStr = scanner.nextLine();
            java.sql.Date dataNascimento = java.sql.Date.valueOf(dataNascimentoStr);
            System.out.println("Digite o novo gênero (atual: " + cliente.getGenero() + "):");
            String genero = scanner.nextLine();
            System.out.println("Digite as novas preferências (atual: " + cliente.getPreferencias() + "):");
            String preferencias = scanner.nextLine();
            System.out.println("Digite o novo histórico de compras (atual: " + cliente.getHistoricoCompras() + "):");
            String historicoCompras = scanner.nextLine();

            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setEmail(email);
            cliente.setTelefone(telefone);
            cliente.setEndereco(endereco);
            cliente.setDataNascimento(dataNascimento);
            cliente.setGenero(genero);
            cliente.setPreferencias(preferencias);
            cliente.setHistoricoCompras(historicoCompras);

            clienteDAO.atualizar(cliente);
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    private static void deletarCliente(Scanner scanner, ClienteDAO clienteDAO) throws SQLException {
        System.out.println("Digite o ID do cliente para deletar:");
        int id = scanner.nextInt();

        clienteDAO.remover(id);
        System.out.println("Cliente deletado com sucesso!");
    }

    private static void listarTodosOsClientes(ClienteDAO clienteDAO) throws SQLException {
        List<Cliente> clientes = clienteDAO.buscarTodos();

        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getIdCliente());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
            System.out.println("Gênero: " + cliente.getGenero());
            System.out.println("Data de Cadastro: " + cliente.getDataCadastro());
            System.out.println("Preferências: " + cliente.getPreferencias());
            System.out.println("Histórico de Compras: " + cliente.getHistoricoCompras());
            System.out.println("---------------------------------------");
        }
    }
}
