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

	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Introduce el nombre del fichero: ");
		String fichero = teclado.nextLine();
		char abc[] = {'a', 'b','c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
						'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't',
						'u', 'v', 'w', 'x', 'y', 'z'};
		boolean abecedario[] = new boolean[abc.length];
		
		try {
			
			FileReader flujoEntrada = new FileReader(new File(fichero));
			BufferedReader filtroEntrada = new BufferedReader(flujoEntrada);
			FileWriter flujoSalida = new FileWriter(new File("copia" + fichero));
			BufferedWriter filtroSalida = new BufferedWriter(flujoSalida);
			
			String linea = filtroEntrada.readLine();
			
			while(linea != null){
				
				for (int i = 0; i < linea.length(); i++) {
					char c = linea.charAt(i);
					for (int j = 0; j < abecedario.length; j++) {
						if (c == abc[j]){
							
							abecedario[j] = true;
							
						}
					}
					
				}
				
				filtroSalida.write(linea);
				
				linea = filtroEntrada.readLine();
				
			}
			
			StringBuilder sb = new  StringBuilder();
			
			for (int i = 0; i < abecedario.length; i++) {
				if (abecedario[i] == false){
					
					sb.append(abc[i]);
					
				}
			}
			
			filtroSalida.write(sb.toString());
			
			filtroEntrada.close();
			filtroSalida.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
