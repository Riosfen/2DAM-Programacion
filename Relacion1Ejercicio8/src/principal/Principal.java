package principal;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Principal {

	public static void main(String[] args) {
		try {
			File fichero = new File("peliculas.txt");
			FileReader flujo = new FileReader(fichero);
			BufferedReader filtro = new BufferedReader(flujo);

			File fichero2 = new File("peliculas.bin");
			FileOutputStream flujo2 = new FileOutputStream(fichero2);
			DataOutputStream filtro2 = new DataOutputStream(flujo2);
			
			String linea = filtro.readLine();
			
			while(linea != null){
				
				StringTokenizer st = new StringTokenizer(linea, "@");
				
				int codigo = Integer.parseInt(st.nextToken());
				String titulo = st.nextToken();
				int nAlquilada = Integer.parseInt(st.nextToken());
				
				filtro2.writeInt(codigo);
				String b = String.format("%1$-30s",titulo);
				filtro2.write(b.getBytes());
				filtro2.writeInt(nAlquilada);
				
				linea = filtro.readLine();
				
			}
			
			filtro.close();
			flujo.close();
			filtro2.close();
			flujo2.close();
			
			leerBinario();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void leerBinario() throws IOException {

		boolean terminado = false;
		
		File fichero = new File("peliculas.bin");
		FileInputStream flujo = new FileInputStream(fichero);
		DataInputStream filtro = new DataInputStream(flujo);

		System.out.println("CODIGO\tTITULO\t\t\t\tVECES-ALQUILADA");
		
		try {
		
			while (!terminado){
				
				int codigo = filtro.readInt();
				String titulo = "";
				
				for (int i = 0; i < 30; i++) {
					
					titulo = titulo + (char)filtro.read();
					
				}
				
				int nAlquilada = filtro.readInt();
				
				System.out.println(codigo+"\t" + titulo+"\t" + nAlquilada);
				
			}
		
		} catch (EOFException e) {
			terminado = true;
			System.out.println("\nFin del fichero");
		}
			
		filtro.close();
		flujo.close();
		
	}

}
