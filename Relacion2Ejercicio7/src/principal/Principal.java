package principal;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Principal {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Node raiz, n;
		Element ele;

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document arbol = builder.parse(new File("librosMonroy.xml"));

			raiz = arbol.getFirstChild();
			NodeList listaNodos = raiz.getChildNodes();
			
			System.out.println("Lista de Libros:\n");

			for (int i = 0; i < listaNodos.getLength(); i++) {
				n = listaNodos.item(i);
				if (n.getNodeType() == Node.ELEMENT_NODE && n.getNodeName().equals("libro")) {

					ele = (Element) n;

					// Mostrar el nodo
					System.out.println("ISBN:" + getNodo("isbn", ele) + " Titulo:" + getNodo("titulo", ele));
					
				}
			}
			
			System.out.println("\nIndica el ISBN del libro que quieras borrar: ");
			String opcion = teclado.nextLine();
			
			for (int i = 0; i < listaNodos.getLength(); i++) {
				n = listaNodos.item(i);
				
				if (n.getNodeName().equals("libro")){
				ele = (Element) n;

				// Añado un nuevo atributo tipo con valor "S" a todos los
					
					if (ele.getFirstChild().getTextContent().equals(opcion)){

						raiz.removeChild(n);
						
					}
				}
			}

			// Pasar el arbol dom a un fichero xml llamado librosMonroy.xml

			Source source = new DOMSource(arbol);
			Result result = new StreamResult("librosMonroy_test.xml");
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			// formatear xml
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			// fin de formateo
			transformer.transform(source, result);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static String getNodo(String etiqueta, Element ele) throws Exception {

		NodeList listaDeHijosDeEtiqueta = ele.getElementsByTagName(etiqueta); 
		if (listaDeHijosDeEtiqueta.getLength() == 0)
			throw new Exception("No existe el elemento con etiqueta " + etiqueta);

		Node nodo = listaDeHijosDeEtiqueta.item(0).getFirstChild(); 

		return nodo.getNodeValue(); 
	}

}
