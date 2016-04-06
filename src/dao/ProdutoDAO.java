package dao;

import org.bson.types.ObjectId;

import model.Fornecedor;
import model.Produto;

public class ProdutoDAO extends DaoBase<Produto> {

	@Override
	public Produto save(Produto produto) {
		return this.dao.createObject(this.PRODUTO, produto);
	}

	@Override
	public void update(Produto produto) {
		this.dao.updateObject(this.PRODUTO, new ObjectId(produto.getId()), produto);
	}

	@Override
	public Produto get(String objectId) {
		Produto produto = this.dao.readObject(this.PRODUTO,new ObjectId(objectId),Produto.class);
		return Atualizar(produto);
	}
	
	@Override
	public void delete(String objectId) {
		this.dao.deleteObject(this.PRODUTO, new ObjectId(objectId));
	}
	
	@Override
	protected Produto Atualizar(Produto produto){
		Fornecedor f = new FornecedorDAO().get(produto.getFornecedorId().getId());
		
		if(!produto.getFornecedorId().equals(f)){
			produto.setFornecedorId(f);
			update(produto);
		}
		return produto;
	}
}
