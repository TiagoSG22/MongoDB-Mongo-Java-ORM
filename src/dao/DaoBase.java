package dao;

import xml.ObjectMapping;

import com.googlecode.mjorm.MongoDao;
import com.googlecode.mjorm.MongoDaoImpl;
import com.googlecode.mjorm.XmlDescriptorObjectMapper;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;


public abstract class DaoBase<T> {
	
	protected MongoDao dao;
	
	protected final String FORNECEDOR = "fornecedor";
	protected final String PESSOA = "pessoa";
	protected final String PRODUTO = "produto";
	protected final String DATABASE = "test";

	private static XmlDescriptorObjectMapper objectMapper;
	private static Mongo mongo;
	private static DB db;
	
	DaoBase(){
		mongo = new Mongo(new MongoURI("mongodb://localhost/"+DATABASE));
		db = mongo.getDB(DATABASE);
		objectMapper = ObjectMapping.getObjectMapping();
		dao = new MongoDaoImpl(db, objectMapper);
	}
	
	
	public abstract T save(T obj);
	public abstract void update(T obj);
	public abstract T get(String objectId);

}
