package mispaquetes;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Raton fievel = new Raton("Fievel", 4);
		Raton jerry = new Raton("Jerry", 5);
		Raton pinky = new Raton("Pinky", 3);
		Raton mickey = new Raton("Mickey", 6);
		
		fievel.start();
		try {
			fievel.join();
		} catch(Exception e) {
			
		}
		jerry.start();
		try {
			jerry.join();
		} catch(Exception e) {
			
		}
		pinky.start();
		/*
		 * try { pinky.join(); } catch(Exception e) {
		 * 
		 * }
		 */
		mickey.start();
		try {
			mickey.join();
		} catch(Exception e) {
			
		}
		/*
		 * try { Thread.sleep(3500); }catch (Exception e) {
		 * 
		 * }
		 */
		
		
		
		System.out.println ("SOY EL HILO PRNCIPAL") ;
		

	}

}
