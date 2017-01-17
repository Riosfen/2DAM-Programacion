package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	private static final String BD_SQLITE = "org.sqlite.JDBC";
	private static final String URL = "jdbc:sqlite:bd/BDEjercicio1.db";
	
	public static void main(String[] args) {
		
		try {
				
			Class.forName(BD_SQLITE);
			
			Connection conexion = DriverManager.getConnection(URL);
			
			mostrarTabla(conexion);
			actualizarNotas(conexion);
			mostrarTabla(conexion);
			
			conexion.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void actualizarNotas(Connection conexion) throws SQLException {
		Statement sentencia = conexion.createStatement();
		ResultSet resultado = sentencia.executeQuery("SELECT dni FROM alumnos WHERE faltas >= 20");
		PreparedStatement resulUpdate = conexion.prepareStatement("UPDATE notas SET nota = nota -1 WHERE dni = ? AND nota > 0");
		
		while (resultado.next()){
			int dni = resultado.getInt(1);
				
				resulUpdate.setInt(1, dni);
				resulUpdate.executeUpdate();
			
		}

		resultado.close();
		resulUpdate.close();
		sentencia.close();
	}

	private static void mostrarTabla(Connection conexion) throws SQLException {
		
		Statement sentencia = conexion.createStatement();
		ResultSet resultado = sentencia.executeQuery("SELECT * FROM notas");
		ResultSetMetaData mdResultado = resultado.getMetaData();
		
		while (resultado.next()){
			for (int j = 1; j <= mdResultado.getColumnCount(); j++) {
				System.out.print(resultado.getString(j) + "\t");
			}
			System.out.println();
		}
		sentencia.close();
		System.out.println();
	}

}
