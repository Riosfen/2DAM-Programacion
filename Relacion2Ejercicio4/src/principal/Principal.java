package principal;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Principal {

	public static void main(String[] args) {

		try {
			
		File ficheroXML = new File("personas.xml");
		SAXParserFactory factoria = SAXParserFactory.newInstance();
		SAXParser parser = factoria.newSAXParser();
		DefaultHandler oyente = new Oyente();
		
		parser.parse(ficheroXML, oyente);
		
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
