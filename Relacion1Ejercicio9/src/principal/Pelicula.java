package principal;

public class Pelicula {
	
	int codigo;
	String nombre;
	int vecesAlquilado;

	public Pelicula (int codigo ,String nombre, int vecesAlquilado){
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.vecesAlquilado = vecesAlquilado;
		
	}
	
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public int getVecesAlquilado() {
		return vecesAlquilado;
	}
	
	public String toString(){
		return codigo+"\t" + nombre+"\t" + vecesAlquilado;
	}
	
}
