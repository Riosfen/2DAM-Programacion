package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Principal {

	public static void main(String[] args) {

		try {
			File fichero = new File("LibrosMonroy.dat");
			FileOutputStream flujo = new FileOutputStream(fichero);
			ObjectOutputStream filtro = new ObjectOutputStream(flujo);
			
			File fichero2 = new File("LibrosAlbero.dat");
			FileOutputStream flujo2 = new FileOutputStream(fichero2);
			ObjectOutputStream filtro2 = new ObjectOutputStream(flujo2);
			
			String[] isbn = {"1111111111", "4444444444", "5555555555", "8888888888"};
			String[] titulo = {"Una hora más", "Al filo del mañana", "Ya sé quién eres", "Esto es programación"};
			String[] autor = {"Autor 1", "Autor 4", "Autor 5", "Autor 8"};
			int[] ejemplares = {5,12,9,35};
			
			Libro l;
			int i = 0;
			
			while (i < isbn.length){
				
				l = new Libro(isbn[i], titulo[i], autor[i], ejemplares[i]);
				filtro.writeObject(l);
				
				i++;
			}
			
			String[] isbn2 = {"2222222222", "4444444444", "5555555555", "6666666666"};
			String[] titulo2 = {"El tiempo corre", "Al filo del mañana", "Ya sé quién eres", "El mundo de Eli"};
			String[] autor2 = {"Autor 2", "Autor 4", "Autor 5", "Autor 6"};
			int[] ejemplares2 = {3,24,1,12};

			i=0;
			
			while(i < isbn2.length){
				
				l = new Libro(isbn2[i], titulo2[i], autor2[i], ejemplares2[i]);
				filtro2.writeObject(l);
				
				i++;
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

}
