package principal;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Oyente extends DefaultHandler {
	
	String elemento = "";
	String aux;
	String nombre;
	int edad = 0;

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		String texto = new String(ch, start, length);
		texto = texto.trim();
		
		if (elemento.equals("nombre")){
			aux = texto;
		}
		if (elemento.equals("edad")){
			
			int edadA = Integer.parseInt(texto);
			
			if (edadA > edad){
				
				edad = edadA;
				nombre = aux;
				
			}
			
		}
			
		super.characters(ch, start, length);
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println(nombre);
		super.endDocument();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		elemento = "";
		
		super.endElement(uri, localName, qName);
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Comienzo del documento xml leido con SAX...");
		super.startDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		elemento = qName;
		
		super.startElement(uri, localName, qName, attributes);
	}

}
