package dao;

import org.bson.types.ObjectId;

import model.Fornecedor;
import model.Pessoa;

public class FornecedorDAO extends DaoBase<Fornecedor>{

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
		Fornecedor fornecedor = this.dao.readObject(this.FORNECEDOR,new ObjectId(objectId),Fornecedor.class);
		return Atualizar(fornecedor);
	}
	
	@Override
	public void delete(String objectId) {
		this.dao.deleteObject(this.FORNECEDOR, new ObjectId(objectId));
	}
	
	@Override
	protected Fornecedor Atualizar(Fornecedor fornecedor){
		Pessoa produto = new PessoaDAO().get(fornecedor.getPessoaId().getId());
		
		if(!fornecedor.getPessoaId().equals(produto)){
			fornecedor.setPessoaId(produto);
			update(fornecedor);
		}
		
		return fornecedor;
	}
}
