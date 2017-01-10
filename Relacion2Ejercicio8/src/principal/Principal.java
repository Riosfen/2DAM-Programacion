package principal;

import java.io.File;
import java.io.IOException;
import java.util.Random;
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
		
		boolean aniadirAtributo = false;
		
		try {
		
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File("LibrosMonroy.xml"));
		
			Node raiz = doc.getDocumentElement();
			NodeList listaElementos = doc.getElementsByTagName("titulo");

			for (int i = 0; i < listaElementos.getLength(); i++) {
				
				Node nodo = (Node) listaElementos.item(i);
				
				if (nodo.getNodeType() == Node.ELEMENT_NODE){
					
					Element elementTitulo = (Element) nodo;
					String titulo = elementTitulo.getNodeName();
					
					if (titulo.equals("titulo")){
						
						elementTitulo.setAttribute("numero_paginas", String.valueOf(new Random().nextInt(200) + 150));
						aniadirAtributo = true;
						
					}
					
				}
				
			}
			
			if (aniadirAtributo){
				
				Source source = new DOMSource(doc);
				Result result = new StreamResult("librosMonroyNuevo.xml");
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.transform(source, result);
				
				System.out.println("Archivo creado");
				
			}else{
				System.out.println("No se ha podido crear el xml con el nuevo atributo");
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
