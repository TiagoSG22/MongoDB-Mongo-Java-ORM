package xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;
import com.googlecode.mjorm.XmlDescriptorObjectMapper;

public abstract class ObjectMapping {
	
	public static XmlDescriptorObjectMapper getObjectMapping(){
		
		XmlDescriptorObjectMapper objectMapper = new XmlDescriptorObjectMapper();
		
		try {
			objectMapper.addXmlObjectDescriptor(new File("src/xml/Pessoa.xml"));
			objectMapper.addXmlObjectDescriptor(new File("src/xml/Fornecedor.xml"));
			objectMapper.addXmlObjectDescriptor(new File("src/xml/Produto.xml"));
			objectMapper.addXmlObjectDescriptor(new File("src/xml/NotaFiscal.xml"));
			objectMapper.addXmlObjectDescriptor(new File("src/xml/Venda.xml"));
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		
		return objectMapper;
	}
}
