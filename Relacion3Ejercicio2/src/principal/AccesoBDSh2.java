package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AccesoBDSh2 {

	private static final String URL_BD_H2 = "jdbc:h2:./bd/departamentos.mv.db";
	private static final String DRIVER_H2 = "org.h2.Driver";

	private static Connection conexion;
	
	public AccesoBDSh2 () throws ClassNotFoundException, SQLException{
		
		Class.forName(DRIVER_H2);
		conexion = DriverManager.getConnection(URL_BD_H2, "", "");
		
	}
	
	public ResultSet ejecutarSentencia(String sentenciaSQL) throws SQLException{
		
		Statement sentencia = conexion.createStatement();
		ResultSet resultado = sentencia.executeQuery(sentenciaSQL);
		
		return resultado;
		
	}
	
	public Connection getConexion(){return conexion;}
	
	public void cerrarConexion() throws SQLException{conexion.close();}
	
}
