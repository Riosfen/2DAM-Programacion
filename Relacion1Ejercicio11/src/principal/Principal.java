package principal;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Principal {

	public static void main(String[] args) {
		
		try {
			
			File fichero = new File("TotalLibros.txt");
			FileWriter flujo = new FileWriter(fichero);
			BufferedWriter filtro = new BufferedWriter(flujo);
			
			File ficheroMonroy = new File("LibrosMonroy.dat");
			FileInputStream flujoMonroy = new FileInputStream(ficheroMonroy);
			ObjectInputStream filtroMonroy = new ObjectInputStream(flujoMonroy);
			
			File ficheroAlbero = new File("LibrosAlbero.dat");
			FileInputStream flujoAlbero = new FileInputStream(ficheroAlbero);
			ObjectInputStream filtroAlbero = new ObjectInputStream(flujoAlbero);
		
			Libro lMonroy;
			Libro lAlbero;
			
			lMonroy = siguienteLibroMonroy(filtroMonroy);
			lAlbero = siguienteLibroAlbero(filtroAlbero);
			
			while(lMonroy != null && lAlbero != null){
				
				if (lMonroy.getCodigo().equals(lAlbero.getCodigo())){
					
					lAlbero.fusionarLibros(lMonroy);
					filtro.write(lAlbero.toString() + "\n");

					lMonroy = siguienteLibroMonroy(filtroMonroy);
					lAlbero = siguienteLibroAlbero(filtroAlbero);
					
				}else{
					
					if ( lMonroy.getCodigo().compareTo(lAlbero.getCodigo()) > 0 ){
						
						filtro.write(lAlbero.toString() + "\n");
						lAlbero = siguienteLibroAlbero(filtroAlbero);
						
					}else{
						
						filtro.write(lMonroy.toString() + "\n");
						lMonroy = siguienteLibroMonroy(filtroMonroy);
						
					}
				}
				
			}
			
			if (lAlbero == null){
				while(lMonroy != null){
					filtro.write(lMonroy.toString() + "\n");
					lMonroy = siguienteLibroMonroy(filtroMonroy);
				}
				
			}
			if (lMonroy == null){
				
				while(lAlbero != null){
					filtro.write(lAlbero.toString() + "\n");
					lAlbero = siguienteLibroAlbero(filtroAlbero);
				}
				
			}
			
			filtroAlbero.close();
			flujoAlbero.close();
			
			filtroMonroy.close();
			flujoMonroy.close();
			
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

	private static Libro siguienteLibroMonroy(ObjectInputStream filtroMonroy)
			throws IOException {
		
		Libro lMonroy = null;
		
		try {
			lMonroy = (Libro) filtroMonroy.readObject();
		} catch (EOFException e) {
			// TODO Auto-generated catch block
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lMonroy;
	}
	
	private static Libro siguienteLibroAlbero(ObjectInputStream filtroAlbero)
			throws IOException {
		
		Libro lAlbero = null;
		
		try {
			lAlbero = (Libro) filtroAlbero.readObject();
		} catch (EOFException e) {
			// TODO Auto-generated catch block
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lAlbero;
	}

}
