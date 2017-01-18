package principal;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Articulo")
@SuppressWarnings("serial")
public class Articulo implements Serializable {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "PRECIO")
	private int precio;
	@OneToMany(mappedBy="Articulo", cascade=CascadeType)
	@Cascade()
	private ArrayList<Compra> compras;
	
	public Articulo(){}
	
	public Articulo(String nombre, int precio){
		
		this.nombre = nombre;
		this.precio = precio;
		
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
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
}
