package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal {

	private static final String URL_DB = "jdbc:mysql://localhost/";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USUARIO = "root";
	private static final String CONTRASENIA = "1234";
	private static final String PERMITIR_MULTIQUERY = "?allowMultiQueries=true";
	
	public static void main(String[] args) {

		int edadMedia = 0;
		int totalCiclistas = 0;
		
		try {
		
			Class.forName(DRIVER);
			Connection conexion = DriverManager.getConnection(URL_DB + "ciclista" + PERMITIR_MULTIQUERY, USUARIO, CONTRASENIA);
		
			ResultSet resultado = conexion.createStatement().executeQuery("SELECT sum(edad) FROM ciclista");
			resultado.next();
			edadMedia = resultado.getInt(1);
			
			resultado = conexion.createStatement().executeQuery("SELECT count(edad) FROM ciclista");
			resultado.next();
			totalCiclistas = resultado.getInt(1);
			System.out.println("Total de ciclistas: " + totalCiclistas);
			edadMedia = edadMedia/totalCiclistas;
			
			resultado = conexion.createStatement().executeQuery("SELECT nombre,edad FROM ciclista WHERE edad > " + edadMedia);
			
			System.out.println("Edad media de los ciclistas: " + edadMedia);
			System.out.println("Ciclistas con edades superiores a la media");
			System.out.println("Nombre Ciclista\t\t\tEdad");
			
			while(resultado.next()){
				
				String nombre = resultado.getString(1);
				int edad = resultado.getInt(2);
				
				System.out.println(nombre + "\t\t\t" + edad);
				
			}
			
			System.out.println("\n");
			System.out.println("CICLISTAS GANADORES DE ETAPA");
			
			resultado = conexion.createStatement().executeQuery("SELECT ciclista.nombre,etapa.netapa,etapa.salida,etapa.llegada FROM etapa,ciclista WHERE etapa.dorsal = ciclista.dorsal");
			
			while(resultado.next()){

				String nombre = resultado.getString(1);
				int netapa = resultado.getInt(2);
				String salida = resultado.getString(3);
				String llegada = resultado.getString(4);
				
				System.out.println("Nombre del ciclista: " + nombre);
				System.out.println("\tNº Etapa\tSalida\tLlegada");
				System.out.println("\t" + netapa + "\t\t" + salida + "\t" + llegada);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
