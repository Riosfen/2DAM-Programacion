package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBD {

	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String DIRECCION_DB = "jdbc:mysql://localhost/";
	private final String PERMITIR_MULTIPLES_CONSULTAS = "?allowMultiQueries=true";
	
	private Connection conexion;
	
	public AccesoBD(String baseDatos) throws ClassNotFoundException, SQLException{
		Class.forName(DRIVER);
		conexion = DriverManager.getConnection(DIRECCION_DB + baseDatos + PERMITIR_MULTIPLES_CONSULTAS, "root", "1234");
		
	}
	
	public void agregarCampoATabla(String tabla, String campo) throws SQLException{
		
		PreparedStatement sentencia = conexion.prepareStatement("Alter table ? add ? int(11) DEFAULT ];");
		sentencia.setString(1, tabla);
		sentencia.setString(2, campo);
		sentencia.executeQuery();
		
	}
	
	public void cerrarDB() throws SQLException{
		conexion.close();
	}

	public void ejecutarSentencia(String string) throws SQLException {

		Statement sentencia = conexion.createStatement();
		ResultSet resultado = sentencia.executeQuery("select asignatura.Nombre FROM alumno,alumno_asignatura,asignatura WHERE alumno.idalumno = alumno_asignatura.idalumno AND alumno_asignatura.idasignatura = asignatura.idasignatura");
		
		while(resultado.next()){
			String asig = resultado.getString(0);
			System.out.println("Id Alumno :" + string);
			System.out.println("Asignaturas en las que esta matriculado");
			System.out.println(asig);
			
		}
		
	}

}
