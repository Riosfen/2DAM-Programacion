import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;

public class Principal {
	private static final String BD_JUEGOS = "juegos.yap";
	private static final int OPCION_SALIR = 4;
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int opc;
		
		cargarDatosIniciales();

		do {
			opc = solicitarOpcion();
			tratarOpcion(opc);
		} while (opc != OPCION_SALIR);

	}

	
	private static int solicitarOpcion() {
		int opc;
		System.out.println("1.Consultar un juego");
		System.out.println("2.Consultar los jugadores inscritos en un juego");
		System.out.println("3.Anular la inscripción a un juego");
		System.out.println("4.Salir");
		
		do {
			System.out.println("Introduce opcion");
			opc = Integer.parseInt(teclado.nextLine());
		} while (opc < 1 || opc > OPCION_SALIR);
		return opc;
	}
	
	private static void tratarOpcion(int opc) {
		
		switch(opc){
		case 1:
			cargarJuego(solicitarCadena("Introduce el nombre del juego: "));
			break;
		case 2:
			jugadoresInscritos(solicitarCadena("Introduce el nombre del juego: "));
			break;
		case 3:
			anularInscripcionJuego(solicitarCadena("Introduce el nombre del jugador: "),
					solicitarCadena("Introduce el nombre del juego: "));
			break;
		}
		
	}

	

	private static void anularInscripcionJuego(String jugador, String juego) {
		ObjectContainer db = abrirBd();
		
		ObjectSet<Jugador> jugadores = jugadoresInscritos(jugador);
		ObjectSet<Juego> juegos = cargarJuego(juego);
	
		if (jugadores.size() != 1 || juegos.size() != 1){
			System.out.println("Error no se puede eliminar esa inscripcion");
		}else{
			
			Jugador jugadorAux = jugadores.next();
			
			HashSet<Juego> listaJuego = jugadorAux.getJuegos();
			HashSet<Juego> listaDefinitiva = new HashSet<Juego>();
			
			for (Iterator iterator = listaJuego.iterator(); iterator.hasNext();) {
				Juego juego2 = (Juego) iterator.next();
				
				if (!juego.equals(juego2)){
					listaDefinitiva.add(juego2);
				}
				
			}
			
			jugadorAux.setJuegos(listaDefinitiva);
			db.store(db);
			
		}
		
		db.close();
	}


	private static ObjectSet<Jugador> jugadoresInscritos(String solicitarCadena) {

		ObjectSet<Juego> juegos = cargarJuego(solicitarCadena);
		
		if (juegos.size() != 1){
			System.out.println("ERROR! No se puede mostrar los jugadores.");
		}

		ObjectContainer db = abrirBd();
		
		Juego juego = (Juego)juegos.next();
		Jugador jugador = new Jugador(null, null);
		HashSet<Juego> listaJuego = new HashSet<Juego>();
		listaJuego.add(juego);
		
		jugador.setJuegos(listaJuego);
		
		ObjectSet<Jugador> listaJugadores = db.queryByExample(juego);
		
		while(listaJugadores.hasNext()){
			System.out.println(listaJugadores.next());
		}
		
		return listaJugadores;
		
	}


	private static ObjectSet<Juego> cargarJuego(String nombreJuego) {
		ObjectContainer db = abrirBd();
		
		Juego juego = new Juego(null, nombreJuego, null);
		
		ObjectSet<Juego> juegos = db.queryByExample(juego);
		
		if (juegos.isEmpty()){
			System.out.println("ERROR! No hay juegos con ese nombre.");
		}else{
			while(juegos.hasNext()){
				System.out.println((Juego)juegos.next());	
			}
		}
		
		db.close();
		
		return juegos;
		
	}


	private static String solicitarCadena( String msg) {
		String cadena;
		System.out.println(msg);
		cadena = teclado.nextLine();
		return cadena;
	}

	private static void cargarDatosIniciales() {
		Jugador j1, j2, j3, j4;
		Juego juego1, juego2, juego3;

		File f = new File(BD_JUEGOS);

		if (!f.exists()) { // si no existe el fichero con la BD lo crea
			System.out.println("Creando BD...");

			ObjectContainer db = abrirBd();

			juego1 = new Juego("MAD", "MAD MAX", "PS4");
			db.store(juego1);
			juego2 = new Juego("FFA", "FINAL FANTASY", "PS4");
			db.store(juego2);
			juego3 = new Juego("CAL", "CALL OF DUTY", "XBOX");
			db.store(juego3);
			db.store(new Juego("FAA", "FINAL FANTASY", "XBOX"));
			db.store(new Juego("BLU", "BLOOD BORNE", "PS4"));

			j1 = new Jugador("11", "Pepe Perez");
			j1.inscribir(juego1);
			j1.inscribir(juego2);
			j1.inscribir(juego3);
			db.store(j1);
			j2 = new Jugador("33", "Frodo Bolson");
			j2.inscribir(juego1);
			j2.inscribir(juego3);
			db.store(j2);
			j3 = new Jugador("44", "Esteban Estevez");

			j3.inscribir(juego2);
			j3.inscribir(juego3);
			db.store(j3);

			j4 = new Jugador("55", "Alvaro Alvarez");
			j4.inscribir(juego3);
			db.store(j4);
			db.close();
		}

	}

	private static ObjectContainer abrirBd() {

		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BD_JUEGOS);

		return db;
	}

}
