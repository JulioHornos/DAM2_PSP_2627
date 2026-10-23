package mispaquetes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CorrerRelevoEquipo miRelevoEspaña = new CorrerRelevoEquipo("España");
		CorrerRelevoEquipo miRelevoEEUU = new CorrerRelevoEquipo("EEUU");
		
		Corredor hiloEsp[] = new Corredor[4];
		Corredor hiloEEUU[] = new Corredor[4];
		
		String Equipo[]= {"Pepe","Maria","Juan","Marta"};
		String Equipo2[]= {"John","Kate","Larry","Sarah"};
		
		ExecutorService executor = Executors.newFixedThreadPool(8);
		
		 //Creamos objetos en cada posicion       		
		for(int i=0; i<Equipo.length;i++ ) {
			hiloEsp[i] =  new Corredor(Equipo[i],miRelevoEspaña);
			executor.submit(hiloEsp[i]);			
			hiloEEUU[i] =  new Corredor(Equipo2[i],miRelevoEEUU);
			executor.submit(hiloEEUU[i]);
		}		
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("FINAL DE PROGRAMA");	
		
		System.out.println("Tiempo España: "+miRelevoEspaña.getTiempo());
		System.out.println("Tiempo EEUU: "+miRelevoEEUU.getTiempo());
	}

}
