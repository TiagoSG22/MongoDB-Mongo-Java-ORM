package model;

import util.ParJson;

public class Venda {
	
	private String id;
	private Pessoa pessoaId_cliente;
	private Pessoa pessoaId_funcionario;
	private Produto produtoId;
	private NotaFiscal nota_fiscal;
	private double valor_venda;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Pessoa getPessoaId_cliente() {
		return pessoaId_cliente;
	}
	public void setPessoaId_cliente(Pessoa pessoaId_cliente) {
		this.pessoaId_cliente = pessoaId_cliente;
	}
	public Pessoa getPessoaId_funcionario() {
		return pessoaId_funcionario;
	}
	public void setPessoaId_funcionario(Pessoa pessoaId_funcionario) {
		this.pessoaId_funcionario = pessoaId_funcionario;
	}
	public Produto getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(Produto produtoId) {
		this.produtoId = produtoId;
	}	
	public double getValor_venda() {
		return valor_venda;
	}
	public void setValor_venda(double valor_venda) {
		this.valor_venda = valor_venda;
	}
	public NotaFiscal getNota_fiscal() {
		return nota_fiscal;
	}
	public void setNota_fiscal(NotaFiscal nota_fiscal) {
		this.nota_fiscal = nota_fiscal;
	}
	
	@Override
	public String toString(){
		return ParJson.gson.toJson(this);
	}
}
