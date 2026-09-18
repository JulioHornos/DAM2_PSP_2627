package mispaquetes;

import java.io.IOException;

public class EjecutarAplicacionRuntime {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Runtime entorno = Runtime.getRuntime();

	    Process p1, p2;

	    // Abrimos el editor de texto
	    p1 = entorno.exec("gedit");

	    // Abrimos otra ventana de terminal
	    p2 = entorno.exec("gnome-terminal");
	    
	    /* WINDOWS
	     * 
	    p1 = entorno.exec("C:\\Windows\\notepad.exe");
		p2 = entorno.exec("cmd /c start"); //Desde la ventana de DOS arrancamos otra venta de DOS
	     * */

	    // main no finaliza hasta que se cierre gedit
	    p1.waitFor();

	    System.out.println(p1.exitValue());

	}

}