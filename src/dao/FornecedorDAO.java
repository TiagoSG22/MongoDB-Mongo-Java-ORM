package dao;

import org.bson.types.ObjectId;

import model.Fornecedor;

public class FornecedorDAO extends DaoBase<Fornecedor>{
	
	public FornecedorDAO(){
		super();
	}

	@Override
	public Fornecedor save(Fornecedor fornecedor) {
		return this.dao.createObject(this.FORNECEDOR, fornecedor);
	}

	@Override
	public void update(Fornecedor fornecedor) {
		this.dao.updateObject(this.FORNECEDOR, new ObjectId(fornecedor.getId()), fornecedor);
	}

	@Override
	public Fornecedor get(String objectId) {
		return this.dao.readObject(this.FORNECEDOR,new ObjectId(objectId),Fornecedor.class);
	}

}
