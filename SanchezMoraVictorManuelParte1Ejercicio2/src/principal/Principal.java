package principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Principal {

	public static void main(String[] args) {
		try {
			
			File archivo = new File("alumnosRepetidores.txt");
			FileWriter flujo = new FileWriter(archivo);
			PrintWriter filtro = new PrintWriter(flujo);
			
			File ficheroXml=new File("alumnos.xml");
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			DefaultHandler oyente = new Oyente(filtro);
			parser.parse(ficheroXml, oyente);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
