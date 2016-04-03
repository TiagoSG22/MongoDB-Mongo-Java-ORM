package model;

import util.ParJson;

public class NotaFiscal {
	
	private String id;
	private double imposto;
	private String num_NF;
	
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

	@Override
	public String toString(){
		return ParJson.gson.toJson(this);
	}
}
