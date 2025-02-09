package entidades;
import java.util.ArrayList;
import java.util.List;

public class Fornecedor {
    private List<Fornecedor> fornecedores;
    private String nome;
    private String email;
    private String endereco;
    private String contato;

    public Fornecedor(String nome, String email, String endereco, String contato) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
