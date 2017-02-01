package principal;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Oyente extends DefaultHandler {

	PreparedStatement sentencia;
	
	public Oyente(PreparedStatement sentencia) {
		// TODO Auto-generated constructor stub
		this.sentencia = sentencia;
	
	}
	
	private int codigo;
	private String nombre, localidad, elemento;

	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		String texto = new String(arg0, arg1, arg2);
		texto = texto.trim();
		
		if (elemento.equals("codigo")){codigo = Integer.parseInt(texto);}
		if (elemento.equals("nombre")){nombre = texto;}
		if (elemento.equals("localidad")){localidad = texto;}
		
	}

	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {

		elemento = arg2;
	}

	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		if (arg2.equals("departamento")){
			try {
				sentencia.setInt(1, codigo);
				sentencia.setString(2, nombre);
				sentencia.setString(3, localidad);
				
				sentencia.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		elemento = "";
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Cargando datos en ");
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}
	
}
