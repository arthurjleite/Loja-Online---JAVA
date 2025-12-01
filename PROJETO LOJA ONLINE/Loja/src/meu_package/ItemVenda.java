package meu_package;

public class ItemVenda {
    private Produto produto;
    private int quantidade;
    private double subtotal;
    
    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        calcularSubtotal();
    }
    
    // Getters
    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
    public double getSubtotal() { return subtotal; }
    
    // Setters
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        calcularSubtotal();
    }
    
    // Método para calcular subtotal
    public void calcularSubtotal() {
        this.subtotal = produto.getPreco() * quantidade;
    }
    
    @Override
    public String toString() {
        return String.format("%s | Quantidade: %d | Preço unitário: R$ %.2f | Subtotal: R$ %.2f",
                produto.getNome(), quantidade, produto.getPreco(), subtotal);
    }
}