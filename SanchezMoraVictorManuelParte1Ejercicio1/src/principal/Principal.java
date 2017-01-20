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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Principal {

	private static final String[] MESES = {"ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO","SEPTIEMPBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE"};
	
	public static void main(String[] args) {
			
		File fichero = new File("alquileres.txt");
		
		imprimirMesMAsAlquileres(obtenerListaAlquileres(fichero));
		crearFicheroAlquileres(fichero);
		leerFicheroAlquileres();

	}

	private static void leerFicheroAlquileres() {
		boolean terminado = false;
		
		try {
			
			FileInputStream flujo = new FileInputStream(new File("alquileres.dat"));
			DataInputStream filtro = new DataInputStream(flujo);
			
			while(!terminado){
				int codigo = filtro.readInt();
				String nombre = filtro.readUTF();
				int alquileres = filtro.readInt();
				
				System.out.println(codigo + "\n" + nombre + "\n" + alquileres);
				
			}
			filtro.close();
		
		} catch (EOFException e){
			terminado = true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void crearFicheroAlquileres(File fichero) {
		
		try {
			
			FileOutputStream flujo = new FileOutputStream(new File("alquileres.dat"));
			DataOutputStream filtro2 = new DataOutputStream(flujo);
			
			ArrayList<Socios> listaSocios = obtenerListaSocios(fichero);
			
			for (Iterator iterator = listaSocios.iterator(); iterator.hasNext();) {
				Socios socios = (Socios) iterator.next();

				filtro2.writeInt(socios.getNumero());
				filtro2.writeUTF(socios.getNombre());
				filtro2.writeInt(socios.getAlquiler());
			}
			filtro2.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static ArrayList<Socios> obtenerListaSocios(File fichero) throws FileNotFoundException, IOException {
		FileReader flujo = new FileReader(fichero);
		BufferedReader filtro = new BufferedReader(flujo);

		String linea = filtro.readLine();
		ArrayList<Socios> alquilados = new ArrayList<Socios>();
		
		while(linea != null){
			
			linea = linea.trim();
			if (!linea.equals("")){
				StringTokenizer st = new StringTokenizer(linea, "-");
				st.nextToken();
				int numeroSocio = Integer.valueOf(st.nextToken());
				String nombre = st.nextToken();
				
				Socios s = new Socios(numeroSocio, nombre);
				
				if (alquilados.contains(s)){
					s = alquilados.get(numeroSocio-1);
					s.setAlquiler(s.getAlquiler()+1);
				}else{
					s.setAlquiler(1);
				}
				
				alquilados.add(numeroSocio-1, s);
				
			}
			
			linea = filtro.readLine();
		}
		
		filtro.close();
		return alquilados;
		
	}

	private static void imprimirMesMAsAlquileres(int[] listaAlquileres) {
		//			System.out.println(Arrays.toString(mesesAlquiler));	//ver cuales tiene mas alquileres
					
					int mayor = 0;
					
					for (int j = 0; j < listaAlquileres.length - 1; j++) {
						if (listaAlquileres[j] < listaAlquileres[j+1]){
							mayor = j+1;
						}
					}
					
					System.out.print("Mes en el que mas alquileres se han hecho: " + MESES[mayor]);
	}

	private static int[] obtenerListaAlquileres(File fichero){
		
		int[] mesesAlquiler = new int[12];
		
		for (int i = 0; i < mesesAlquiler.length; i++) {
			mesesAlquiler[i] = 0;
		}
		
		try {
			
			FileReader flujo = new FileReader(fichero);
			BufferedReader filtro = new BufferedReader(flujo);
		
			String linea = filtro.readLine();
			
			while(linea != null){
				linea = linea.trim();
				if (!linea.equals("")){
					StringTokenizer st = new StringTokenizer(linea, "-");
					
					String fecha = st.nextToken();
					st = new StringTokenizer(fecha, "/");
					st.nextToken();
					int mes = Integer.valueOf(st.nextToken()) - 1;
					
					mesesAlquiler[mes]++;
				}
				linea = filtro.readLine();
			}
			filtro.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mesesAlquiler;
	}

}
