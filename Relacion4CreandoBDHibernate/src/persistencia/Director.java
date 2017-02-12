package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="Director")
@SuppressWarnings("serial")
public class Director implements Serializable {

	@Id
	@Column(name="ID_DIRECTOR")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name = "FECHA_EDICION")
	private Date fechaEdicion;
	@OneToMany(orphanRemoval=false)
	@JoinColumn(name = "ID_PELICULA")
	private ArrayList<Pelicula> peliculas;
	
	public Director(){}
	
	public Director(int id, String nombre, Date fechaEdicion, ArrayList<Pelicula> peliculas){
		this.fechaEdicion = fechaEdicion;
		this.id = id;
		this.nombre = nombre;
		this.peliculas = peliculas;
		
	}
	
	public Date getFechaEdicion() {
		return fechaEdicion;
	}
	public int getId() {
		return id;
	}
	public ArrayList<Pelicula> getPeliculas() {
		return peliculas;
	}
	
	public void setFechaEdicion(Date fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
	} 
	public void setId(int id) {
		this.id = id;
	}
	public void setPeliculas(ArrayList<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	
}
