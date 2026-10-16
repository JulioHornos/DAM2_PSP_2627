package mispaquetes;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Raton fievel = new Raton("Fievel", 4);
		Raton jerry = new Raton("Jerry", 5);
		Raton pinky = new Raton("Pinky", 3);
		Raton mickey = new Raton("Mickey", 6);
		
		fievel.start();
		jerry.start();
		pinky.start();
		mickey.start();

	}

}
