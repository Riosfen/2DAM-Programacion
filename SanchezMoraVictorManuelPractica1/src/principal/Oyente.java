package principal;

import java.io.IOException;
import java.net.ContentHandler;
import java.net.URLConnection;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Oyente extends DefaultHandler {

	private String nombreEle;
	private int numAlumno;
	private int sumaNota;
	private int media;
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		String cadena= new String(ch, start, length);
		cadena = cadena.replaceAll("[\t\n ]", "");
		
		if (!cadena.equals("")){
			
			
			
		}
	
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		
		
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		System.out.println("Elemento: " + qName);
		
		if (attributes != null) {
			for(int i=0; i < attributes.getLength(); i++) {
				if (attributes.getQName(i).equals("numero")){
					numAlumno = Integer.parseInt(attributes.getValue(i));
				}
			}
		}
		
	}

	

}
