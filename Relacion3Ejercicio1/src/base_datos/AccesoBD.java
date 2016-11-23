package base_datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccesoBD {
	
	public ResultSet obtenerNotas(){
		
		Statement sentencia = conexion.createStatement();
		ResultSet resul = sentencia.executeQuery(SELECT_NOTAS);
		
		return resul;
	}
	
	public void modificarNotas(int faltas){
		
		String dni;
		PreparedStatement sentencia = conexion.prepareStatement("Select dni from alumnos where falta > ?");
		sentencia.setInt(1, faltas);
		
		ResulSet resul = sentencia.executeQuery();
		
		Statement nuevaSentencia = ;
		
	}

}
