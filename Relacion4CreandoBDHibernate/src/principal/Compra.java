package principal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@SuppressWarnings("serial")
public class Compra implements Serializable{

	@Column(name="IDARTICULO")
	private int idArticulo;
	@Column(name="IDCLIENTE")
	private int idCliente;
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
