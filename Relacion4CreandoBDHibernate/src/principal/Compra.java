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
@Table
@SuppressWarnings("serial")
public class Compra implements Serializable{

	@Id
	@Column(name="ID")
	private int id;
	@ManyToOne
	@JoinColumn(name="IDARTICULO")
	private Articulo idArticulo;
	@ManyToOne
	@JoinColumn(name="IDCLIENTE")
	private Cliente idCliente;
	@Column(name="FECHA")
	private Date fecha;
	
	public Compra(Date fecha){
		this.fecha = fecha;
	}
	
	public Compra(){}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
