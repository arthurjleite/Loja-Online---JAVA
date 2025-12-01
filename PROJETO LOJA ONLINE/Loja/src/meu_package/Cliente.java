package meu_package;

public class Cliente {
	private final String cpf;
	private String nome;
	
	//Função construtora - Cliente
	public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
	
	//Getters 
	
	public String getCpf() {
        return cpf;
    }
	
	public String getNome() {
        return nome;
    }
	
	//Setters (apenas nome)
	
	public void setNome(String nome) {
        this.nome = nome;
    }
	
	//Método .toString() formatado
	@Override
    public String toString() {
        return String.format("CPF: %s | Nome: %s", cpf, nome);
    }
	
	//Método equals editado
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        return cpf.equals(cliente.cpf);
    }
	
	//Método - resumo cliente
	public String toResumo() {
        return String.format("%s (CPF: %s)", nome, cpf);
    }
	
	

}
