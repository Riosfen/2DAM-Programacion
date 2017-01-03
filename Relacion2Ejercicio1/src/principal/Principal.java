package principal;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Principal {

	private static final int SUELDO = 40;
	private static final int TOTAL = 48;
	
	public static void main(String[] args) {
		try {
			
			File fichero = new File("Empleados.dat");
			RandomAccessFile filtroAleatorio = new RandomAccessFile(fichero, "rw");

			File fichero2 = new File("Aumentos.dat");
			FileInputStream flujo = new FileInputStream(fichero2);
			DataInputStream filtro = new DataInputStream(flujo);

			mostrarFichero(filtroAleatorio);
			
			try {
				
				while(true){
					
					int empleado = filtro.readInt();
					int aumento = filtro.readInt();
					
					filtroAleatorio.seek((empleado -1) * 48);
					
					if (filtroAleatorio.readInt() == empleado){
						
						filtroAleatorio.seek(filtroAleatorio.getFilePointer() + SUELDO);
						int sueldo = filtroAleatorio.readInt();
						sueldo += sueldo * aumento / 100;
						filtroAleatorio.seek(filtroAleatorio.getFilePointer()-4);
						filtroAleatorio.writeInt(sueldo);
						
					}
					
				}
				
			} catch (EOFException e) {
				// TODO: handle exception
			}

			mostrarFichero(filtroAleatorio);

			filtro.close();
			flujo.close();
			
			filtroAleatorio.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void mostrarFichero(RandomAccessFile filtroAleatorio) throws IOException {

		filtroAleatorio.seek(0);
		
		while(filtroAleatorio.length() > filtroAleatorio.getFilePointer()){
			
			int nEmpleado = filtroAleatorio.readInt();
			StringBuilder nombre = new StringBuilder();
			for (int i = 0; i < 20; i++) {
				nombre.append(filtroAleatorio.readChar());
			}
			int saldo = filtroAleatorio.readInt();
			
			System.out.println(nEmpleado+"\t" + nombre+"\t" + saldo);
			
		}

		filtroAleatorio.seek(0);
	}

}
