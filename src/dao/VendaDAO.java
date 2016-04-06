package dao;

import org.bson.types.ObjectId;

import model.NotaFiscal;
import model.Pessoa;
import model.Produto;
import model.Venda;

public class VendaDAO extends DaoBase<Venda> {
	
	public VendaDAO(){
		super();
	}

	@Override
	public Venda save(Venda venda) {
		return this.dao.createObject(this.VENDA, venda);
	}

	@Override
	public void update(Venda venda) {
		this.dao.updateObject(this.VENDA, new ObjectId(venda.getId()), venda);
	}

	@Override
	public Venda get(String objectId) {
		Venda venda = this.dao.readObject(this.VENDA,new ObjectId(objectId),Venda.class);
		PessoaDAO pdao = new PessoaDAO();
		Pessoa pc = pdao.get(venda.getPessoaId_cliente().getId()); //Pessoa Cliente
		Pessoa pf = pdao.get(venda.getPessoaId_funcionario().getId()); //Pessoa Funcionario
		Produto p = new ProdutoDAO().get(venda.getProdutoId().getId());
		NotaFiscal nf = new NotaFiscalDAO().get(venda.getNota_fiscal().getId()); 
		
		boolean ok=false;
		
		if(!venda.getPessoaId_cliente().getHash().equals(pc.getHash())){
			venda.setPessoaId_cliente(pc);
			ok=true;
		}
		if(!venda.getPessoaId_funcionario().getHash().equals(pf.getHash())){
			venda.setPessoaId_funcionario(pf);
			ok=true;
		}
		if(!venda.getProdutoId().getHash().equals(p.getHash())){
			venda.setProdutoId(p);
			ok=true;
		}
		if(!venda.getNota_fiscal().getHash().equals(nf.getHash())){
			venda.setNota_fiscal(nf);
			ok=true;
		}
		
		if(ok)
			update(venda);
		
		return venda;
	}
}
