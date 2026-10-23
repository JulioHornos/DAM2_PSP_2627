package mispquetes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Contador {
	private int c = 0;
	Contador(int c) {
		this.c = c;
	}

	public  void incrementa() {
		c++;
	}

	public  void decrementa() {
		c--;
	}

	public int getValor() {
		return c;
	}

}// CONTADOR

class HiloA extends Thread {
	private Contador contador;
	public HiloA(String n, Contador c) {
		setName(n);
		contador = c;
	}
	public void run() {
		for (int j = 0; j < 300; j++) {
			contador.incrementa();
			
			try { 
				sleep(10); 
			} catch (InterruptedException e) { }
			 
		}
		System.out.println(getName() + " contador vale " + contador.getValor());
	}
}// FIN HILOA

class HiloB extends Thread {
	private Contador contador;
	public HiloB(String n, Contador c) {
		setName(n);
		contador = c;
	}
	public void run() {
		for (int j = 0; j < 300; j++) {
			contador.decrementa();
			
			  try { sleep(10); 
			  } catch (InterruptedException e) {
				  
			  }
			 
		}
		System.out.println(getName() + " contador vale " + contador.getValor());
	}
}// FIN HILOB

public class Compartir {
	public static void main(String[] args) {
		Contador cont = new Contador(100);
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.submit(new HiloA("HiloA", cont));
		executor.submit(new HiloB("HiloB", cont));
		
		executor.shutdown();	
		
		
		try {
			executor.awaitTermination(5,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("MAIN: contador vale " + cont.getValor());
	}
}
