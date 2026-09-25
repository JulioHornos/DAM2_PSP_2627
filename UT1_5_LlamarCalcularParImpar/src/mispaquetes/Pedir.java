package mispaquetes;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

public class Pedir {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.out.println("Escribe un número:" );
		Scanner sc = new Scanner(System.in);
	        // entrada de una cadena
        	String respuesta = sc.nextLine();
		// TODO Auto-generated method stub

		//creamos objeto File al directorio donde esta Ejemplo2
        /* Llamamos al otro programa pasando una ruta absoluta */
		//File directorio = new File("/home/julio/Docencia/workspaces/PSP_CURSO/UT1/UT1_5_CalcularParImpar/bin");	

        /* Llamamos al otro programa pasando una ruta realtiva */	
        File directorio = new File("../UT1_5_CalcularParImpar/bin");	
	
		//El proceso a ejecutar es Ejemplo2			
		ProcessBuilder pb = new ProcessBuilder("java","mispaquetes.Calcular");
		
	    //se establece el directorio donde se encuentra el ejecutable
	    pb.directory(directorio);
		
	    //se ejecuta el proceso
		Process p = pb.start();
		
		respuesta = respuesta+"\n"; 
		OutputStream os = p.getOutputStream();
		
		/* ALTERNATIVA 1 - Trabajamos con bytes */
		//os.write(respuesta.getBytes());
		//os.flush(); // vacía el buffer de salida. Usar uno entre flush y close
		//os.close();
		
		/* ALTERNATIVA 2 - Trabajamos con bytes en buffer*/
		/*BufferedOutputStream bs = new BufferedOutputStream(os);
		bs.write(respuesta.getBytes());
		bs.flush(); // vacía el buffer de salida. Usar uno entre flush y close
		//bs.close();
		*/
		/* ALTERNATIVA 3 - Trabajamos con cadenas  en buffer*/	
		OutputStreamWriter ow = new OutputStreamWriter(os); 
		BufferedWriter bw = new BufferedWriter (ow);
		bw.write(respuesta);
		bw.flush();

		// COMPROBACION DE ERROR - 0 bien - 1 mal	
		int exitVal = -1;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (exitVal == 0) {
		   //obtener la salida devuelta por el proceso
			try {
				InputStream is = p.getInputStream();
				Scanner sc2 = new Scanner(is);
				String salida = sc2.nextLine();
				System.out.println(salida);
				if(sc2.hasNext() == true) {
		            salida = sc2.nextLine();
		            System.out.println(salida);
		        }
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}	
}
