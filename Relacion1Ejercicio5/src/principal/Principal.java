package principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Principal {

public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		System.out.println("Escribe una serie de palabras:");
		String palabras = teclado.nextLine();

		try {
			
			File fichero = new File("fichero.txt");
			FileWriter flujo = new FileWriter(fichero);
			BufferedWriter filtro = new BufferedWriter(flujo);
			
			StringTokenizer st = new StringTokenizer(palabras, " ");
			StringBuilder resultado = new StringBuilder();
			
			while(st.hasMoreTokens()){
				
				//StringBuilder palabraInvertida = new StringBuilder(st.nextToken()).reverse();
				resultado.append(st.nextToken() + "\n");
				
			}
			

			filtro.write(resultado.reverse().toString());
			
			filtro.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
