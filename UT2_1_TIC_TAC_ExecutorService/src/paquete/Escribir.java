package paquete;

public class Escribir implements Runnable{
	// Propiedades
	private String cadena;
	
	// Constructor 
	public Escribir(String cadena){
		this.cadena = cadena;
	}
	
	@Override
	public void run(){
		for (int i=0; i<10; i++){
			try{
				System.out.println(cadena);
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
