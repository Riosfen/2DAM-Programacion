package principal;

import java.util.Scanner;

import com.db4o.*;

public class Principal {

	private static final String BD_PERSONAS = "db4o.yap";
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int opc;
		ObjectContainer db;
		
		db=abrirBd();
		do {
			opc = solicitarOpcion();
			tratarOpcion(opc,db);
		} while (opc != 10);
		db.close();
	}

	private static ObjectContainer abrirBd(){
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BD_PERSONAS);
		return db;
	}
	
	private static void tratarOpcion(int opc, ObjectContainer db) {
		int edad,numeroCuenta;
		String dni;
		switch (opc) {
		case 1:
			insertarPersonaEnBd(db);
			break;

		case 2:
			consultarBd(db);
			break;
		case 3:
			edad= solicitarEdad();
			consultarPersonasConEdad(db, edad);
			break;
		case 4:
			dni= solicitarDni();
			modificarPersonasConDni(db, dni);
			break;
		case 5:
			numeroCuenta= solicitarCuenta();
			asociarCuentaAPersona(db, numeroCuenta);
			break;
		case 6:
			edad= solicitarEdad();
			consultarPersonasConEdad(db, edad);
			break;
		case 7:
			edad= solicitarEdad();
			consultarPersonasConEdad(db, edad);
			break;
		case 8:
			edad= solicitarEdad();
			consultarPersonasConEdad(db, edad);
			break;
		case 9:
			edad= solicitarEdad();
			consultarPersonasConEdad(db, edad);
			break;
		}

	}

	private static void asociarCuentaAPersona(ObjectContainer db, int numeroCuenta) {
		Cuenta
		
	}

	private static void modificarPersonasConDni(ObjectContainer db, String dni) {
		Persona persona = new Persona(dni, null, 0);
		
		ObjectSet<Persona> resultado = db.queryByExample(persona);
		
		if (resultado.size() == 0){
			System.out.println("Persona no encontrada");
		}else{
			persona.setNombre(solicitarNombre());
			persona.setEdad(solicitarEdad());
			db.store(persona);
		}
		
	}

	private static int solicitarOpcion() {
		int opc;
		System.out.println("1.Insertar persona en  BD");
		System.out.println("2.Consutar BD completa");
		System.out.println("3.Consultar personas con una edad");
		System.out.println("4.Modificar personas con un dni");
		System.out.println("5.Asociar una cuenta a una persona");
		System.out.println("6.Consultar personas con un dni");
		System.out.println("7.Borrar una persona con un dni");
		System.out.println("8.Consultar las cuentas existentes");
		System.out.println("9.Consultar las personas con cuentas con mas de un determinado saldo");
		System.out.println("10.Salir");
		do {
			System.out.println("Introduce opcion");
			opc = Integer.parseInt(teclado.nextLine());
		} while (opc < 1 || opc > 10);
		return opc;
	}

	private static void consultarBd(ObjectContainer db) {


		Persona per = new Persona(null, null, 0); // consultar todas las personas, sin
											// filtro
		ObjectSet<Persona> result = db.queryByExample(per);

		if (result.size() == 0)
			System.out.println("BD Vacia");
		else {
			System.out.println("Numero de personas" + result.size());
			while (result.hasNext()) {
				per = result.next();
				System.out.println("Persona" + per);
			}
		}

		
	}
	
	private static void consultarPersonasConEdad( ObjectContainer db, int edad) {

		
		Persona per = new Persona(null, null, edad); // consultar todas las personas que tienen esa edad
		
		ObjectSet<Persona> result = db.queryByExample(per);

		if (result.size() == 0)
			System.out.println("BD Vacia");
		else {
			System.out.println("Numero de personas con edad " + edad  + " son: "  + result.size());
			while (result.hasNext()) {
				per = result.next();
				System.out.println( per);
			}
		}

		
	}

	private static void insertarPersonaEnBd(ObjectContainer db) {
		String dni = solicitarDni();
		Persona p = crearPersona(dni);
		
		if (consultarPersonasConDni(db, dni) != null){
			System.out.println("DNI repetido");
		}else{
			db.store(p);
		}
		
	}

	private static Object consultarPersonasConDni(ObjectContainer db, String dni) {
		
		Persona persona = new Persona(dni, null, 0);
		
		ObjectSet<Persona> resultado = db.queryByExample(persona);
		
		if (resultado.size() == 0){
			persona = null;
		}else{
			persona = resultado.next();
		}
		
		return persona;
	}

	private static Persona crearPersona(String dni) {
		Persona p = new Persona(dni, solicitarNombre(), solicitarEdad());
		return p;
	}

	private static int solicitarEdad() {
		int edad;
		do {
			System.out.println("Introduce edad:");
			edad = Integer.parseInt(teclado.nextLine());
		} while (edad < 0);
		return edad;
	}

	private static String solicitarNombre() {
		String nombre;
		System.out.println("Introduce el nombre:");
		nombre = teclado.nextLine();
		return nombre;
	}
	
	private static String solicitarDni() {
		String nombre;
		System.out.println("Introduce el dni:");
		nombre = teclado.nextLine();
		return nombre;
	}
	
	private static int solicitarCuenta() {
		int cuenta;
		System.out.println("Introduce numero de cuenta:");
		cuenta = Integer.valueOf(teclado.nextLine());
		return cuenta;
	}

}
