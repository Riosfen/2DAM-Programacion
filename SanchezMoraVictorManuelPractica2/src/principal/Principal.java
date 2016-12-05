package principal;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import conexionDB.ConexionDB;

public class Principal {

	public static void main(String[] args) {

		try {
			ConexionDB db = new ConexionDB();
			ResultSet rs;
			ResultSetMetaData rsmd = null;
		
			System.out.print(mostrarDatos(db, rsmd));
			
			db.nuevoCampo("etapasGanadas");
			
			db.cerrarConexion();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String mostrarDatos(ConexionDB db, ResultSetMetaData rsmd) throws SQLException {
		ResultSet rs;
		rs = db.mostrarDatos();
		rsmd = rs.getMetaData();
		StringBuilder resulFila = new StringBuilder();
		
		for (int i = 0; i < rsmd.getColumnCount(); i++) {
			
			resulFila.append(rsmd.getColumnName(i) + "\t");
			
		}
		resulFila.append("\n");
		
		while(rs.next()){
			
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				resulFila.append(rs.getString(i) + "\t"); 
			}
			resulFila.append("\n");
			
		}
		
		return resulFila.toString();
	}

}
