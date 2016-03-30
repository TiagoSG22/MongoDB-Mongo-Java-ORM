package util;

public enum TipoPessoa {
	
	Cliente("Cliente"), Funcionario("Funcionario"), Fornecedor("Fornecedor");
	
	private final String nome;
	
	TipoPessoa(String nome){
		this.nome=nome;
	}

	public String getNome() {
		return nome;
	}
}
