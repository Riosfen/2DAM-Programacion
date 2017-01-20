import java.util.HashSet;


public class Jugador {
	private String dni;
	private String nombre;
	private HashSet <Juego> juegos;
	
	public Jugador(String dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		juegos=new HashSet<Juego>();
	}
	public HashSet<Juego> getJuegos() {
		return juegos;
	}
	public void setJuegos(HashSet<Juego> juegos) {
		this.juegos = juegos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void inscribir(Juego juego){
		juegos.add(juego);
	}
	@Override
	
	
	public String toString() {
		return "Jugador [dni=" + dni + ", nombre=" + nombre + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	
	
}
