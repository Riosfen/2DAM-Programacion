package principal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARTICULO")
@SuppressWarnings("serial")
public class Articulo implements Serializable {
	
	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@Column(name = "PRECIO")
	private int precio;
	@Column(name = "CANTIDAD")
	private int cantidad;
	@Column(name = "FOTO")
	private String foto;
	@Column(name = "IDSUBFAMILIA") //TODO falta la clave referencial
	private int subFamilia;
	
	public Articulo(){}
	
	public Articulo(int id, String nombre, String descripcion, int precio, int cantidad, String foto, int subfamilia){
		
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.foto = foto;
		this.subFamilia = subfamilia;
		
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getFoto() {
		return foto;
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public int getSubFamilia() {
		return subFamilia;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setSubFamilia(int subFamilia) {
		this.subFamilia = subFamilia;
	}
	
}
