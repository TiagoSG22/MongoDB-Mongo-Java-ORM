package dao;

import org.bson.types.ObjectId;

import model.Fornecedor;
import model.Pessoa;

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
		Fornecedor f = this.dao.readObject(this.FORNECEDOR,new ObjectId(objectId),Fornecedor.class);
		Pessoa p = new PessoaDAO().get(f.getPessoaId().getId());
		
		if(!f.getPessoaId().getHash().equals(p.getHash())){
			f.setPessoaId(p);
			update(f);
		}
		
		return f;
	}
}
