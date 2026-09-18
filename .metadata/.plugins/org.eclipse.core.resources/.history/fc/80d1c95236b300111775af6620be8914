package mispaquetes;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Environment {
    
	public static void main(String[] args) throws IOException, InterruptedException
	{
		
		/* WINDOWS
		ProcessBuilder pb = new ProcessBuilder("gedit", "notas2.txt");
        java.util.Map<String, String> env = pb.environment();        
        System.out.println("Nº procesadores: " + env.get("NUMBER_OF_PROCESSORS"));
        System.out.println("Procesador: " + env.get("PROCESSOR_ARCHITECTURE"));
        */
        
        ProcessBuilder pb = new ProcessBuilder("gedit", "notas2.txt");
        System.out.println("Nº procesadores: "
                + Runtime.getRuntime().availableProcessors());

        System.out.println("Sistema operativo: "
                + System.getProperty("os.name"));

        System.out.println("Arquitectura: "
                + System.getProperty("os.arch"));

       // pb.start();
	}
	

}
