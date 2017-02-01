package principal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Pelicula")
@SuppressWarnings("serial")
public class Pelicula implements Serializable {
	
	@Id
	@Column(name = "ID_PELICULA")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Enumerated(EnumType.ORDINAL)
	private TipoPelicula tipoPelicula;
	@Column(name = "FECHA_EDICION")
	private Date fechaEdicion;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@ManyToOne
	@JoinColumn(name = "ID_DIRECTOR")
	private Director director;
	
	public Pelicula(){}
	
	public Pelicula(String nombre, TipoPelicula tipoPelicula, Date fechaEdicion, String descripcion, Director director){
		
		this.nombre = nombre;
		this.tipoPelicula = tipoPelicula;
		this.fechaEdicion = fechaEdicion;
		this.descripcion = descripcion;
		this.director = director;
		
	}
	
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public Director getDirector() {
		return director;
	}
	public Date getFechaEdicion() {
		return fechaEdicion;
	}
	public TipoPelicula getTipoPelicula() {
		return tipoPelicula;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	public void setFechaEdicion(Date fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTipoPelicula(TipoPelicula tipoPelicula) {
		this.tipoPelicula = tipoPelicula;
	}
	
}
