
package paquete;

import java.io.File;
import java.io.IOException;

public class EjecutarAplicacionProcessBuilder 
{
	static int retorno =-2;//En caso de que se haya ejecutado correctamente devolverá 0
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		// TODO Auto-generated method stub
		ProcessBuilder pb = new ProcessBuilder("C:/windows/notepad.exe","notas1.txt");
		
		File directorio = new File("c:/Julio/"); pb.directory(directorio);
		 

		Process p = pb.start();
				
		retorno = p.waitFor();
		System.out.println("Llegamos aquí cuando la ejecución del proceso finaliza");
		System.out.println("La ejecución devuelve: "+retorno);
	}
}
