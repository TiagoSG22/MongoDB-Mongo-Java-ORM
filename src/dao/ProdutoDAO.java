package dao;

import org.bson.types.ObjectId;

import model.Produto;

public class ProdutoDAO extends DaoBase<Produto> {

	public ProdutoDAO() {
		super();
	}

	@Override
	public Produto save(Produto produto) {
		return this.dao.createObject(PRODUTO, produto);
	}

	@Override
	public void update(Produto produto) {
		this.dao.updateObject(PRODUTO, new ObjectId(produto.getId()), produto);
	}

	@Override
	public Produto get(String objectId) {
		return this.dao.readObject(PRODUTO,new ObjectId(objectId),Produto.class);
	}

}
