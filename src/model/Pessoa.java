package model;

import util.MD5;
import util.ParJson;
import util.TipoPessoa;

public class Pessoa {
	
	private String id;
	private String nome;
	private TipoPessoa tipoPessoa;
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
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public String getHash() {
		return MD5.md5(id+nome+tipoPessoa);
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	@Override
	public String toString(){
		return ParJson.gson.toJson(this);
	}
}
