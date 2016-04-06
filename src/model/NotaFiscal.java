package model;

import util.MD5;
import util.ParJson;

public class NotaFiscal {
	
	private String id;
	private double imposto;
	private String num_NF;
	private String hash;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getImposto() {
		return imposto;
	}
	public void setImposto(double imposto) {
		this.imposto = imposto;
	}
	public String getNum_NF() {
		return num_NF;
	}
	public void setNum_NF(String num_NF) {
		this.num_NF = num_NF;
	}
	public String getHash() {
		return MD5.md5(id+imposto+num_NF);
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	@Override
	public String toString(){
		return ParJson.gson.toJson(this);
	}
}
