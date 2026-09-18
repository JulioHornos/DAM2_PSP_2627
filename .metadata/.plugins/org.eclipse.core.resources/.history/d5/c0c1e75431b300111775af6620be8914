package mispaquetes;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Environment {
    
	public static void main(String[] args) throws IOException, InterruptedException
	{
		ProcessBuilder pb = new ProcessBuilder("C:\\windows\\notepad.exe");
		
                java.util.Map<String, String> env = pb.environment();
                System.out.println("Nº procesadores: " + env.get("NUMBER_OF_PROCESSORS"));
                System.out.println("Procesador: " + env.get("PROCESSOR_ARCHITECTURE"));
	}
	

}
