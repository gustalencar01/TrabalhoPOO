import entidades.Produto;
import entidades.Estoque;
import java.util.HashMap;
import java.util.Map;

public class ServicoProdutos {
    private Map<Integer, Produto> produtos;
    private Estoque estoque;
    private int ultimoId;

    public ServicoProdutos() {
        this.produtos = new HashMap<>();
        this.estoque = new Estoque();
        this.ultimoId = 0;
    }

    public int adicionarProduto(int codigo, String nome, double preco, int quantidadeEstoque) {

        Produto produto = estoque.cadastrarProduto(codigo, nome, preco, quantidadeEstoque);
        produtos.put(produto.getcodigo(), produto);
        return produto.getcodigo();
    }

    public boolean removerProduto(int produtoCodigo) {
        if (produtos.containsKey(produtoCodigo)) {
            produtos.remove(produtoCodigo);
            return true;
        }
        return false;
    }

    public boolean atualizarProduto(int produtoCodigo, String nome, String descricao, Double preco, Integer quantidadeEstoque) {
        if (produtos.containsKey(produtoCodigo)) {
            Produto produto = produtos.get(produtoCodigo);
            if (nome != null) produto.setNome(nome);    
            if (preco != null) produto.setPreco(preco);
            if (quantidadeEstoque != null) produto.setQuantidadeEstoque(quantidadeEstoque);
            return true;
        }
        return false;
    }

    public Map<Integer, Produto> listarProdutos() {
        return produtos;
    }

    public Produto buscarProdutoCodigo(int produtoCodigo) {
        return produtos.get(produtoCodigo);
    }

    public Produto buscarProdutoPorNome(String nome) {
        for (Produto produto : produtos.values()) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }
        return null;
    }
}