package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal {

	private static final String URL_BD = "jdbc:sqlite:bd/ejemplo.bd";
	private static final String DRIVER_SQLITE = "org.sqlite.JDBC";
	
	public static void main(String[] args) {
		
		Connection conexion = null;

		try{
			// para cargar el driver que se va a utilizar para la conexion
			Class.forName(DRIVER_SQLITE);
			
			// para cargar la bd
			conexion = DriverManager.getConnection(URL_BD);
			// para que no cargue en la bd los datos automaticamente
			conexion.setAutoCommit(false);
			
			java.sql.Statement sentencia = conexion.createStatement();
			
			sentencia.close();
			conexion.commit();
			conexion.close();
			
			ResultSet resul = sentencia.executeQuery("select * from notas");
			
		} catch (SQLException e) {
			
			System.err.println(e.getMessage());
			System.out.println("ERROR, NO SE EFECTUARA NINGUN CAMBIO");
			if (conexion != null) {
				realizarRollBack(conexion);
			}
			
		} catch (ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}

	private static void realizarRollBack(Connection conexion) {

		try {
			
			conexion.rollback();
			
		} catch (SQLException e) {

			System.out.println("ERROR AL REALIZAR EL ROLLBACK");

		}
		
	}

}
