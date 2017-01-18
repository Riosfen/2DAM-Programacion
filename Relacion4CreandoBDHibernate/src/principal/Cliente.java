package principal;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@SuppressWarnings("serial")
public class Cliente implements Serializable {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "DNI")
	private String dni;
	@OneToMany(mappedBy="Cliente", cascade=CascadeType.ALL)
	private ArrayList<Compra> compras;
	
	public Cliente (String nombre, String dni){
		
		this.nombre = nombre;
		this.dni = dni;
		
	}
	
	public Cliente(){}
	
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
