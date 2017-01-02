package principal;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {

		boolean terminado = false;
		
		try {

			File fichero2 = new File("mejores-peliculas.txt");
			FileWriter flujo2 = new FileWriter(fichero2);
			BufferedWriter filtro2 = new BufferedWriter(flujo2);
			
			File fichero = new File("peliculas.bin");
			FileInputStream flujo = new FileInputStream(fichero);
			DataInputStream filtro = new DataInputStream(flujo);
			
			Pelicula peli;
			Pelicula[] vPeli = new Pelicula[3];
			for (int i = 0; i < vPeli.length; i++) {
				vPeli[i] = new Pelicula(0, "", 0);
			}
			
			try{
				while(!terminado){
					
					int codigo = filtro.readInt();
					String nombre = "";
					for (int i = 0; i < 30; i++) {
						nombre = nombre + (char)filtro.read();
					}
					int vecesAlquilado = filtro.readInt();
					
					peli = new Pelicula(codigo, nombre, vecesAlquilado);
					
					insertarArray(peli, vPeli);
					
				}
			} catch (EOFException e){
				terminado = true;
			}
			
			for (int i = 0; i < vPeli.length; i++) {
				
				filtro2.write(vPeli[i].toString() + "\n");
				
			}
			
			filtro2.close();
			flujo2.close();
			
			filtro.close();
			flujo.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void insertarArray(Pelicula peli, Pelicula[] vPeli) {
		
		boolean colocado = false;
		int contador = 0;
		
		while (!colocado && contador < 3){
			
			if (peli.getVecesAlquilado() > vPeli[contador].getVecesAlquilado()){
				Pelicula aux = vPeli[contador];
				vPeli[contador] = peli;
				colocado = true;
				insertarArray(aux, vPeli);
			}
			
			contador++;
		}
		
	}

}
