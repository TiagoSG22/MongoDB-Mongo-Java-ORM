package dao;

import xml.ObjectMapping;

import com.googlecode.mjorm.MongoDao;
import com.googlecode.mjorm.MongoDaoImpl;
import com.googlecode.mjorm.XmlDescriptorObjectMapper;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;


public abstract class DaoBase<T> {
	
	protected final String FORNECEDOR = "fornecedor";
	protected final String VENDA = "venda";
	protected final String NOTA_FISCAL = "notaFiscal";
	protected final String PESSOA = "pessoa";
	protected final String PRODUTO = "produto";
	protected static final String DATABASE = "test";

	private static XmlDescriptorObjectMapper objectMapper = ObjectMapping.getObjectMapping();
	private static Mongo mongo =new Mongo(new MongoURI("mongodb://localhost/"+DATABASE));
	private static DB db = mongo.getDB(DATABASE);
	protected static final MongoDao dao = new MongoDaoImpl(db, objectMapper);
	

	
	public abstract T save(T obj);
	public abstract void update(T obj);
	public abstract T get(String objectId);
}
