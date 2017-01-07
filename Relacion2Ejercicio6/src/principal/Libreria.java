package principal;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement(name = "libreria")
public class Libreria implements Serializable{
	
	private ArrayList<Libro> libros;
	
	public Libreria(){}

	@XmlElementWrapper(name = "libros")
	@XmlElement(name = "libro")
	public ArrayList<Libro> getLibros() {
		return libros;
	}

	
	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

}
