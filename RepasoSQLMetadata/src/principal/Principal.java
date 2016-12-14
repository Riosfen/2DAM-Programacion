package principal;

import java.sql.SQLException;
import java.util.Scanner;

public class Principal {
	
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ConexionDB conexion = new ConexionDB();
		
		try {
			
			conexion.conectar();
		
			System.out.println("Indica el nombre de la tabla para borrar los campos con tinyint:");
			String nombreTabla = teclado.nextLine();
			
			conexion.borrarCamposTiposTinyInt(nombreTabla);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
