package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoDB {

	private static final String URL_DB = "jdbc:mysql://localhost/";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USUARIO = "root";
	private static final String CONTRASENIA = "1234";
	private static final String PERMITIR_MULTIQUERY = "?allowMultiQueries=true";
	
	private Connection conexion;
	
	public AccesoDB(String nombreDB) throws ClassNotFoundException, SQLException{
		
		Class.forName(DRIVER);
		conexion = DriverManager.getConnection(URL_DB + nombreDB + PERMITIR_MULTIQUERY, USUARIO, CONTRASENIA);
		
	}
	
	public void ejecutarSentencia(String nombreSentencia) throws SQLException{
		
		Statement sentencia = conexion.createStatement();
		sentencia.execute(nombreSentencia);
		
	}
	
	public String cargarArchivoSql(String ficheroSql){
		StringBuilder sbResultado = new StringBuilder();
		
		try {
			
			FileReader flujo = new FileReader(new File(ficheroSql));
			BufferedReader filtro = new BufferedReader(flujo);
			
			String linea = filtro.readLine();
			
			while(linea != null){
				
				sbResultado.append(linea+"\n");
				
				linea = filtro.readLine();
			}
			
			filtro.close();
			flujo.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sbResultado.toString();
		
	}
	
}
