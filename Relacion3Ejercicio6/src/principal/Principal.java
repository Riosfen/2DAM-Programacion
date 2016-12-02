package principal;

import java.util.Scanner;
import com.db4o.*;

import modelo.Persona;

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
		} while (opc != 4);
		db.close();
	}

	private static ObjectContainer abrirBd(){
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BD_PERSONAS);
		return db;
	}
	
	private static void tratarOpcion(int opc, ObjectContainer db) {
		int edad;
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
			modificarPersonaConDni(db, dni);
			break;
		}

	}

	private static void modificarPersonaConDni(ObjectContainer db, String dni) {
boolean hayPersonas = false;
		
		Persona per = new Persona(null, 0, dni, null); // consultar todas las personas que tienen ese dni
		
		ObjectSet<Persona> result = db.queryByExample(per);
		
		menuEditarPersona(per);
		
	}

	private static void menuEditarPersona(Persona per) {

		int opc;
		
		do {
			opc = solicitarOpcionEditar();
			tratarOpcionEditar(opc, per);
		} while (opc != 3);
		
	}

	private static void tratarOpcionEditar(int opc, Persona per) {
		int edad;
		String dni;
		switch (opc) {
		case 1:
			per.setNombre(solicitarNombre());
			break;

		case 2:
			per.setEdad(solicitarEdad());
			break;
		}
		
	}

	private static int solicitarOpcionEditar() {
		int opc;
		System.out.println("1.Editar Nombre");
		System.out.println("2.Editar Edad");
		do {
			System.out.println("Introduce opcion");
			opc = Integer.parseInt(teclado.nextLine());
		} while (opc < 1 || opc > 2);
		return opc;
	
	}

	private static int solicitarOpcion() {
		int opc;
		System.out.println("1.Insertar persona en  BD");
		System.out.println("2.Consutar BD completa");
		System.out.println("3.Consultar personas con una edad");
		System.out.println("4.Salir");
		do {
			System.out.println("Introduce opcion");
			opc = Integer.parseInt(teclado.nextLine());
		} while (opc < 1 || opc > 5);
		return opc;
	}

	private static void consultarBd(ObjectContainer db) {


		Persona per = new Persona(null, 0, null, null); // consultar todas las personas, sin
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

		
		Persona per = new Persona(null, edad, null, null); // consultar todas las personas que tienen esa edad
		
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
	
	private static boolean comprobarPersonasConDni( ObjectContainer db, String dni) {

		boolean hayPersonas = false;
		
		Persona per = new Persona(null, 0, dni, null); // consultar todas las personas que tienen ese dni
		
		ObjectSet<Persona> result = db.queryByExample(per);

		if (result.size() != 0)
			hayPersonas = true;

		return hayPersonas;
		
	}

	private static void insertarPersonaEnBd(ObjectContainer db) {

		Persona p = crearPersona();
		
		if (!comprobarPersonasConDni(db, p.getDni())){

			db.store(p);
			
		}
		
	}

	private static Persona crearPersona() {
		Persona p = new Persona(solicitarNombre(), solicitarEdad(), solicitarDni());
		return p;
	}

	private static String solicitarDni() {
		String dni;
		System.out.println("Introduce el dni:");
		dni = teclado.nextLine();
		return dni;
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

}
