
import ServicoClientes.Cliente;
import java.util.HashMap;
import java.util.Map;


public class GerenciamentoClientes {
    private Map<Integer, Cliente> clientes;
    private int ultimoId;

    public GerenciamentoClientes() {
        this.clientes = new HashMap<>();
        this.ultimoId = 0;
    }

    public int adicionarCliente(String nome, String email, String telefone) {
        ultimoId++;
        Cliente cliente = new Cliente(ultimoId, nome, email, telefone);
        clientes.put(ultimoId, cliente);
        return ultimoId;
    }

    public boolean removerCliente(int clienteId) {
        if (clientes.containsKey(clienteId)) {
            clientes.remove(clienteId);
            return true;
        }
        return false;
    }

    public boolean atualizarCliente(int clienteId, String nome, String email) {
        if (clientes.containsKey(clienteId)) {
            Cliente cliente = clientes.get(clienteId);
            if (nome != null) cliente.setNome(nome);
            if (email != null) cliente.setEmail(email);
            return true;
        }
        return false;
    }

    public Map<Integer, Cliente> listarClientes() {
        return clientes;
    }

    public Cliente buscarClientePorId(int clienteId) {
        return clientes.get(clienteId);
    }

    public Cliente buscarClientePorNome(String nome) {
        for (Cliente cliente : clientes.values()) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }
}
