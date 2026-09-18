package mispaquetes;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DestruccionProceso {

public static void main(String[] args) throws IOException, InterruptedException {
	
	 ProcessBuilder pb = new ProcessBuilder("gedit", "notas2.txt");

     File directorio = new File("/home/julio/");
     pb.directory(directorio);

     Process p = pb.start();

     // Esperamos como máximo 5 segundos
     boolean terminado = p.waitFor(5, TimeUnit.SECONDS);

     // Si no ha terminado, lo destruimos
     if (!terminado) {
         System.out.println("Han pasado 5 segundos. Destruimos el proceso.");
         p.destroy();

         // Esperamos a que realmente termine
         p.waitFor();
     }

     System.out.println("El proceso ha terminado.");
     System.out.println("Código de salida: " + p.exitValue());
	}
	
}
