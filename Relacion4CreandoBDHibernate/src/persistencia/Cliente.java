package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
@SuppressWarnings("serial")
public class Cliente implements Serializable {

	@Id
	@Column(name = "ID_CLIENTE")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "Direccion")
	private String direccion;
	@Column(name = "FECHA_INSCRIPCION")
	private Date fechaInscripcion;
	@Column(name="EDAD")
	private int edad;
	@OneToMany(mappedBy="ID_PELICULA", cascade=CascadeType.ALL)
	private ArrayList<Pelicula> peliculas;
	
	public Cliente(){};
	public Cliente (String nombre, String direccion, Date fechaInscripcion, int edad, ArrayList<Pelicula> peliculas){
		
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaInscripcion = fechaInscripcion;
		this.edad = edad;
		this.peliculas = peliculas;
		
	}
	
	public String getDireccion() {
		return direccion;
	}
	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}
	public int getEdad() {
		return edad;
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public ArrayList<Pelicula> getPeliculas() {
		return peliculas;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPeliculas(ArrayList<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	
}
