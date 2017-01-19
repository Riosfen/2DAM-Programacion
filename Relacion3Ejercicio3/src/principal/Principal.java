package principal;

import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		System.out.println("Introduce el nombre de la base de datos:");
		String nombreDB = teclado.nextLine();
		
		System.out.println("Introduce el nombre del fichero .sql:");
		String nombreFichero = teclado.nextLine();
		
		try {
			
			AccesoDB baseDatos = new AccesoDB(nombreDB);
			
			baseDatos.ejecutarSentencia(baseDatos.cargarArchivoSql(nombreFichero));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
