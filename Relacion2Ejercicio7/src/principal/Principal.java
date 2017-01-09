package principal;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		try {
			
			System.out.println("Introduce el ISBN a borrar: ");
			String borrarIsbn = teclado.nextLine();
		
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factoria.newDocumentBuilder();
			Document doc = builder.parse(new File("LibrosMonroy.xml"));
		
			Node raiz = doc.getDocumentElement();
			NodeList listaNodos = doc.getElementsByTagName("libro");
			
			boolean borrado = false;
			int contador = 0;
			
			while (contador < listaNodos.getLength() && !borrado){
				
				Node libro = listaNodos.item(contador);
				
				if (libro.getNodeType() == Node.ELEMENT_NODE){
					
					Element elemento = (Element) libro;
					String nodoIsbn = elemento.getAttribute("ISBN");
					
					if (nodoIsbn.equals(borrarIsbn)){
						
						System.out.println("Se ha borrado el libro con ISBN: " + nodoIsbn);
						
						raiz.removeChild(elemento);
						borrado = true;
						
					}
					
				}
				
				contador++;
				
			}
			
			if (borrado){
				
				Source source = new DOMSource(doc);
				Result result = new StreamResult("librosMonroy-test.xml");
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.transform(source, result);
				
			}else {
				System.out.println("No se encontró el libro con ISBN: " + borrarIsbn);
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
		}
		
	}

}
