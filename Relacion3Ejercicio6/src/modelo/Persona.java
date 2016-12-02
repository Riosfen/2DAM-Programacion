package modelo;


public class Persona {
	private String nombre;
	private int edad;
	private String dni;
	private Cuenta miCuenta;
	public Persona(String nombre, int edad, String dni, Cuenta miCuenta) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		this.miCuenta = miCuenta;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Cuenta getMiCuenta() {
		return miCuenta;
	}
	public void setMiCuenta(Cuenta miCuenta) {
		this.miCuenta = miCuenta;
	}
	
}
