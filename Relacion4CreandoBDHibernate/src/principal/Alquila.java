package principal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Alquila")
@SuppressWarnings("serial")
public class Alquila implements Serializable{

	@Id
	@Column(name="ID_ALQUILA")
	private int id;
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name="ID_PELICULA")
	private Pelicula pelicula;
	@Column(name="FECHA_ALQUILADA")
	private Date fechaAlquilada;
	
	public Alquila(Cliente cliente, Pelicula pelicula, Date fechaAlquilada){
		this.cliente = cliente;
		this.pelicula = pelicula;
		this.fechaAlquilada = fechaAlquilada;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public Date getFechaAlquilada() {
		return fechaAlquilada;
	}
	public int getId() {
		return id;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setFechaAlquilada(Date fechaAlquilada) {
		this.fechaAlquilada = fechaAlquilada;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
}
