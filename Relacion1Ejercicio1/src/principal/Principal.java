package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		String nFichero = pedirFichero();
		int nLinea = 0, nPalabra = 0, nLetra = 0;
		
		try {
			
			File archivo = new File(nFichero);
			FileReader flujo = new FileReader(archivo);
			BufferedReader filtro = new BufferedReader(flujo);
			
			String linea = filtro.readLine();
			
			while(linea != null){
				
				nLinea++;
				nLetra = nLetra + linea.length();

				StringTokenizer st = new StringTokenizer(linea, " ");
				
				nPalabra = nPalabra + st.countTokens();
				
				linea = filtro.readLine();
				
			}

			System.out.println("Numero de lineas: " + nLinea);
			System.out.println("Numero de palabras: " + nPalabra);
			System.out.println("Numero de letra: " + nLetra);
			
			filtro.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static String pedirFichero() {

		System.out.println("Introduce el nombre del fichero a analizar:");
		String resul = teclado.nextLine();
		
		return resul;
		
	}

}