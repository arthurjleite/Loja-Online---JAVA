package meu_package;

public class Produto {

	private final int codigo;
	private String nome;
	private String categoria;
    private double preco;
    private int quantidadeEstoque;
    
    
    //Método construtor da classe Produto
    public Produto(int codigo, String nome, String categoria, double preco, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    //Getters para retornar valores solicitados
    public int getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public double getPreco() { return preco; }
    public int getQuantidadeEstoque() { return quantidadeEstoque; }
    
    //Setters para redefinir valores solicitados 
    public void setNome(String nome) { this.nome = nome; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setPreco(double preco) { this.preco = preco; }
    public void setQuantidadeEstoque(int quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }
    
    //Método - Diminuir estoque
    public boolean diminuirEstoque(int quantidade) {
        if (quantidade > 0 && quantidade <= this.quantidadeEstoque) {
            this.quantidadeEstoque -= quantidade;
            return true;
        }
        return false;
    }
    
    //Método - Aumentar estoque
    public void aumentarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidadeEstoque += quantidade;
        }
    }
    
    //Método - Estoque baixo
    public boolean estoqueBaixo(int limite) {
        return this.quantidadeEstoque < limite;
    }
    
    //Método interno .toString() formatado
    @Override
    public String toString() {
        return String.format("Código: %d | Nome: %s | Categoria: %s | Preço: R$ %.2f | Estoque: %d", codigo, nome, categoria, preco, quantidadeEstoque);
    }
    
    //Método equals editado 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Produto produto = (Produto) obj;
        return codigo == produto.codigo;
    }
    
    
}
