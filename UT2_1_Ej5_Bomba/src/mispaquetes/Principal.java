package mispaquetes;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		ArtifieroBomba artificiero = new ArtifieroBomba(false);
		ArtifieroBomba bomba = new ArtifieroBomba(true);
		
		artificiero.start();
		bomba.start();	
		do {
            try{
                Thread.sleep(50);
            }catch (InterruptedException exc){
                System.out.println("Hilo principal interrumpido.");
            }
        } while (bomba.isAlive()&&
        		artificiero.isAlive());
		
		if (bomba.isAlive()) {
			bomba.interrupt();
			System.out.printf("La bomba ha sido desactivada%n");
		} else {
			artificiero.interrupt();
			System.out.printf("El artificiero ha muerto%n");		
		}			
	}			
	
}
