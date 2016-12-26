package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Principal {
	
	private static final String FICHERO = "texto";
	
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		try {
			
			File fichero = new File(FICHERO + ".txt");
			FileReader flujo = new FileReader(fichero);
			BufferedReader filtro = new BufferedReader(flujo);

			File fichero2 = new File(FICHERO + ".temp");
			fichero2.createNewFile();
			FileWriter flujo2 = new FileWriter(fichero2);
			BufferedWriter filtro2 = new BufferedWriter(flujo2);

			System.out.println("¿Qué palabra desea buscar? :");
			String buscarPalabra = teclado.nextLine();
			boolean encontrado = false;
			int contador = 1;
			
			String linea = filtro.readLine();
			
			while(linea != null){
				
				int vecesEncontradas = buscarPalabra(linea, buscarPalabra);
				
				if (vecesEncontradas != 0 && !encontrado){
					filtro2.write("Se ha encontrado la palabra " + buscarPalabra + " en el documento:\n");
					encontrado = true;
				}
				
				if (vecesEncontradas != 0){
					filtro2.write("\n\tEn la linea " + contador + ", se han encontrado " + vecesEncontradas + " veces la palabra " + buscarPalabra);
				}
				
				contador++;
				linea = filtro.readLine();
				
			}
			
			if (!encontrado){

				filtro2.write("No se ha encontrado la palabra " + buscarPalabra + " en el documento");
				
			}
			
			filtro.close();
			filtro2.close();
			flujo.close();
			flujo2.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static int buscarPalabra(String linea, String buscarPalabra) {

		String resultado = "";
		
		StringTokenizer st = new StringTokenizer(linea, " ");
		int vecesEncontradas = 0;
		
		while(st.hasMoreTokens()){
			
			String palabra = st.nextToken();
			
			if (palabra.equals(buscarPalabra)){
				vecesEncontradas++;
			}
			
		}
		
		return vecesEncontradas;
		
	}

}
