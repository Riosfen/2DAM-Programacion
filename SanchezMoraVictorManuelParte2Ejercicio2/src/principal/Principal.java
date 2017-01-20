package principal;

import java.sql.Connection;
import java.sql.SQLException;

public class Principal {


	static Connection conexion;
	
	public static void main(String[] args) {

		AccesoBD db;
		try {
			
			db = new AccesoBD("academia");
			db.agregarCampoATabla("alumno", "numeroAsignaturas");
			
			mostrarNombreAsignaturaMatriculado(db);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void mostrarNombreAsignaturaMatriculado(AccesoBD db) throws SQLException {

		db.ejecutarSentencia("111111");
		
	}

}
