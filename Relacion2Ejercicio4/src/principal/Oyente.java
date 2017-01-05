package principal;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Oyente extends DefaultHandler {

	String elemento;
	String sexo;
	int contadorH;
	int edadH;
	int contadorM;
	int edadM;
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		String texto = new String(ch, start, length);
		texto = texto.trim();
		
		if (elemento.equals("edad")){
			if (sexo.equals("H")){
				edadH += Integer.parseInt(texto);
				contadorH++;
			}
			if (sexo.equalsIgnoreCase("M")){
				edadM += Integer.parseInt(texto);
				contadorM++;
			}
		}
		
		super.characters(ch, start, length);
	}

	@Override
	public void endDocument() throws SAXException {

		System.out.println("La media de edades de los hombres es: " + (float)edadH/contadorH);
		System.out.println("La media de edades de las mujeres es: " + (float)edadM/contadorM);
		
		super.endDocument();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (qName.equals("persona")){
			sexo = "";
		}
		
		elemento = "";
		
		super.endElement(uri, localName, qName);
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		elemento = qName;
		
		if (elemento.equals("persona")){
			sexo = attributes.getValue(0);
		}
		
		super.startElement(uri, localName, qName, attributes);
	}

}
