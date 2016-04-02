package model;

import util.GrupoProduto;
import util.ParJson;

public class Produto {
	
	private String id;
	private String nome;
	private String descrição;
	private Fornecedor fornecedorId;
	private GrupoProduto grupoProduto;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	public Fornecedor getFornecedorId() {
		return fornecedorId;
	}
	public void setFornecedorId(Fornecedor fornecedorId) {
		this.fornecedorId = fornecedorId;
	}
	public GrupoProduto getGrupoProduto() {
		return grupoProduto;
	}
	public void setGrupoProduto(GrupoProduto grupoProduto) {
		this.grupoProduto = grupoProduto;
	}
	
	@Override
	public String toString(){
		return ParJson.gson.toJson(this);
	}
}
