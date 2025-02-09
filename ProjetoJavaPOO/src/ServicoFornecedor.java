import java.util.ArrayList;
import java.util.List;

import entidades.Fornecedor;

public class ServicoFornecedor {
    private String nome;
    private String email;
    private String endereco;
    private String contato; 
    private static List<Fornecedor> fornecedores = new ArrayList<>();
    public Fornecedor cadastrarFornecedor(String nome, String email, String endereco, String contato) {

        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome do fornecedor é obrigatório.");
        }

        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("O email do fornecedor é obrigatório.");
        }
        if (endereco == null || endereco.isEmpty()) {
            throw new IllegalArgumentException("O endereco do fornecedor é obrigatório.");
        }
        if (contato == null || contato.isEmpty()) {
            throw new IllegalArgumentException("O contato do fornecedor é obrigatório.");
        }
        Fornecedor novoFornecedor = new Fornecedor(nome, email, endereco, contato);
        fornecedores.add(novoFornecedor);
        return novoFornecedor;
    }

    public void atualizarDadosFornecedor(String nome, String email, String endereco, String contato) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("O nome do fornecedor não pode ser vazio.");
        }
        if (email != null && !email.trim().isEmpty()) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("O email do fornecedor não pode ser vazio.");
        }
        if (endereco != null && !endereco.trim().isEmpty()) {
            this.endereco = endereco;
        } else {
            throw new IllegalArgumentException("O endereco do fornecedor não pode ser vazio.");
        }
        if (contato != null && !contato.trim().isEmpty()) {
            this.contato = contato;
        } else {
            throw new IllegalArgumentException("O contato do fornecedor não pode ser vazio.");
        }

    }

    public void removerFornecedor(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do fornecedor não pode ser vazio.");
        }

        boolean removido = fornecedores.removeIf(fornecedor -> fornecedor.getNome().equalsIgnoreCase(nome.trim()));

        if (!removido) {
            throw new IllegalArgumentException("Fornecedor com nome '" + nome + "' não encontrado.");
        }
    }

    public List<Fornecedor> listarFornecedores() {
        return new ArrayList<>(fornecedores);
    }

    public int cadastrarFornecedor(String nomeFornecedor, String emailFornecedor, String telefoneFornecedor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrarFornecedor'");
    }

    public boolean removerFornecedor(int idRemoverFornecedor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerFornecedor'");
    }

    public boolean atualizarDadosFornecedor(int idAtualizarFornecedor, String email2, String endereco2,
            String contato2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarDadosFornecedor'");
    }

}
