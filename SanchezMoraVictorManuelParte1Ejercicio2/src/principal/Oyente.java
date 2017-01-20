package principal;

import java.io.PrintWriter;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Oyente extends DefaultHandler {

	private PrintWriter filtro;
	
	public Oyente(PrintWriter filtro) {
		this.filtro = filtro;
		// TODO Auto-generated constructor stub
	}
	
	String elemento,nombre,dni;
	int pendientes;
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String texto = new String(ch, start, length);
		texto = texto.trim();
		
		if (elemento.equals("dni")){
			dni = texto;
		}
		if (elemento.equals("nombre")){
			nombre = texto;
		}
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("alumno")){
			filtro.write(dni);
			filtro.
		}
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		elemento = qName;
		if (qName.equals("alumno")){
			pendientes = Integer.parseInt(attributes.getValue(0));
		}
	}

}
