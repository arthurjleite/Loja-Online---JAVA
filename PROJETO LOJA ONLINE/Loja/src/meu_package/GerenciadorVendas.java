package meu_package;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorVendas {
    private List<Venda> vendas;
    private Venda vendaAtual;
    
    public GerenciadorVendas() {
        this.vendas = new ArrayList<>();
        this.vendaAtual = null;
    }
    
    // Método para iniciar nova venda
    public boolean iniciarNovaVenda(Cliente cliente) {
        if (vendaAtual != null && !vendaAtual.getStatus().equals("Concluída")) {
            System.out.println("\nJá existe uma venda em andamento!");
            return false;
        }
        
        vendaAtual = new Venda(cliente);
        Util.limparConsole();
        System.out.println("\nNova venda iniciada! Número: " + vendaAtual.getNumeroVenda());
        return true;
    }
    
    // Método para adicionar item à venda atual
    public boolean adicionarItemVenda(int codigoProduto, int quantidade, GerenciadorProdutos gerenciadorProdutos) {
        if (vendaAtual == null) {
            System.out.println("\nNenhuma venda em andamento! Inicie uma nova venda primeiro.");
            return false;
        }
        
        Produto produto = gerenciadorProdutos.buscarPorCodigo(codigoProduto);
        if (produto == null) {
        	Util.limparConsole();
            System.out.println("\nProduto não encontrado!\n");
            return false;
        }
        
        boolean sucesso = vendaAtual.adicionarItem(produto, quantidade);
        if (sucesso) {
        	Util.limparConsole();
            System.out.println("\nItem adicionado com sucesso!\n");
            System.out.println("Total atual: R$ " + vendaAtual.getValorTotal());
        }
        return sucesso;
    }
    
    // Método para remover item da venda atual
    public boolean removerItemVenda(int codigoProduto) {
        if (vendaAtual == null) {
            System.out.println("\nNenhuma venda em andamento!");
            return false;
        }
        
        boolean sucesso = vendaAtual.removerItem(codigoProduto);
        if (sucesso) {
            System.out.println("\nItem removido com sucesso!");
            System.out.println("Total atual: R$ " + vendaAtual.getValorTotal());
        } else {
            System.out.println("\nItem não encontrado na venda!");
        }
        return sucesso;
    }
    
    // Método para finalizar venda atual
    public boolean finalizarVendaAtual() {
        if (vendaAtual == null) {
            System.out.println("\nNenhuma venda em andamento!");
            return false;
        }
        
        boolean sucesso = vendaAtual.finalizarVenda();
        if (sucesso) {
        	Util.limparConsole();
            System.out.println("\nVenda finalizada com sucesso!");
            System.out.println(vendaAtual.exibirDetalhes());
            vendas.add(vendaAtual);
            vendaAtual = null;
        }
        return sucesso;
    }
    
    // Método para cancelar venda atual
    public void cancelarVendaAtual() {
        if (vendaAtual != null) {
            vendaAtual.cancelarVenda();
            System.out.println("\nVenda cancelada!");
            vendaAtual = null;
        } else {
            System.out.println("\nNenhuma venda em andamento!");
        }
    }
    
    // Método para exibir venda atual
    public void exibirVendaAtual() {
        if (vendaAtual == null) {
            System.out.println("\nNenhuma venda em andamento!");
            return;
        }
        
        System.out.println(vendaAtual.exibirDetalhes());
    }
    
    // Método para listar todas as vendas
    public void listarVendas() {
        if (vendas.isEmpty()) {
            System.out.println("\nNenhuma venda registrada no sistema!");
            return;
        }
        
        System.out.println("\n=== LISTA DE VENDAS ===\n");
        System.out.println("Total de vendas: " + vendas.size());
        System.out.println("---------------------------");
        
        for (int i = 0; i < vendas.size(); i++) {
            System.out.println((i + 1) + ". " + vendas.get(i));
        }
    }
    
    // Método para buscar venda por número
    public Venda buscarVendaPorNumero(int numeroVenda) {
        for (Venda venda : vendas) {
            if (venda.getNumeroVenda() == numeroVenda) {
                return venda;
            }
        }
        return null;
    }
    
    // Método para exibir relatório de vendas
    public void exibirRelatorioVendas() {
        if (vendas.isEmpty()) {
            System.out.println("\nNenhuma venda registrada no sistema!");
            return;
        }
        
        double totalGeral = 0;
        int totalItensVendidos = 0;
        
        System.out.println("\n=== RELATÓRIO DE VENDAS ===\n");
        
        for (Venda venda : vendas) {
            if (venda.getStatus().equals("Concluída")) {
                totalGeral += venda.getValorTotal();
                totalItensVendidos += venda.getItens().stream()
                    .mapToInt(ItemVenda::getQuantidade)
                    .sum();
            }
        }
        
        System.out.println("Total de vendas realizadas: " + vendas.size());
        System.out.println("Total geral em vendas: R$ " + String.format("%.2f", totalGeral));
        System.out.println("Total de itens vendidos: " + totalItensVendidos);
        System.out.println("Valor médio por venda: R$ " + 
            String.format("%.2f", vendas.isEmpty() ? 0 : totalGeral / vendas.size()));
    }
    
    // Getters
    public boolean temVendaEmAndamento() {
        return vendaAtual != null;
    }
    
    public Venda getVendaAtual() {
        return vendaAtual;
    }
    
    public List<Venda> getTodasVendas() {
        return new ArrayList<>(vendas);
    }
}