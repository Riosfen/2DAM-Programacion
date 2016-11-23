package principal;

import java.sql.ResultSet;

import base_datos.AccesoBD;

public class Principal {

	public static void main(String[] args) {

		

	}
	
	private static void listarNotas(AccesoBD acceso){
		
		ResultSet rs;
		
		rs = acceso.obtenerNotas();
		ResultSetMetaData rsmd = rs.getMetaData();
		String
		
	}

}
