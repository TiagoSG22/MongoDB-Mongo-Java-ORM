package dao;

import org.bson.types.ObjectId;

import xml.ObjectMapping;

import com.googlecode.mjorm.MongoDao;
import com.googlecode.mjorm.MongoDaoImpl;
import com.googlecode.mjorm.XmlDescriptorObjectMapper;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;

import model.Fornecedor;

public class FornecedorDAO extends DaoBase<Fornecedor>{
	
	private Mongo mongo;
	private XmlDescriptorObjectMapper objectMapper;
	private DB db;
	MongoDao dao;
	
	
	public FornecedorDAO(){
		this.mongo = new Mongo(new MongoURI("mongodb://localhost/"+this.DATABASE));
		this.objectMapper = ObjectMapping.getObjectMapping();
		db = mongo.getDB(this.DATABASE);
		dao = new MongoDaoImpl(db, objectMapper);
	}

	@Override
	public Fornecedor save(Fornecedor fornecedor) {
		return dao.createObject(this.FORNECEDOR, fornecedor);
	}

	@Override
	public void update(Fornecedor fornecedor) {
		dao.updateObject(this.FORNECEDOR, new ObjectId(fornecedor.getId()), fornecedor);
	}

	@Override
	public Fornecedor get(String objectId) {
		return dao.readObject(this.FORNECEDOR,new ObjectId(objectId),Fornecedor.class);
	}

}
