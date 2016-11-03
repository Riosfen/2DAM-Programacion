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

	private static final int TAMANNO_REGISTRO_ALUMNO = 32;
	
	public static void main(String[] args) {
	
		//tratarXML();		
		leerFichero(); // no se transformar el ascii a string
			
	}

	private static void tratarXML() {
		
		try {
			
			File archivoXML = new File("alumnos.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();  
			SAXParser parser;
		
			parser = factory.newSAXParser();

			DefaultHandler oyente = new Oyente();
			parser.parse(archivoXML, oyente);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private static void leerFichero() {
		
		try {
			
			RandomAccessFile file = new RandomAccessFile(new File("alumnos.dat"), "rw");
		
			int id, posicion;
			double media;
			byte[] nombreArray = new byte[20];
			
			posicion = 0;
			
			while (file.getFilePointer() < file.length()) { 
				file.seek(posicion);
				
				id = file.readInt();
				
				file.read(nombreArray);
				String cadenaNombres = new String(nombreArray);
				
				media = file.readDouble();

				System.out.println("ID: " + id + ", Nombre: " + cadenaNombres + ", Media: " + media);
			
				posicion = posicion + TAMANNO_REGISTRO_ALUMNO;
				
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
