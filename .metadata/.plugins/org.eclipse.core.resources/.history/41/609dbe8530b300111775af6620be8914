package mispaquetes;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DestruccionProceso {

public static void main(String[] args) throws IOException, InterruptedException
	{
	
	
		// TODO Auto-generated method stub
		ProcessBuilder pb = new ProcessBuilder("C:/windows/notepad.exe");
		
		File directorio = new File("c:/Julio/"); pb.directory(directorio);
		 

		Process p = pb.start();
				
		p.waitFor(5000,TimeUnit.MILLISECONDS); //No funciona. Debería
		p.destroy();
		System.out.println(p.exitValue());
	}
	

}
