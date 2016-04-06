package dao;

import model.NotaFiscal;

import org.bson.types.ObjectId;

public class NotaFiscalDAO extends DaoBase<NotaFiscal>{

	@Override
	public NotaFiscal save(NotaFiscal nf) {
		return this.dao.createObject(this.NOTA_FISCAL, nf);
	}

	@Override
	public void update(NotaFiscal nf) {
		this.dao.updateObject(this.NOTA_FISCAL, new ObjectId(nf.getId()), nf);
	}

	@Override
	public NotaFiscal get(String objectId) {
		return this.dao.readObject(this.NOTA_FISCAL,new ObjectId(objectId),NotaFiscal.class);
	}
	
	@Override
	public void delete(String objectId) {
		this.dao.deleteObject(this.NOTA_FISCAL, new ObjectId(objectId));
	}
	
	@Override
	protected NotaFiscal Atualizar(NotaFiscal nf){
		return null; //Não se Aplica
	}
}
