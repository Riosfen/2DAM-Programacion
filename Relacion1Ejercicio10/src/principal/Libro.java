package principal;

import java.io.Serializable;

public class Libro implements Serializable {
	
	String codigo;
	String titulo;
	String autor;
	int ejemplares;
	
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
	
	public String getAutor() {
		return autor;
	}
	public String getCodigo() {
		return codigo;
	}
	public int getEjemplares() {
		return ejemplares;
	}
	public String getTitulo() {
		return titulo;
	}
	
	public String toString(){
		return codigo+"\t" + titulo+"\t" + autor+"\t" + ejemplares;
	}

}
