package principal;


public class Persona {
	private String dni;
	private String nombre;
	private int edad;
	private Cuenta miCuenta;
	public Persona(String dni, String nombre, int edad) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
	}
	@Override
	public String toString() {
		String resul;
		
			if (miCuenta == null){
				resul = "Persona [nombre=" + nombre + ", edad=" + edad + "]";
			}else{
				resul = "Persona [nombre=" + nombre + ", edad=" + edad + "]" + " " + miCuenta;
			}
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Cuenta getMiCuenta() {
		return miCuenta;
	}
	public void setMiCuenta(Cuenta miCuenta) {
		this.miCuenta = miCuenta;
	}
}
