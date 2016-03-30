package util;

public enum GrupoProduto {
	
	Eletronicos("Eletronico"), Informatica("Informatica"), Telefonia("Telefonia");
	
	private final String nome;
	
	GrupoProduto(String nome){
		this.nome=nome;
	}

	public String getNome() {
		return nome;
	}

}
