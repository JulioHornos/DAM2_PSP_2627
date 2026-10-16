package mispaquetes;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Raton fievel = new Raton("Fievel", 4);		
		Raton jerry = new Raton("Jerry", 5);
		Raton pinky = new Raton("Pinky", 3);	
		Raton mickey = new Raton("Mickey", 6);
			

		new Thread(fievel).start();

		Thread p = new Thread(pinky);
		p.start();
		/*
		 * try { p.join(); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		new Thread(mickey).start();
		new Thread(jerry).start();
		System.out.println("FINAL DE PROGRAMA");	

	}

}
