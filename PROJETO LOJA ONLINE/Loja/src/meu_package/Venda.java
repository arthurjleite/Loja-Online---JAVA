package meu_package;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    private static int contadorVendas = 1;
    
    private final int numeroVenda;
    private final LocalDateTime dataHora;
    private Cliente cliente;
    private List<ItemVenda> itens;
    private double valorTotal;
    private String status;
    
    public Venda(Cliente cliente) {
        this.numeroVenda = contadorVendas++;
        this.dataHora = LocalDateTime.now();
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
        this.status = "Pendente";
    }
    
    // Getters
    public int getNumeroVenda() { return numeroVenda; }
    public LocalDateTime getDataHora() { return dataHora; }
    public Cliente getCliente() { return cliente; }
    public List<ItemVenda> getItens() { return itens; }
    public double getValorTotal() { return valorTotal; }
    public String getStatus() { return status; }
    
    // Método para adicionar item à venda
    public boolean adicionarItem(Produto produto, int quantidade) {
        if (produto == null || quantidade <= 0) {
            return false;
        }
        
        if (produto.getQuantidadeEstoque() < quantidade) {
            System.out.println("\nEstoque insuficiente! Disponível: " + produto.getQuantidadeEstoque());
            return false;
        }
        
        for (ItemVenda item : itens) {
            if (item.getProduto().equals(produto)) {
                int novaQuantidade = item.getQuantidade() + quantidade;
                if (produto.getQuantidadeEstoque() < novaQuantidade) {
                    System.out.println("\nEstoque insuficiente! Disponível: " + produto.getQuantidadeEstoque());
                    return false;
                }
                item.setQuantidade(novaQuantidade);
                item.calcularSubtotal();
                calcularTotal();
                return true;
            }
        }
        
        ItemVenda novoItem = new ItemVenda(produto, quantidade);
        itens.add(novoItem);
        calcularTotal();
        return true;
    }
    
    // Método para remover item da venda
    public boolean removerItem(int codigoProduto) {
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getProduto().getCodigo() == codigoProduto) {
                itens.remove(i);
                calcularTotal();
                return true;
            }
        }
        return false;
    }
    
    // Método para calcular o total da venda
    private void calcularTotal() {
        this.valorTotal = 0;
        for (ItemVenda item : itens) {
            this.valorTotal += item.getSubtotal();
        }
    }
    
    // Método para finalizar a venda
    public boolean finalizarVenda() {
        if (itens.isEmpty()) {
            System.out.println("\nNão é possível finalizar venda sem itens!");
            return false;
        }
        
        for (ItemVenda item : itens) {
            Produto produto = item.getProduto();
            if (!produto.diminuirEstoque(item.getQuantidade())) {
                System.out.println("\nErro ao atualizar estoque do produto: " + produto.getNome());
                return false;
            }
        }
        
        this.status = "Concluída";
        return true;
    }
    
    // Método para cancelar a venda
    public void cancelarVenda() {
        this.status = "Cancelada";
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return String.format("Venda #%d | Data: %s | Cliente: %s | Total: R$ %.2f | Status: %s",
                numeroVenda, dataHora.format(formatter), 
                cliente != null ? cliente.getNome() : "Não informado", 
                valorTotal, status);
    }
    
    // Método para exibir detalhes completos da venda
    public String exibirDetalhes() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        StringBuilder detalhes = new StringBuilder();
        
        detalhes.append("\n=== DETALHES DA VENDA ===\n");
        detalhes.append("Número: ").append(numeroVenda).append("\n");
        detalhes.append("Data/Hora: ").append(dataHora.format(formatter)).append("\n");
        detalhes.append("Cliente: ").append(cliente != null ? cliente.toResumo() : "Não informado").append("\n");
        detalhes.append("Status: ").append(status).append("\n");
        detalhes.append("Itens:\n\n");
        
        for (int i = 0; i < itens.size(); i++) {
            detalhes.append("  ").append(i + 1).append(". ").append(itens.get(i)).append("\n");
        }
        
        detalhes.append(String.format("\nTotal: R$ %.2f", valorTotal));
        return detalhes.toString();
    }
}