package entidades;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;
    private int proximoId;

    public Estoque() {
        this.produtos = new ArrayList<>();
        this.proximoId = 1;
    }

    public Produto cadastrarProduto(Integer codigo, String nome, double preco, int quantidadeEstoque) {
        int id;
        if (codigo != null) {
            if (codigo <= 0) {
                throw new IllegalArgumentException("O codigo deve ser um número positivo.");
            }

            if (idJaExiste(codigo)) {
                throw new IllegalArgumentException("O codigo " + codigo + " já está em uso.");
            }

            id = codigo;
        } else {
            id = proximoId++;
        }
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome do produto é obrigatório.");
        }

        if (preco <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }
        if (quantidadeEstoque < 0) {
            throw new IllegalArgumentException("A quantidade inicial não pode ser negativa.");
        }
        Produto novoProduto = new Produto(id, nome, preco, quantidadeEstoque);
        produtos.add(novoProduto);
        return novoProduto;
    }

    private boolean idJaExiste(int id) {
        for (Produto p : produtos) {
            if (p.getIdProduto() == id) {
                return true;
            }
        }
        return false;
    }
}