package principal;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Principal {

	private static final String URL_BD = "jdbc:sqlite:bd/ejemplo.bd";
	private static final String DRIVER_SQLITE = "org.sqlite.FDBC";
	
	public static void main(String[] args) {

		try{
			
			Class.forName(DRIVER_SQLITE);
			
			Connection conexion = DriverManager.getConnection(URL_BD);
			
			Statement sentencia = conexion.createStatmente();
			
			ResultSet resul = sentencia.executeQuery("select * from notas");
			
		}
		
	}

}
