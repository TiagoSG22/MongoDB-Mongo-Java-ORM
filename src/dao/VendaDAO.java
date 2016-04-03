package dao;

import org.bson.types.ObjectId;

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
		return this.dao.readObject(this.VENDA,new ObjectId(objectId),Venda.class);
	}

}
