package entidades;

public class Produto {
    private int codigo;

    private String nome;

    private double preco;

    private int quantidadeEstoque;



    public Produto(int codigo, String nome, double preco, int quantidadeEstoque) {

        this.codigo = codigo;

        this.nome = nome;

        this.preco = preco;

        this.quantidadeEstoque = quantidadeEstoque;

    }

    public int getcodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getIdProduto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIdProduto'");
    }
}