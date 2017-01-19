package principal;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Principal {
	
	public static void main(String[] args) {
		
		AccesoBDSh2 bdH2 = null;
		
		try {
			
			AccesoBDSqlite bdSqlite = new AccesoBDSqlite();
			bdSqlite.crearXML("departamentos.xml", "SELECT * FROM departamentos");
			bdSqlite.cerrarConexion();
			
			bdH2 = new AccesoBDSh2();
			bdH2.ejecutarSentencia("SELECT * FROM departamento");
			PreparedStatement sentencia = bdH2.getConexion().prepareStatement("INSERT INTO departamento VALUES(?,?,?)");
			
			SAXParserFactory factoria = SAXParserFactory.newInstance();
			SAXParser parser = factoria.newSAXParser();
			DefaultHandler oyente = new Oyente(sentencia);
			parser.parse(new File("departamentos.xml"), oyente);
			
			bdH2.cerrarConexion();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				bdH2.getConexion().prepareStatement("CREATE TABLE departamento (codigo INTEGER(11) NOT NULL,nombre VARCHAR(50),localidad VARCHAR(50))").execute();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("ERROR AL CREAR LA TABLA 'departamento'");
				e1.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	
	}
}
