package model;

public class Fornecedor {
	
	private String id;
	private String cpnj;
	private Pessoa pessoaId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCpnj() {
		return cpnj;
	}
	public void setCpnj(String cpnj) {
		this.cpnj = cpnj;
	}
	public Pessoa getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(Pessoa pessoaId) {
		this.pessoaId = pessoaId;
	}
	
	

}
