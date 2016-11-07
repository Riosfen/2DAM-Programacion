package principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		String fichero = pedirFichero();

		try {
			FileInputStream flujo = new FileInputStream(new File(fichero));
			
			
		} catch (FileNotFoundException e) {
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
