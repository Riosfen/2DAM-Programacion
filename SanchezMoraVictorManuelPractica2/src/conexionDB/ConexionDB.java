package conexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {
	
	private static final String URL_BD = "jdbc:sqlite:bd/bdCiclistas.bd";
	private static final String DRIVER_SQLITE = "org.sqlite.JDBC";

	private static final String SELECT_CICLISTA_ETAPA_MAS_LARGA = "select * from etapa where km = max(km)";
	private static final String INSERTAR_COLUMNA = "ALTER TABLE Ciclista ADD COLUMN ? INTEGER DEFAULT 0";
	
	private Connection conexion;
	
	public ConexionDB() throws ClassNotFoundException, SQLException{
		
		Class.forName(DRIVER_SQLITE);
		conexion = DriverManager.getConnection(URL_BD);
		
	}

	public ResultSet mostrarDatos() throws SQLException {

		Statement sentencia = conexion.createStatement();
		
		ResultSet resul = sentencia.executeQuery(SELECT_CICLISTA_ETAPA_MAS_LARGA);
		
		return resul;
		
	}
	
	public void cerrarConexion() throws SQLException{
		
		conexion.close();
		
	}

	public void nuevoCampo(String tabla) throws SQLException {

		PreparedStatement pSentencia = conexion.prepareStatement(INSERTAR_COLUMNA);
		pSentencia.setString(1, "tabla");
		
		
		
	}

}
