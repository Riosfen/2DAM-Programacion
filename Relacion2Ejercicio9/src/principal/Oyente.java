package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Oyente extends DefaultHandler {

	String elemento;
	int id, aumento;
	RandomAccessFile filtro;
	
	public Oyente (File fichero){
		try {
			filtro = new RandomAccessFile(fichero, "rw");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {

		String texto = new String(arg0, arg1, arg2);
		texto = texto.trim();
		
		if (elemento.equals("codigo")){
			id = Integer.valueOf(texto);
		}
		if (elemento.equals("porcentajeAumento")){
			aumento = Integer.valueOf(texto);
		}
		
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Empezando a actualizar archivo");
		
		try {
			mostrarFichero(filtro);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {

			elemento = arg2;
		
	}

	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {

		if (elemento.equals("codigo")){
			elemento = "";
		}
		if (elemento.equals("porcentajeAumento")){
			cambiarSaldo();
			elemento = "";
		}

	}

	@Override
	public void endDocument() throws SAXException {
		try {
			mostrarFichero(filtro);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finalizado");

		try {
			filtro.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void cambiarSaldo() {

		try {
			
			filtro.seek((id * 48) - 48);
		
			if (filtro.readInt() == id){
				filtro.seek(filtro.getFilePointer() + 40);
				int saldo = filtro.readInt();
				
				saldo = (int)(saldo * ((float)aumento / 100)) + saldo;
				
				filtro.seek(filtro.getFilePointer() - 4);
				filtro.writeInt(saldo);
				
			}
			
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
