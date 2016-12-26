package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

	private static final String FICHERO = "texto.txt";
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		File fichero = new File(FICHERO);

		System.out.println("¿Qué letra deseas cambiar?");
		char c1 = teclado.nextLine().charAt(0);
		
		System.out.println("¿Por cuál la cambiarás?");
		char c2 = teclado.nextLine().charAt(0);
		
		try {
			
			cambiarCaracteres(fichero, c1, c2);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void cambiarCaracteres(File fichero, char c1, char c2) throws IOException {
		
		FileReader filtro = new FileReader(fichero);
		BufferedReader bf = new BufferedReader(filtro);
		
		File fichero2 = new File("temporal.temp");
		FileWriter filtro2 = new FileWriter(fichero2);
		BufferedWriter bf2 = new BufferedWriter(filtro2);
		
		String linea = bf.readLine();
		
		while(linea != null){
			StringBuilder resultado = new StringBuilder();
			for (int i = 0; i < linea.length(); i++) {
				
				if (linea.charAt(i) == c1){
					resultado.append(c2);
				}else{
					resultado.append(linea.charAt(i));
				}
				
			}
			
			bf2.write(resultado.toString());
			
			linea = bf.readLine();
			
		}

		bf.close();
		filtro.close();
		bf2.close();
		filtro2.close();
		
		fichero.delete();
		fichero2.renameTo(new File(FICHERO));
		
		
	}

}
