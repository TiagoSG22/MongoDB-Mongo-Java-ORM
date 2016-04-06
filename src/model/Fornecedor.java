package model;

import util.MD5;
import util.ParJson;

public class Fornecedor {
	
	private String id;
	private String cpnj;
	private Pessoa pessoaId;
	private String hash;
	
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
	public String getHash() {
		return MD5.md5(id+cpnj+pessoaId.getHash());
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
	    if(!(o instanceof Fornecedor)) return false;
	    
	    Fornecedor other = (Fornecedor) o;
	    return this.getHash().equals(other.getHash());
	}
}
