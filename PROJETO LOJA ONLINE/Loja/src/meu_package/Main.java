package meu_package;
import java.util.Scanner;
import java.io.IOException;

public class Main {
	private static GerenciadorProdutos gerenciadorProdutos = new GerenciadorProdutos();
    private static GerenciadorClientes gerenciadorClientes = new GerenciadorClientes();
    private static GerenciadorVendas gerenciadorVendas = new GerenciadorVendas();
    private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int opcao;
		limparConsole();
		
		
		do {
			exibirMenuPrincipal();
			
			opcao = lerInteiro("Escolha uma opção (1-4) ou 0 para sair: ");
			
			switch (opcao ) {
			case 1:
				limparConsole();
				menuProdutos();
				break;
			case 2:
				limparConsole();
                menuClientes();
                break;
            case 3:
            	limparConsole();
                menuVendas();
                break;
            case 4:
            	limparConsole();
                menuRelatorios();
                break;
            case 0:
                System.out.println("\nObrigado por utilizar o nosso sistema, até logo!");
                System.out.println("Street Sports inc - Todos os direitos reservados.");
                break;
            default:
                System.out.println("\nOpção inválida!");
			}
		} while(opcao != 0);
		scanner.close();
	}
	
	
	//Menu principal
	private static void exibirMenuPrincipal() {
		limparConsole();
		System.out.println("\nBem vindo ao sistema da Street Sports inc!\n");
		System.out.println("=== MENU PRINCIPAL ===\n");
        System.out.println("1- Gerenciar Produtos");
        System.out.println("2- Gerenciar Clientes");
        System.out.println("3- Realizar Venda");
        System.out.println("4- Relatórios");
        System.out.println("0- Sair");
        System.out.println("");
	}
	
	//Menu produtos
	private static void menuProdutos() {
		int opcao;
		
		do {
			System.out.println("\n=== GERENCIAMENTO DE PRODUTOS ===\n");
            System.out.println("1- Cadastrar Novo Produto");
            System.out.println("2- Listar Todos os Produtos");
            System.out.println("3- Buscar Produto por Código");
            System.out.println("4- Atualizar Produto");
            System.out.println("5- Remover Produto");
            System.out.println("0- Voltar ao Menu Principal");
            System.out.println("");
            
            opcao = lerInteiro("Escolha uma opção (1-5) ou 0 para sair: ");
            
            switch(opcao) {
            case 1:
            	limparConsole();
                cadastrarProduto();
                break;
            case 2:
            	limparConsole();
                gerenciadorProdutos.listarProdutos();
                break;
            case 3:
            	limparConsole();
                buscarProduto();
                break;
            case 4:
            	limparConsole();
                atualizarProduto();
                break;
            case 5:
            	limparConsole();
                removerProduto();
                break;
            case 0:
                System.out.println("\nVoltando ao menu principal...");
                break;
            default:
                System.out.println("\nOpção inválida!");
            }
		} while (opcao != 0);
	}
	
	//Menu clientes
	private static void menuClientes() {
		int opcao;
			
		do {
			System.out.println("\n=== GERENCIAMENTO DE CLIENTES ===\n");
	        System.out.println("1- Cadastrar Novo Cliente");
	        System.out.println("2- Listar Todos os Clientes");
	        System.out.println("3- Buscar Cliente por CPF");
	        System.out.println("4- Atualizar Cliente");
	        System.out.println("5- Remover Cliente");
	        System.out.println("0- Voltar ao Menu Principal");
	        System.out.println("");
	            
	        opcao = lerInteiro("Escolha uma opção (1-5) ou 0 para sair: ");
	            
	        switch(opcao) {
	            case 1:
	            	limparConsole();
	                cadastrarCliente();
	                break;
	            case 2:
	            	limparConsole();
	                gerenciadorClientes.listarClientes();
	                break;
	            case 3:
	            	limparConsole();
	                buscarCliente();
	                break;
	            case 4:
	            	limparConsole();
	                atualizarCliente();
	                break;
	            case 5:
	            	limparConsole();
	                removerCliente();
	                break;
	            case 0:
	                System.out.println("\nVoltando ao menu principal...");
	                break;
	            default:
	                System.out.println("\nOpção inválida! Tente novamente");
	        }
		} while (opcao != 0);
	}
	
	//Menu vendas
	private static void menuVendas() {
		int opcao;
		do {
			limparConsole();
			System.out.println("\n=== REALIZAR VENDA ===\n");
            System.out.println("1- Iniciar/Carregar Venda");
            System.out.println("2- Visualizar Venda Atual");
            System.out.println("3- Finalizar Venda");
            System.out.println("4- Cancelar Venda");
            System.out.println("0- Voltar ao Menu Principal");
            System.out.println("");
            
            opcao = lerInteiro("Escolha uma opção (1-4) ou 0 para sair: ");
            
            switch(opcao) {
                case 1:
                    limparConsole();
                    iniciarCarregarVenda();
                    break;
                case 2:
                    limparConsole();
                    visualizarVendaAtual();
                    break;
                case 3:
                    limparConsole();
                    finalizarVenda();
                    break;
                case 4:
                    limparConsole();
                    cancelarVenda();
                    break;
                case 0:
                    System.out.println("\nVoltando ao menu principal...");
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
            
            if (opcao != 0) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
            }
        } while (opcao != 0);
		
	}
	
	// Método para iniciar/carregar venda
	private static void iniciarCarregarVenda() {
	    System.out.println("\n=== INICIAR/CARREGAR VENDA ===\n");
	    
	    // Verifica se já existe venda em andamento
	    if (gerenciadorVendas.temVendaEmAndamento()) {
	        System.out.println("Já existe uma venda em andamento!\n");
	        gerenciadorVendas.exibirVendaAtual();
	        
	        String opcao = lerTexto("\nDeseja continuar com esta venda? (S/N): ");
	        if (opcao.equalsIgnoreCase("N")) {
	            gerenciadorVendas.cancelarVendaAtual();
	            System.out.println("Venda anterior cancelada. Iniciando nova venda...");
	        } else {
	        	limparConsole();
	            System.out.println("Continuando com venda existente...");
	            adicionarItensVenda();
	            return;
	        }
	    }
	    
	    // Seleção de cliente
	    if (!gerenciadorClientes.temClientes()) {
	        System.out.println("Nenhum cliente cadastrado! Continuando venda sem cliente...");
	        gerenciadorVendas.iniciarNovaVenda(null);
	    } else {
	        gerenciadorClientes.listarClientes();
	        String cpf = lerTexto("\nDigite o CPF do cliente (ou Enter para venda sem cliente): ");
	        Cliente cliente = null;
	        
	        if (!cpf.trim().isEmpty()) {
	            cliente = gerenciadorClientes.buscarPorCPF(cpf);
	            if (cliente == null) {
	                System.out.println("Cliente não encontrado! Continuando venda sem cliente.");
	            }
	        }
	        gerenciadorVendas.iniciarNovaVenda(cliente);
	    }
	    
	    // Adicionar itens à venda
	    adicionarItensVenda();
	}

	// Método para adicionar itens à venda
	private static void adicionarItensVenda() {
	    System.out.println("\n=== ADICIONAR ITENS À VENDA ===\n");
	    
	    boolean continuar = true;
	    
	    while (continuar && gerenciadorVendas.temVendaEmAndamento()) {
	        // Mostrar produtos disponíveis
	        System.out.println("Catálogo de Produtos Disponíveis:");
	        gerenciadorProdutos.listarProdutos();
	        
	        // Mostrar venda atual
	        System.out.println("\n--- VENDA ATUAL ---");
	        gerenciadorVendas.exibirVendaAtual();
	        
	        int codigo = lerInteiro("\nDigite o código do produto (0 para parar): ");
	        
	        if (codigo == 0) {
	            continuar = false;
	        } else {
	            int quantidade = lerInteiro("Digite a quantidade: ");
	            
	            // VALIDAÇÃO: Se quantidade for 0
	            if (quantidade == 0) {
	                limparConsole();
	                System.out.println("\nNenhum item adicionado!\n");
	                continue; // Volta para o início do loop
	            }
	            
	            // Se quantidade for negativa
	            if (quantidade < 0) {
	                limparConsole();
	                System.out.println("\nQuantidade não pode ser negativa!\n");
	                continue; // Volta para o início do loop
	            }
	            
	            // Tenta adicionar o item
	            boolean sucesso = gerenciadorVendas.adicionarItemVenda(codigo, quantidade, gerenciadorProdutos);
	            
	            // Se não conseguiu adicionar (estoque insuficiente, produto não encontrado)
	            if (!sucesso) {
	                System.out.println("\nPressione Enter para tentar novamente...");
	                scanner.nextLine();
	                limparConsole();
	            }
	        }
	    }
	}

	// Método para visualizar venda atual
	private static void visualizarVendaAtual() {
	    if (!gerenciadorVendas.temVendaEmAndamento()) {
	        System.out.println("Nenhuma venda em andamento!");
	        return;
	    }
	    
	    gerenciadorVendas.exibirVendaAtual();
	    
	    // Opção de continuar adicionando itens
	    String opcao = lerTexto("\nDeseja adicionar mais itens? (S/N): ");
	    if (opcao.equalsIgnoreCase("S")) {
	    	limparConsole();
	        adicionarItensVenda();
	    }
	}

	// Método para finalizar venda
	private static void finalizarVenda() {
	    if (!gerenciadorVendas.temVendaEmAndamento()) {
	        System.out.println("Nenhuma venda em andamento!");
	        return;
	    }
	    
	    // Mostrar resumo final
	    System.out.println("=== RESUMO FINAL DA VENDA ===");
	    gerenciadorVendas.exibirVendaAtual();
	    
	    String confirmacao = lerTexto("\nConfirmar finalização da venda? (S/N): ");
	    if (confirmacao.equalsIgnoreCase("S")) {
	        boolean sucesso = gerenciadorVendas.finalizarVendaAtual();
	        if (sucesso) {
	            System.out.println("\nVenda finalizada com sucesso!");
	        }
	    } else {
	        System.out.println("Finalização cancelada.");
	    }
	}

	// Método para cancelar venda
	private static void cancelarVenda() {
	    if (!gerenciadorVendas.temVendaEmAndamento()) {
	        System.out.println("Nenhuma venda em andamento!");
	        return;
	    }
	    
	    gerenciadorVendas.exibirVendaAtual();
	    String confirmacao = lerTexto("\nTem certeza que deseja cancelar esta venda? (S/N): ");
	    
	    if (confirmacao.equalsIgnoreCase("S")) {
	        gerenciadorVendas.cancelarVendaAtual();
	    } else {
	        System.out.println("Cancelamento não realizado.");
	    }
	}
	
	private static void menuRelatorioVendas() {
        int opcao;
        
        do {
            System.out.println("\n=== RELATÓRIO DE VENDAS ===\n");
            System.out.println("1- Listar Todas as Vendas");
            System.out.println("2- Estatísticas Gerais de Vendas");
            System.out.println("0- Voltar ao Menu de Relatórios");
            System.out.println("");
            
            opcao = lerInteiro("Escolha uma opção (1-2) ou 0 para sair: ");
            
            switch(opcao) {
                case 1:
                    limparConsole();
                    gerenciadorVendas.listarVendas();
                    break;
                case 2:
                    limparConsole();
                    gerenciadorVendas.exibirRelatorioVendas();
                    break;
                case 0:
                    System.out.println("\nVoltando ao menu de relatórios...");
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
            
            if (opcao != 0) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
            }
        } while (opcao != 0);
    }
	
	//Menu relatórios
	private static void menuRelatorios() {
		int opcao;
		
		do {
			System.out.println("\n=== RELATÓRIOS ===\n");
            System.out.println("1- Relatório de Produtos");
            System.out.println("2- Relatório de Clientes");
            System.out.println("3- Relatório de Vendas");
            System.out.println("4- Relatório de Estoque Baixo");
            System.out.println("0- Voltar ao Menu Principal");
            System.out.println("");
            
            opcao = lerInteiro("Escolha uma opção (1-3) ou 0 para sair: ");
            
            switch (opcao) {
            	case 1:
            		limparConsole();
            		gerenciadorProdutos.listarProdutos();
                    break;
                case 2:
                	limparConsole();
                    gerenciadorClientes.listarClientes();
                    break;
                case 3:
                	limparConsole();
                	menuRelatorioVendas();
                    break;
                case 4:
                	limparConsole();
                	relatorioEstoqueBaixo();
                	break;
                case 0:
                    System.out.println("\nVoltando ao menu principal...");
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
		} while (opcao != 0);
	}
	
	//Métodos - Controle de produtos
	
	private static void cadastrarProduto() {
		System.out.println("\n=== CADASTRAR NOVO PRODUTO ===\n");
		
		int codigo = lerInteiro("Digite o código do produto: ");
        String nome = lerTexto("Digite o nome do produto: ");
        String categoria = lerTexto("Digite a categoria do produto: ");
        double preco = lerDouble("Digite o preço do produto (ex: 29.90): R$ ");
        int quantidade = lerInteiro("Digite a quantidade em estoque: ");
        
        System.out.println("\nRESUMO DO PRODUTO:\n");
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Categoria: " + categoria);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Estoque: " + quantidade);
        
        String confirmacao = lerTexto("\nConfirmar cadastro? (S/N): ");
        
        if (confirmacao.equalsIgnoreCase("S")) {
            gerenciadorProdutos.cadastrarProduto(codigo, nome, categoria, preco, quantidade);
          
        } else {
            System.out.println("\nCadastro cancelado.");
        }
	}
	
	private static void buscarProduto() {
        System.out.println("\n--- BUSCAR PRODUTO ---\n");
        
        int codigo = lerInteiro("Digite o código do produto: ");
        
        Produto produto = gerenciadorProdutos.buscarPorCodigo(codigo);
        
        if (produto != null) {
            System.out.println("\nProduto encontrado:\n");
            System.out.println(produto);
        } else {
            System.out.println("\nProduto não encontrado!");
        }
	}
	
	private static void atualizarProduto() {
        System.out.println("\n--- ATUALIZAR PRODUTO ---\n");
        int codigo = lerInteiro("Digite o código do produto a ser atualizado: ");
        
        Produto produtoAtual = gerenciadorProdutos.buscarPorCodigo(codigo);
        
        if (produtoAtual == null) {
            System.out.println("\nProduto não encontrado!");
            return;
        }
        
        System.out.println("\nProduto atual: " + produtoAtual);
        System.out.println("\nDigite os novos dados...");
        
        String nome = lerTexto("Novo nome: ");
        String categoria = lerTexto("Nova categoria: ");
        double preco = lerDouble("Novo preço: R$ ");
        int quantidade = lerInteiro("Nova quantidade em estoque: ");
        
        String confirmacao = lerTexto("\nConfirmar atualização? (S/N): ");
        
        if (confirmacao.equalsIgnoreCase("S")) {
            gerenciadorProdutos.atualizarProduto(codigo, nome, categoria, preco, quantidade);
        } else {
            System.out.println("\nAtualização cancelada.");
        }
	}
	
	private static void removerProduto() {
        System.out.println("\n--- REMOVER PRODUTO ---\n");
        int codigo = lerInteiro("Digite o código do produto a ser removido: ");
        
        Produto produto = gerenciadorProdutos.buscarPorCodigo(codigo);
        
        if (produto != null) {
            System.out.println("\nProduto encontrado: " + produto);
            String confirmacao = lerTexto("\nTem certeza que deseja remover este produto? (S/N): ");
            
            if (confirmacao.equalsIgnoreCase("S")) {
                gerenciadorProdutos.removerProduto(codigo);
            } else {
                System.out.println("\nRemoção cancelada.");
            }
            
        } else {
            System.out.println("\nProduto não encontrado!");
        }
	}
	
	//Métodos - Controle de clientes
	
	private static void cadastrarCliente() {
	    System.out.println("\n--- CADASTRAR NOVO CLIENTE ---\n");
	        
	    String cpf = lerTexto("Digite o CPF do cliente: ");
	    String nome = lerTexto("Digite o nome do cliente: ");
	        
	    System.out.println("\nRESUMO DO CLIENTE:");
	    System.out.println("CPF: " + cpf);
	    System.out.println("Nome: " + nome);
	        
	    String confirmacao = lerTexto("\nConfirmar cadastro? (S/N): ");
	        
	    if (confirmacao.equalsIgnoreCase("S")) {
	        gerenciadorClientes.cadastrarCliente(cpf, nome);
	    } else {
	        System.out.println("\nCadastro cancelado.");
	    }
	}
	 
	private static void buscarCliente() {
	    System.out.println("\n--- BUSCAR CLIENTE ---\n");
	        
	    String cpf = lerTexto("Digite o CPF do cliente: ");
	        
	    Cliente cliente = gerenciadorClientes.buscarPorCPF(cpf);
	        
	    if (cliente != null) {
	        System.out.println("\nCliente encontrado:");
	        System.out.println(cliente);
	    } else {
	        System.out.println("\nCliente não encontrado!");
	    }
	}
	
	private static void atualizarCliente() {
	    System.out.println("\n--- ATUALIZAR CLIENTE ---\n");
	    
	    String cpf = lerTexto("Digite o CPF do cliente a ser atualizado: ");
	    
	    Cliente clienteAtual = gerenciadorClientes.buscarPorCPF(cpf);
	    if (clienteAtual == null) {
	        System.out.println("\nCliente não encontrado!");
	        return;
	    }
	    
	    System.out.println("\nCliente atual: " + clienteAtual);
	    
	    System.out.println("\nDigite os novos dados...");
	    String novoNome = lerTexto("Novo nome: ");
	    
	    System.out.println("\nNOVOS DADOS:");
	    System.out.println("CPF: " + cpf);
	    System.out.println("Nome: " + novoNome);
	    
	    String confirmacao = lerTexto("\nConfirmar atualização? (S/N): ");
	    
	    if (confirmacao.equalsIgnoreCase("S")) {
	        boolean sucesso = gerenciadorClientes.atualizarCliente(cpf, novoNome);
	        if (sucesso) {
	            System.out.println("\nCliente atualizado com sucesso!");
	        }
	    } else {
	        System.out.println("\nAtualização cancelada.");
	    }
	}
	
	private static void removerCliente() {
	    System.out.println("\n--- REMOVER CLIENTE ---\n");
	    
	    String cpf = lerTexto("Digite o CPF do cliente a ser removido: ");
	    
	    Cliente cliente = gerenciadorClientes.buscarPorCPF(cpf);
	    if (cliente == null) {
	        System.out.println("\nCliente não encontrado!");
	        return;
	    }
	    
	    System.out.println("\nCliente encontrado: " + cliente);
	    
	    String confirmacao = lerTexto("\nTem certeza que deseja remover este cliente? (S/N): ");
	    
	    if (confirmacao.equalsIgnoreCase("S")) {
	        boolean sucesso = gerenciadorClientes.removerCliente(cpf);
	        if (sucesso) {
	            System.out.println("\nCliente removido com sucesso!");
	        }
	    } else {
	        System.out.println("\nRemoção cancelada.");
	    }
	}
	
	
// Relatório de produtos com estoque baixo
	
	private static void relatorioEstoqueBaixo() {
	    System.out.println("\n--- RELATÓRIO DE ESTOQUE BAIXO ---\n");
	    System.out.println("Escolha como definir estoque baixo:\n");
	    System.out.println("1- Usar limite padrão (5 unidades)");
	    System.out.println("2- Definir limite personalizado");
	    System.out.println("0- Voltar");
	    
	    int opcao = lerInteiro("\nEscolha uma opção: ");
	    
	    switch(opcao) {
	        case 1:
	            gerenciadorProdutos.listarProdutosEstoqueBaixo(5);
	            break;
	            
	        case 2:
	            int limite = lerInteiro("\nDigite o limite para estoque baixo: ");
	            if (limite < 0) {
	                System.out.println("\nLimite não pode ser negativo!");
	                return;
	            }
	            gerenciadorProdutos.listarProdutosEstoqueBaixo(limite);
	            break;
	            
	        case 0:
	            System.out.println("\nVoltando ao menu de relatórios...");
	            break;
	            
	        default:
	            System.out.println("\nOpção inválida!");
	    }
	}
	
	//Leitura de dados
	

	private static void limparConsole() {
	    try {
	        String os = System.getProperty("os.name").toLowerCase();
	        
	        if (os.contains("win")) {
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        }
	    } catch (IOException | InterruptedException e) {
	        System.out.println("Não foi possível limpar o console automaticamente");
	        System.out.println("Pressione Enter para continuar...");
	    }
	}
	
	private static int lerInteiro(String mensagem) {
		while (true) {
            try {
                System.out.print(mensagem);
                int numero = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                return numero;
            } catch (Exception e) {
                System.out.println("\nPor favor, digite apenas números!");
                scanner.nextLine(); // Limpa o buffer
            }
        }
	}
	
	private static double lerDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                double numero = scanner.nextDouble();
                scanner.nextLine(); // Limpa o buffer
                return numero;
            } catch (Exception e) {
                System.out.println("\nPor favor, digite um valor válido (ex: 29.90)!");
                scanner.nextLine(); // Limpa o buffer
            }
        }
	}
	
	private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }
	

}
