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
			
			while(st.hasMoreTokens()){
				
				StringBuilder palabraInvertida = new StringBuilder(st.nextToken()).reverse();
				System.out.println(palabraInvertida);
				filtro.write(palabraInvertida.toString() + "\n");
				
			}
			
			filtro.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
