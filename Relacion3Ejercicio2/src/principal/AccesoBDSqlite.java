package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AccesoBDSqlite {

	private static final String URL_BD = "jdbc:sqlite:bd/ejemplo.db";
	private static final String DRIVER_SQLITE = "org.sqlite.JDBC";
	
	private static Connection conexion;
	
	public AccesoBDSqlite () throws ClassNotFoundException, SQLException{
		
		Class.forName(DRIVER_SQLITE);
		conexion = DriverManager.getConnection(URL_BD);
		
	}
	
	public void crearXML(String nombreXML, String consulta) throws SQLException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException{
		
		Statement sentencia = conexion.createStatement();
		ResultSet resultado = sentencia.executeQuery(consulta);
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();
		
		Element elementoRaiz = doc.createElement("departamentos");
		
		while (resultado.next()){
			int codigo = resultado.getInt(1);
			String nombre = resultado.getString(2);
			String localidad = resultado.getString(3);
			
			Element departamento = doc.createElement("departamento");
			
			Element cod = doc.createElement("codigo");
			cod.setTextContent(String.valueOf(codigo));
			Element nom = doc.createElement("nombre");
			nom.setTextContent(nombre);
			Element loc = doc.createElement("localidad");
			loc.setTextContent(localidad);
			
			departamento.appendChild(cod);
			departamento.appendChild(nom);
			departamento.appendChild(loc);
			
			elementoRaiz.appendChild(departamento);
		}
			
			doc.appendChild(elementoRaiz);
			
			Source source = new DOMSource(doc);
			Result result = new StreamResult("nombreXML");
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);
	
	}
	
	public void cerrarConexion() throws SQLException{conexion.close();}
	
}
