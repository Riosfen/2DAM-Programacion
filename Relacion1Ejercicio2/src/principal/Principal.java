package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Principal {
	
	public static void main(String[] args) {
		char[] abecedario = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		int[] numLetrasABC = new int[27];
		
		try {
		
			File fichero = new File("fichero.txt");
			FileReader flujo = new FileReader(fichero);
			BufferedReader filtro = new BufferedReader(flujo);
		
			String linea = filtro.readLine();
			
			while(linea != null){
				
				for (int i = 0; i < linea.length(); i++) {
					char c = Character.toUpperCase(linea.charAt(i));
					
					for (int j = 0; j < abecedario.length; j++) {
						if (c == abecedario[j]){
							numLetrasABC[j]++;
						}
					}
					
				}
				
				linea = filtro.readLine();
				
			}
			
			flujo.close();
			filtro.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < numLetrasABC.length; i++) {
			System.out.println(abecedario[i] + " = " + numLetrasABC[i]);
		}
		
	}

}
