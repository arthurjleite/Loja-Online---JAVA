package meu_package;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorProdutos {
	
	private List<Produto> produtos;
	
	public GerenciadorProdutos() {
        this.produtos = new ArrayList<>();
        inicializarProdutosExemplo(); // Adiciona alguns produtos de exemplo para teste
    }
	
	//Método - Cadastrar produto
	public void cadastrarProduto(int codigo, String nome, String categoria, double preco, int quantidadeEstoque) {
        // Verifica se já existe produto com mesmo código
        if (buscarPorCodigo(codigo) != null) {
            System.out.println("\nErro: Já existe um produto com este código!");
            return;
        }
        
        Produto novoProduto = new Produto(codigo, nome, categoria, preco, quantidadeEstoque);
        produtos.add(novoProduto);
        System.out.println("\nProduto cadastrado com sucesso!");
    }
	
	//Método - buscar por código
	public Produto buscarPorCodigo(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null; // Produto não encontrado
    }
	
	//Método - listar produtos
	public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("\nNenhum produto cadastrado no sistema!");
            return;
        }
        
        System.out.println("\n--- LISTA DE PRODUTOS ---\n");
        System.out.println("Total de produtos: " + produtos.size());
        System.out.println("---------------------------");
        
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + ". " + produtos.get(i));
        }
    }
	
	//Método - atualizar produto
	public boolean atualizarProduto(int codigo, String novoNome, String novaCategoria, double novoPreco, int novaQuantidade) {
		Produto produto = buscarPorCodigo(codigo);
		if (produto != null) {
			produto.setNome(novoNome);
			produto.setCategoria(novaCategoria);
			produto.setPreco(novoPreco);
			produto.setQuantidadeEstoque(novaQuantidade);
			System.out.println("\nProduto atualizado com sucesso!");
			return true;
		} else {
			System.out.println("\nProduto não encontrado!");
			return false;
		}
	}
	
	//Método - remover produto
	public boolean removerProduto(int codigo) {
        Produto produto = buscarPorCodigo(codigo);
        if (produto != null) {
            produtos.remove(produto);
            System.out.println("\nProduto removido com sucesso!");
            return true;
        } else {
            System.out.println("\nProduto não encontrado!");
            return false;
        }
    }
	
	//Método - atualizar estoque (automático)
	public boolean atualizarEstoqueVenda(int codigo, int quantidadeVendida) {
        Produto produto = buscarPorCodigo(codigo);
        if (produto != null) {

            return produto.diminuirEstoque(quantidadeVendida);
        }
        return false;
    }
	
	//Método - aumentar estoque
	public boolean aumentarEstoque(int codigo, int quantidade) {
	    Produto produto = buscarPorCodigo(codigo);
	    if (produto != null) {
	        produto.aumentarEstoque(quantidade);
	        System.out.println("\nEstoque aumentado com sucesso! Novo estoque: " + produto.getQuantidadeEstoque());
	        return true;
	    }
	    System.out.println("\nProduto não encontrado!");
	    return false;
	}
	
	//Método - Listar produtos com estoque baixo
	
	public void listarProdutosEstoqueBaixo(int limite) {
	    System.out.println("\nProdutos com menos de " + limite + " unidades:\n");
	    
	    boolean encontrouAlgo = false;
	    
	    for (Produto produto : produtos) {
	        if (produto.getQuantidadeEstoque() < limite) {
	            System.out.println(produto.getNome() + " - " + 
	                             produto.getQuantidadeEstoque() + " unidades" + "| Código: " + produto.getCodigo());
	            encontrouAlgo = true;
	        }
	    }
	    if (!encontrouAlgo) {
	        System.out.println("Nenhum produto com estoque baixo!");
	    }
	}
	
	
	//Métodos auxiliares
	
	public int getQuantidadeProdutos() {
        return produtos.size();
    }
	
	public boolean temProdutos() {
        return !produtos.isEmpty();
    }
	
	public List<Produto> getTodosProdutos() {
        return new ArrayList<>(produtos); // Retorna cópia para segurança
    }
	
	//Método - inicializar produtos (exemplo)
	private void inicializarProdutosExemplo() {
        cadastrarProduto(1, "Notebook Dell", "Informática", 2500.00, 10);
        cadastrarProduto(2, "Mouse Sem Fio", "Informática", 89.90, 25);
        cadastrarProduto(3, "Teclado Mecânico", "Informática", 199.90, 15);
        cadastrarProduto(4, "Smartphone Samsung", "Celulares", 1500.00, 8);
        cadastrarProduto(5, "Fone Bluetooth", "Áudio", 159.90, 30);
        cadastrarProduto(6, "Tablet Android", "Eletrônicos", 799.90, 5);
        cadastrarProduto(7, "Monitor 24\"", "Informática", 899.90, 12);
        cadastrarProduto(8, "Impressora Laser", "Informática", 699.90, 6);
        cadastrarProduto(9, "Webcam HD", "Informática", 129.90, 18);
        cadastrarProduto(10, "SSD 500GB", "Informática", 299.90, 22);
    }
	
	

}
