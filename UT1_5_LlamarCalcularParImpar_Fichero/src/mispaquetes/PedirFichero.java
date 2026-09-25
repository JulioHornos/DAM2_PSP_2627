package mispaquetes;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PedirFichero {

	public static void main(String[] args) throws IOException {
		//creamos objeto File al directorio donde esta Ejemplo2
        /* Llamamos al otro programa pasando una ruta absoluta */
		//File directorio = new File("/home/julio/Docencia/workspaces/PSP_CURSO/UT1/UT1_5_CalcularParImpar/bin");	

        /* Llamamos al otro programa pasando una ruta realtiva */	
        File directorio = new File("../UT1_5_CalcularParImpar/bin");	

		//El proceso a ejecutar es Ejemplo2			
		ProcessBuilder pb = new ProcessBuilder("java","mispaquetes.Calcular");		
	    //se establece el directorio donde se encuentra el ejecutable
	    pb.directory(directorio);
	    
	    File fBat = new File("/home/julio/Docencia/workspaces/PSP_CURSO/UT1","entrada");
	    File fOut = new File("/home/julio/Docencia/workspaces/PSP_CURSO/UT1","salida");
	    File fErr = new File("/home/julio/Docencia/workspaces/PSP_CURSO/UT1","error");
	 
	    pb.redirectInput(fBat);
	    pb.redirectOutput(fOut);
	    pb.redirectError(fErr); 
		
	    //se ejecuta el proceso
		Process p = pb.start();

	}

}
