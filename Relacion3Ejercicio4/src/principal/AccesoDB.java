package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccesoDB {

	private static final String URL_DB = "jdbc:mysql://localhost/";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USUARIO = "root";
	private static final String CONTRASENIA = "1234";
	private static final String PERMITIR_MULTIQUERY = "?allowMultiQueries=true";
	
	private Connection conexion;
	
	public AccesoDB() throws ClassNotFoundException, SQLException{
		
		Class.forName(DRIVER);
		conexion = DriverManager.getConnection(URL_DB + "ciclista" + PERMITIR_MULTIQUERY, USUARIO, CONTRASENIA);
		
	}
	
	public void crearEtapa(String nombreCiclista, String salida, String llegada, int km) throws SQLException{
		
		PreparedStatement dorsalCiclista =  conexion.prepareStatement("SELECT dorsal FROM ciclista WHERE nombre = ?");
		dorsalCiclista.setString(1, nombreCiclista);
		ResultSet resulDorsal = dorsalCiclista.executeQuery();
		
		resulDorsal.next();
		int dorsal = resulDorsal.getInt(1);
		
		ResultSet sentencia = conexion.createStatement().executeQuery("SELECT MAX(netapa) FROM etapa");
		sentencia.next();
		int numeroEtapa = sentencia.getInt(1) + 1;
		
		dorsalCiclista = conexion.prepareStatement("INSERT INTO etapa VALUES(?,?,?,?,?)");
		dorsalCiclista.setInt(1, numeroEtapa);
		dorsalCiclista.setInt(2, km);
		dorsalCiclista.setString(3, salida);
		dorsalCiclista.setString(4, llegada);
		dorsalCiclista.setInt(5, dorsal);
		dorsalCiclista.executeUpdate();
		
	}
	
	public Connection getConexion(){
		return conexion;
	}
	
}
