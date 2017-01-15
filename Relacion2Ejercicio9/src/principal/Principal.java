package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Principal {

	public static void main(String[] args) {

		try {
			
			File fichero2 = new File("Empleados.dat");
			
			File fichero = new File("Aumentos.xml");
			SAXParserFactory factoria = SAXParserFactory.newInstance();
			SAXParser parser = factoria.newSAXParser();
			DefaultHandler oyente = new Oyente(fichero2);
			parser.parse(fichero, oyente);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
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
