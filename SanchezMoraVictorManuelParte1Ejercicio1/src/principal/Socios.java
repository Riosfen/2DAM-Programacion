package principal;

public class Socios {
	
	private int numero;
	private String nombre;
	private int alquiler;

	public Socios(int numero, String nombre){
		this.numero = numero;
		this.nombre = nombre;
	}
	public int getAlquiler() {
		return alquiler;
	}
	public String getNombre() {
		return nombre;
	}
	public int getNumero() {
		return numero;
	}
	
	public void setAlquiler(int alquiler) {
		this.alquiler = alquiler;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return numero + nombre + alquiler;
	}
}
