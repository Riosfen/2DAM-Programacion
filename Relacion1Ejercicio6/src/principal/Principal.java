package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Principal {
	
	private static final String FICHERO = "texto";
	
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int contador = 1;
		
		try {
			
			File fichero = new File(FICHERO + ".txt");
			FileReader flujo = new FileReader(fichero);
			BufferedReader filtro = new BufferedReader(flujo);

			File fichero2 = new File(FICHERO + ".temp");
			FileReader flujo2 = new FileReader(fichero2);
			BufferedReader filtro2 = new BufferedReader(flujo2);
			
			String linea = filtro.readLine();
			StringBuilder resultado = new StringBuilder();
			
			while(linea != null){
				
				String resultado = buscarPalabra(linea, contador);
				
				contador++;
				linea = filtro.readLine();
				
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String buscarPalabra(String linea, int contador) {

		String resultado = "";
		
		StringTokenizer st = new StringTokenizer(linea, " ");
		
		while(st.hasMoreTokens()){
			
			
			
		}
		
		return resultado;
		
	}

}
