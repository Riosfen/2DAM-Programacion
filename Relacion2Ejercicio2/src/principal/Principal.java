package principal;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

public class Principal {

	public static void main(String[] args) {
		
		try {
			
			File fichero = new File("Demandantes2013.csv");
			FileReader flujo = new FileReader(fichero);
			BufferedReader filtro = new BufferedReader(flujo);
			
			File ficheroDat = new File("Huelva.dat");
			RandomAccessFile filtroDat = new RandomAccessFile(ficheroDat, "rw");
			
			System.out.println("\u0061");
			
			String linea = filtro.readLine();
			
			while (linea != null){
				
				StringTokenizer st = new StringTokenizer(linea, ";");
				
				if (st.nextToken().equals("201301")){
					
					for (int i = 0; i < 4; i++) {
						st.nextToken();
					}
					
					if (st.nextToken().equals("Huelva")){

						int codigoLocalidad = Integer.valueOf(st.nextToken());
						String nombreLocalidad = String.format("%1$-50s", st.nextToken());
						int totalDemandante = Integer.valueOf(st.nextToken());
						
						filtroDat.writeInt(codigoLocalidad);
						filtroDat.write(nombreLocalidad.getBytes());
						filtroDat.writeInt(totalDemandante);
						
					}
					
				}
				
				linea = filtro.readLine();
				
			}
			
			leerFicheroDatos(filtroDat);
			
			filtro.close();
			flujo.close();
			
			filtroDat.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void leerFicheroDatos(RandomAccessFile filtroDat) throws IOException {
		filtroDat.seek(0);
		
		boolean terminado = false;
		
		try {
		
			while (!terminado){
				
				int codigo = filtroDat.readInt();
				StringBuilder nombre = new StringBuilder();
				for (int i = 0; i < 50; i++) {
					nombre.append((char)filtroDat.read());
				}
				int demandante = filtroDat.readInt();
				
				System.out.println(codigo+"\t" + nombre+"\t" + demandante);
				
			}
			
		} catch (EOFException e) {
			terminado = true;
		}
	}

}
