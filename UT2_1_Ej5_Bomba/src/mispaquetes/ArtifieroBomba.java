package mispaquetes;

public class ArtifieroBomba extends Thread{
	
	private Boolean contador;	

	public  ArtifieroBomba(Boolean contador) {
	
		super ();
		this.contador = contador;
		
		}
		
	public void contador() {
		try {
			int j =9;
			for(int i = 0; i < 10; i++) {
				System.out.printf(String.valueOf(j-i)+" %n");
				this.sleep(1000);
			}				
				System.out.printf("PUUUUUUMMMMMMMMMM%n");									
		}catch (InterruptedException e) {
			// se lanza esta excepción cuando interrumpimos el hilo
			// Aquí colocamos el código que queremos que se ejecute. 
			// En este caso, irnos
			return;		
		}														
	}
	
	public  void artificero() {
		try {
			Integer numero = (int)(Math.random()*(1050-950+1)+950);
			System.out.printf("El artificiero comienza a desactivar la bomba%n") ;
			this.sleep(numero*10);		
			System.out.printf("El artificiero ha desactivado la bomba%n") ;
		}catch (InterruptedException e) {
			// se lanza esta excepción cuando interrumpimos el hilo
			// Aquí colocamos el código que queremos que se ejecute. 
			// En este caso, irnos
			return;			
		}											
	}
	
	@Override
	public void run() {
		if(this.contador) {
			this.contador();
		} else {
			this.artificero();
		}		
	}


}