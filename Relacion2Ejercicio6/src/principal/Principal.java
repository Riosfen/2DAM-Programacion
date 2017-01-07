package principal;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Principal {
	
	public static void main(String[] args) {

		ArrayList<Libro> vLibros = new ArrayList<Libro>();
		
		String[] isbn = {"1111111111", "4444444444", "5555555555", "8888888888"};
		String[] titulo = {"Una hora más", "Al filo del mañana", "Ya sé quién eres", "Esto es programación"};
		String[] autor = {"Autor 1", "Autor 4", "Autor 5", "Autor 8"};
		int[] ejemplares = {5,12,9,35};
		
		Libro l = null;
		
		for (int i = 0; i < ejemplares.length; i++) {

			l = new Libro(isbn[i], titulo[i], autor[i], ejemplares[i]);
			vLibros.add(l);
			
		}
		
		Libreria libreria = new Libreria();
		libreria.setLibros(vLibros);
		
		try {
		
			JAXBContext contexto = JAXBContext.newInstance(Libreria.class);
		
			Marshaller jaxbMarshaller = contexto.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(libreria, new File("libreria.xml"));
		
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}