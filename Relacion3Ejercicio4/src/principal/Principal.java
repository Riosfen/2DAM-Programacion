package principal;

import java.sql.SQLException;
import java.util.Scanner;

public class Principal {
	
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Introduce el nombre de la ciudad de salida: ");
		String salida = teclado.nextLine();
		System.out.println("Introduce el nombre de la ciudad de llegada: ");
		String llegada = teclado.nextLine();
		System.out.println("Introduce el numero de kilometros: ");
		int km = Integer.valueOf(teclado.nextLine());
		System.out.println("Introduce el nombre del ciclista: ");
		String nombre = teclado.nextLine();
		
		try {
			
			AccesoDB baseDatos = new AccesoDB();
			baseDatos.crearEtapa(nombre, salida, llegada, km);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ciclista no encontrado...");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
