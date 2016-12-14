package principal;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {
	
	private static final String URL_DB = "jdbc:sqlite:db/BDEjercicio1.db";
	private static final String DRIVER = "org.sqlite.JDBC";
	
	private Connection conexion;
	private ResultSet resul;
	private Statement sentencia;
	
	public void conectar() throws ClassNotFoundException, SQLException{
		
		Class.forName(DRIVER);
		conexion = DriverManager.getConnection(URL_DB);
		sentencia = conexion.createStatement();
		
	}
	
	public void cerrarConexion() throws SQLException{
	
		conexion.close();
	
	}
	
	public void borrarCamposTiposTinyInt(String nombreTabla) throws SQLException{
		
		DatabaseMetaData datosMetaData = conexion.getMetaData();
//		ResultSetMetaData rsmd;
		
		resul = datosMetaData.getColumns("EJEMPLO", "PUBLIC", nombreTabla, null);
//		resul = sentencia.executeQuery("SELECT * FROM " + nombreTabla);
		
//		rsmd = resul.getMetaData();
		
		while(resul.next()){
			
			boolean conumnaCorrecta = resul.getString("TYPE_NAME").contains("TINYINT");
			
			
		
		}
		
	}

}
