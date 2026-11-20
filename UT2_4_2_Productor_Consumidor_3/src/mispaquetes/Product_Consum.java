package mispaquetes;

public class Product_Consum {
	  public static void main(String[] args) {  
	    Cola cola = new Cola();
		
	    Productor p = new Productor(cola, 1);	
		Consumidor c1 = new Consumidor(cola, 1, "PARES");
		Consumidor c2 = new Consumidor(cola, 2, "IMPARES");
		
	    p.start();
		c1.start();
		c2.start();

	  }
	}