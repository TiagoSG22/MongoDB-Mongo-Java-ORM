package model;

import util.MD5;
import util.ParJson;

public class Venda {
	
	private String id;
	private Pessoa pessoaId_cliente;
	private Pessoa pessoaId_funcionario;
	private Produto produtoId;
	private NotaFiscal nota_fiscal;
	private double valor_venda;
	private String hash;
	
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
	public String getHash() {
		return MD5.md5(id+pessoaId_cliente.getHash()+pessoaId_funcionario.getHash()+produtoId.getHash()+nota_fiscal.getHash()+valor_venda);
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
	    if(!(o instanceof Venda)) return false;
	    
	    Venda other = (Venda) o;
	    return this.getHash().equals(other.getHash());
	}
}
