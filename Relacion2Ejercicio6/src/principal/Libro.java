package principal;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement(name = "libro")
@XmlType(propOrder = {"codigo", "autor", "titulo", "ejemplares"})
public class Libro implements Serializable {
	
	private String codigo;
	private String titulo;
	private String autor;
	private int ejemplares;
	
	public Libro (){}
	
	public Libro (String codigo, String titulo, String autor, int ejemplares){
		
		setCodigo(codigo);
		setTitulo(titulo);
		setAutor(autor);
		setEjemplares(ejemplares);
		
	}
	
	public void fusionarLibros(Libro otro){
		
		this.ejemplares += otro.getEjemplares();
		
	}
	
	public void setAutor(String autor) {
		this.autor = String.format("%1$-30s", autor);
	}
	public void setCodigo(String codigo) {
		this.codigo = String.format("%1$-10s", codigo);
	}
	public void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}
	public void setTitulo(String titulo) {
		this.titulo = String.format("%1$-30s", titulo);
	}

	
	@XmlElement(name = "autor")
	public String getAutor() {
		return autor;
	}
	
	@XmlElement(name = "ISBN")
	public String getCodigo() {
		return codigo;
	}

	@XmlElement(name = "ejemplares")
	public int getEjemplares() {
		return ejemplares;
	}

	@XmlElement(name = "titulo")
	public String getTitulo() {
		return titulo;
	}
	
	public String toString(){
		return codigo+"\t" + titulo+"\t" + autor+"\t" + ejemplares;
	}

}
