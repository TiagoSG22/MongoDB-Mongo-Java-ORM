package dao;

import model.Pessoa;

import org.bson.types.ObjectId;

public class PessoaDAO extends DaoBase<Pessoa>{
	
	
	public PessoaDAO(){
		super();
	}

	@Override
	public Pessoa save(Pessoa pessoa) {
		return this.dao.createObject(PESSOA, pessoa);
	}

	@Override
	public void update(Pessoa pessoa) {
		this.dao.updateObject(PESSOA, new ObjectId(pessoa.getId()), pessoa);
	}

	@Override
	public Pessoa get(String objectId) {
		return this.dao.readObject(PESSOA,new ObjectId(objectId),Pessoa.class);
	}
	
}
