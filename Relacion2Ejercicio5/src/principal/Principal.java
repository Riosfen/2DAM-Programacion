package principal;


import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

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

public class Principal {

	public static void main(String[] args) {

		try {
			
			File fichero = new File("LibrosMonroy.dat");
			FileInputStream flujo = new FileInputStream(fichero);
			ObjectInputStream filtro = new ObjectInputStream(flujo);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			
			Element elementoRaiz = doc.createElement("libros");
			
			Libro l;
			boolean terminado = false;
			
			while (!terminado){
				try {
					
					l = (Libro) filtro.readObject();
					
					Element etiquetaIsbn = doc.createElement("libro");
					etiquetaIsbn.setAttribute("ISBN", l.getCodigo().trim());
					
					Element etiquetaAutor = doc.createElement("autor");
					etiquetaAutor.setTextContent(l.getAutor().trim());
					
					Element etiquetaTitulo = doc.createElement("titulo");
					etiquetaTitulo.setTextContent(l.getTitulo().trim());
					
					Element etiquetaEjemplares = doc.createElement("ejemplares");
					etiquetaEjemplares.setTextContent(String.valueOf(l.getEjemplares()));

					etiquetaIsbn.appendChild(etiquetaAutor);
					etiquetaIsbn.appendChild(etiquetaTitulo);
					etiquetaIsbn.appendChild(etiquetaEjemplares);
					elementoRaiz.appendChild(etiquetaIsbn);
					
				} catch (EOFException e) {
					terminado = true;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			filtro.close();
			flujo.close();

			doc.appendChild(elementoRaiz);
			
			Source source = new DOMSource(doc);
			Result result = new StreamResult("librosMonroy.xml");
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			// formatear xml
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			// fin de formateo
			transformer.transform(source, result);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
