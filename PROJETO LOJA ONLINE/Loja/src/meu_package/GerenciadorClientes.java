package meu_package;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorClientes {
	
	private List<Cliente> clientes;
	
	public GerenciadorClientes() {
        this.clientes = new ArrayList<>();
        inicializarClientesExemplo(); // Adiciona alguns clientes de exemplo para teste
    }
	
	//Método - cadastrar cliente
	public void cadastrarCliente(String cpf, String nome) {
		
        if (buscarPorCPF(cpf) != null) {
            System.out.println("\nErro: Já existe um cliente com este CPF!");
            return;
        }
        
        if (cpf == null || cpf.trim().isEmpty()) {
            System.out.println("\nErro: CPF não pode estar vazio!");
            return;
        }
        
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("\nErro: Nome não pode estar vazio!");
            return;
        }
        
        Cliente novoCliente = new Cliente(cpf, nome);
        clientes.add(novoCliente);
        System.out.println("\nCliente cadastrado com sucesso!");
    }
	
	//Método - buscar por cpf
	public Cliente buscarPorCPF(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null; // Cliente não encontrado
    }
	
	//Método - Listar clientes
	public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("\nNenhum cliente cadastrado no sistema!");
            return;
        }
        
        System.out.println("\n--- LISTA DE CLIENTES ---\n");
        System.out.println("Total de clientes: " + clientes.size());
        System.out.println("---------------------------");
        
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i));
        }
    }
	
	//Método - atualizar cliente
	public boolean atualizarCliente(String cpf, String novoNome) {
        Cliente cliente = buscarPorCPF(cpf);
        if (cliente != null) {
            if (novoNome == null || novoNome.trim().isEmpty()) {
                System.out.println("\nErro: Nome não pode estar vazio!");
                return false;
            }
            
            cliente.setNome(novoNome);
            return true;
        } else {
            System.out.println("\nCliente não encontrado!");
            return false;
        }
    }
	
	//Remover cliente
	public boolean removerCliente(String cpf) {
        Cliente cliente = buscarPorCPF(cpf);
        if (cliente != null) {
            clientes.remove(cliente);
            return true;
        } else {
            System.out.println("\nCliente não encontrado!");
            return false;
        }
    }
	
	//Métodos auxiliares
	
	public int getQuantidadeClientes() {
        return clientes.size();
    }
	
	public boolean temClientes() {
        return !clientes.isEmpty();
    }
	
	public List<Cliente> getTodosClientes() {
        return new ArrayList<>(clientes); 
    }
	
	//Método - inicializar clientes (exemplo)
	private void inicializarClientesExemplo() {
        cadastrarCliente("123.456.789-00", "João Silva");
        cadastrarCliente("987.654.321-00", "Maria Santos");
        cadastrarCliente("111.222.333-44", "Pedro Oliveira");
        cadastrarCliente("555.666.777-88", "Ana Costa");
        cadastrarCliente("999.888.777-66", "Carlos Pereira");
    }

}

