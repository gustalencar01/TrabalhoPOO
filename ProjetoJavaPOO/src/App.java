import entidades.Usuario;
import entidades.Fornecedor;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ServicoAutenticacao servicoAutenticacao = new ServicoAutenticacao();
        ServicoProdutos servicoProdutos = new ServicoProdutos();
        GerenciamentoClientes gerenciamentoClientes = new GerenciamentoClientes();
        ServicoFornecedor servicoFornecedor = new ServicoFornecedor();
        Scanner scanner = new Scanner(System.in);


        boolean sistemaAtivo = true;

        while (sistemaAtivo) {
            System.out.println("Bem-vindo ao Sistema.");
            System.out.println("1. Cadastrar Usuario");
            System.out.println("2. Login");
            System.out.println("3. Cadastrar Produto");
            System.out.println("4. Gerenciamento de Clientes");
            System.out.println("5. Sair");
            System.out.printf("Digite a sua escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
        
            switch (opcao) {
                case 1:
                    // Cadastro de novo usuario
                    System.out.println("Cadastro de Usuario:");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();
        
                    Usuario usuario = new Usuario(nome, email, senha);
        
                    servicoAutenticacao.cadastrarUsuario(usuario);
                    System.out.println("  ");
                    System.out.println("Usuario cadastrado com sucesso.");
                    System.out.println("  ");
                    break;
                case 2:
                    // Login de usuario
                    System.out.println("Login de Usuario:");
                    System.out.print("Email: ");
                    String emailLogin = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senhaLogin = scanner.nextLine();
        
                    Usuario usuarioAutenticado = servicoAutenticacao.login(emailLogin, senhaLogin);
                    if (usuarioAutenticado != null) {
                        System.out.println("  ");
                        System.out.println("Login realizado com sucesso.");
                        System.out.println("  ");
                    } else {
                        System.out.println("  ");
                        System.out.println("Email ou senha incorretos.");
                        System.out.println("  ");
                    }
                    break;
                case 3:
                    // Cadastro de novo produto
                    System.out.println("Cadastro de Produto:");
                    System.out.print("Nome: ");
                    String nomeProduto = scanner.nextLine();
                    System.out.print("Codigo: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha
                    System.out.print("Preco: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();

                    servicoProdutos.adicionarProduto(codigo, nomeProduto, preco, quantidade);
                    System.out.println(" ");
                    System.out.println("Produto cadastrado com sucesso.");
                    System.out.println(" ");
                    break;
                case 4:
                    // Gerenciamento de clientes
                    boolean gerenciarClientes = true;
                    while (gerenciarClientes) {
                        System.out.println("Gerenciamento de Clientes:");
                        System.out.println("1. Adicionar Cliente");
                        System.out.println("2. Remover Cliente");
                        System.out.println("3. Atualizar Cliente");
                        System.out.println("4. Listar Clientes");
                        System.out.println("5. Servico de Fornecedor");
                        System.out.println("6. Voltar");
                        System.out.printf("Digite a sua escolha: ");
                        int opcaoCliente = scanner.nextInt();
                        scanner.nextLine(); // Consumir nova linha

                        switch (opcaoCliente) {
                            case 1:
                                // Adicionar cliente
                                System.out.print("Nome: ");
                                String nomeCliente = scanner.nextLine();
                                System.out.print("Email: ");
                                String emailCliente = scanner.nextLine();
                                System.out.print("Telefone: ");
                                String telefoneCliente = scanner.nextLine();

                                int idCliente = gerenciamentoClientes.adicionarCliente(nomeCliente, emailCliente, telefoneCliente);
                                System.out.println("Cliente adicionado com sucesso. ID: " + idCliente);
                                break;
                            case 2:
                                // Remover cliente
                                System.out.print("ID do Cliente: ");
                                int idRemover = scanner.nextInt();
                                scanner.nextLine(); // Consumir nova linha

                                boolean removido = gerenciamentoClientes.removerCliente(idRemover);
                                if (removido) {
                                    System.out.println("Cliente removido com sucesso.");
                                } else {
                                    System.out.println("Cliente não encontrado.");
                                }
                                break;
                            case 3:
                                // Atualizar cliente
                                System.out.print("ID do Cliente: ");
                                int idAtualizar = scanner.nextInt();
                                scanner.nextLine(); // Consumir nova linha
                                System.out.print("Nome (deixe em branco para não alterar): ");
                                String novoNome = scanner.nextLine();
                                System.out.print("Email (deixe em branco para não alterar): ");
                                String novoEmail = scanner.nextLine();

                                boolean atualizado = gerenciamentoClientes.atualizarCliente(idAtualizar, novoNome.isEmpty() ? null : novoNome, novoEmail.isEmpty() ? null : novoEmail);
                                if (atualizado) {
                                    System.out.println("Cliente atualizado com sucesso.");
                                } else {
                                    System.out.println("Cliente não encontrado.");
                                }
                                break;
                            case 4:
                                // Listar clientes
                                System.out.println("Lista de Clientes:");
                                System.out.println(gerenciamentoClientes.listarClientes());
                                break;
                            case 5:
                                // Voltar
                                gerenciarClientes = false;
                                break;
                            default:
                                System.out.println("Opcao invalida. Tente novamente.");
                                break;
                        }
                    }
                    break;
                    case 5:
                    // Gerenciamento de fornecedores
                    boolean gerenciarFornecedores = true;
                    while (gerenciarFornecedores) {
                        System.out.println("Gerenciamento de Fornecedores:");
                        System.out.println("1. Adicionar Fornecedor");
                        System.out.println("2. Remover Fornecedor");
                        System.out.println("3. Atualizar Fornecedor");
                        System.out.println("4. Listar Fornecedores");
                        System.out.println("5. Voltar");
                        System.out.printf("Digite a sua escolha: ");
                        int opcaoFornecedor = scanner.nextInt();
                        scanner.nextLine(); // Consumir nova linha
                
                        switch (opcaoFornecedor) {
                            case 1:
                                // Adicionar fornecedor
                                System.out.print("Nome: ");
                                String nomeFornecedor = scanner.nextLine();
                                System.out.print("Email: ");
                                String emailFornecedor = scanner.nextLine();
                                System.out.print("Telefone: ");
                                String telefoneFornecedor = scanner.nextLine();
                
                                int idFornecedor = servicoFornecedor.cadastrarFornecedor(nomeFornecedor, emailFornecedor, telefoneFornecedor);
                                System.out.println("Fornecedor adicionado com sucesso. ID: " + idFornecedor);
                                break;
                            case 2:
                                // Remover fornecedor
                                System.out.print("ID do Fornecedor: ");
                                int nomeRemove = scanner.nextInt();
                                scanner.nextLine(); // Consumir nova linha
                
                                boolean fornecedorRemovido = servicoFornecedor.removerFornecedor(nomeRemove);
                                if (fornecedorRemovido) {
                                    System.out.println("Fornecedor removido com sucesso.");
                                } else {
                                    System.out.println("Fornecedor não encontrado.");
                                }
                                break;
                            case 3:
                                // Atualizar fornecedor
                                System.out.print("ID do Fornecedor: ");
                                int idAtualizarFornecedor = scanner.nextInt();
                                scanner.nextLine(); // Consumir nova linha
                                System.out.print("Nome (deixe em branco para não alterar): ");
                                String novoNomeFornecedor = scanner.nextLine();
                                System.out.print("Email (deixe em branco para não alterar): ");
                                String novoEmailFornecedor = scanner.nextLine();
                                System.out.print("Telefone (deixe em branco para não alterar): ");
                                String novoTelefoneFornecedor = scanner.nextLine();
                
                                boolean fornecedorAtualizado = servicoFornecedor.atualizarDadosFornecedor(
                                    idAtualizarFornecedor, 
                                    novoNomeFornecedor.isEmpty() ? null : novoNomeFornecedor, 
                                    novoEmailFornecedor.isEmpty() ? null : novoEmailFornecedor, 
                                    novoTelefoneFornecedor.isEmpty() ? null : novoTelefoneFornecedor
                                );
                                if (fornecedorAtualizado) {
                                    System.out.println("Fornecedor atualizado com sucesso.");
                                } else {
                                    System.out.println("Fornecedor não encontrado.");
                                }
                                break;
                            case 4:
                                // Listar fornecedores
                                System.out.println("Lista de Fornecedores:");
                                System.out.println(servicoFornecedor.listarFornecedores());
                                break;
                            case 5:
                                // Voltar
                                gerenciarFornecedores = false;
                                break;
                            default:
                                System.out.println("Opcao invalida. Tente novamente.");
                                break;
                        }
                    }
                    break;
                case 6:
                    // Sair do sistema
                    sistemaAtivo = false;
                    System.out.println("  ");
                    System.out.println("Saindo do sistema...");
                    System.out.println("  ");
                    break;
                default:
                System.out.println("  ");
                    System.out.println("Opcao invalida. Tente novamente.");
                    System.out.println("  ");
                    break;
            }
        }
    }
}
