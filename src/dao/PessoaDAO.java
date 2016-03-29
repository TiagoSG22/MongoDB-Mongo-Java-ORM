package dao;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import model.Pessoa;

import org.bson.types.ObjectId;
import org.xml.sax.SAXException;

import xml.ObjectMapping;

import com.googlecode.mjorm.MongoDao;
import com.googlecode.mjorm.MongoDaoImpl;
import com.googlecode.mjorm.XmlDescriptorObjectMapper;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;


public class PessoaDAO extends DaoBase<Pessoa>{
	
	private Mongo mongo;
	private XmlDescriptorObjectMapper objectMapper;
	private DB db;
	MongoDao dao;
	
	public PessoaDAO(){
		this.mongo = new Mongo(new MongoURI("mongodb://localhost/"+DATABASE));
		
		this.objectMapper = ObjectMapping.getObjectMapping();
		
		db = mongo.getDB(DATABASE);
		dao = new MongoDaoImpl(db, objectMapper);
	}

	@Override
	public Pessoa save(Pessoa pessoa) {
		return dao.createObject(PESSOA, pessoa);
	}

	@Override
	public void update(Pessoa pessoa) {
		dao.updateObject(PESSOA, new ObjectId(pessoa.getId()), pessoa);
	}

	@Override
	public Pessoa get(String objectId) {
		return dao.readObject(PESSOA,new ObjectId(objectId),Pessoa.class);
	}
	
}
