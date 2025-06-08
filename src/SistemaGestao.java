import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaGestao {

    // Caminho completo incluindo nome do arquivo
    private static final String CAMINHO_ARQUIVO = "C:\\Users\\ygorm\\OneDrive\\Desktop\\cliente.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();

        carregarClientes(clientes);

        boolean executando = true;
        while (executando) {
            System.out.println("\n=== Menu do sistema de Gestão ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Lista de Clientes");
            System.out.println("3. Buscar Cliente pelo Nome");
            System.out.println("4. Atualizar Cliente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o telefone do cliente: ");
                    String telefone = scanner.nextLine();
                    Cliente cliente = new Cliente(nome, telefone);
                    clientes.add(cliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("\nLista de clientes:");
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        for (Cliente c : clientes) {
                            System.out.println("Nome: " + c.getNome() + ", Telefone: " + c.getTelefone());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Digite o nome do cliente a ser buscado: ");
                    String nomeBusca = scanner.nextLine();
                    boolean encontrado = false;
                    for (Cliente c : clientes) {
                        if (c.getNome().equalsIgnoreCase(nomeBusca)) {
                            System.out.println("Cliente encontrado: Nome: " + c.getNome() + ", Telefone: " + c.getTelefone());
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o nome do cliente que deseja atualizar: ");
                    String nomeAtualizar = scanner.nextLine();
                    boolean atualizado = false;
                    for (Cliente c : clientes) {
                        if (c.getNome().equalsIgnoreCase(nomeAtualizar)) {
                            System.out.print("Digite o novo nome: ");
                            String novoNome = scanner.nextLine();
                            System.out.print("Digite o novo telefone: ");
                            String novoTelefone = scanner.nextLine();
                            c.setNome(novoNome);
                            c.setTelefone(novoTelefone);
                            atualizado = true;
                            System.out.println("Cliente atualizado com sucesso!");
                            break;
                        }
                    }
                    if (!atualizado) {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 5:
                    salvarClientes(clientes);  // Salva os dados antes de sair
                    executando = false;
                    System.out.println("Encerrando o sistema. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }

    // Método para salvar clientes no arquivo especificado em CAMINHO_ARQUIVO
    public static void salvarClientes(List<Cliente> clientes) {
        try (PrintWriter writer = new PrintWriter(CAMINHO_ARQUIVO)) {
            for (Cliente cliente : clientes) {
                writer.println(cliente.getNome() + "," + cliente.getTelefone());
            }
            System.out.println("Dados salvos em: " + CAMINHO_ARQUIVO);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    // Método para carregar clientes do arquivo especificado em CAMINHO_ARQUIVO
    public static void carregarClientes(List<Cliente> clientes) {
        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 2) {
                    Cliente cliente = new Cliente(dados[0], dados[1]);
                    clientes.add(cliente);
                }
            }
            System.out.println("Clientes carregados do arquivo.");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Iniciando com lista vazia.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
        }
    }
}
