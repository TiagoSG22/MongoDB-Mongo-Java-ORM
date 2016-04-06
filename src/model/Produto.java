package model;

import util.GrupoProduto;
import util.MD5;
import util.ParJson;

public class Produto {
	
	private String id;
	private String nome;
	private String descrição;
	private Fornecedor fornecedorId;
	private GrupoProduto grupoProduto;
	private String hash;
	
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
	public String getHash() {
		return MD5.md5(id+nome+descrição+fornecedorId.getHash()+grupoProduto);
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	@Override
	public String toString(){
		return ParJson.gson.toJson(this);
	}
	
	@Override
	public boolean equals(Object o){
	    if(o == null) return false;
	    if(!(o instanceof Produto)) return false;
	    
	    Produto other = (Produto) o;
	    return this.getHash().equals(other.getHash());
	}
}
