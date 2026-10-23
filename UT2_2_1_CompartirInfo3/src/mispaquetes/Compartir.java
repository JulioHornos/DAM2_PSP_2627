package mispaquetes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


class Contador {
	private int c = 0;
	private int a = 0;
	Contador(int c) {
		this.c = c;
		this.a = c;
	}

	public  void incrementa() {
			a++;
			synchronized(this) {
				c++;
			}	
		
	}

	public  void decrementa() {
			a--;
		synchronized(this) {
			c--;
		}
				
	
	}

	public synchronized int getValor() {
		return c;
	}
	
	public synchronized int getValorA() {
		return a;
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
			
			  try { sleep(10); } catch (InterruptedException e) { }
			 
		}
		System.out.println(getName() + " contador vale " + contador.getValor());
		System.out.println(getName() + " contador vale A " + contador.getValorA());
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
			
			  try { sleep(10); } catch (InterruptedException e) {}
			 
		}
		System.out.println(getName() + " contador vale " + contador.getValor());
		System.out.println(getName() + " contador vale A " + contador.getValorA());
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
		System.out.println("MAIN: contador vale A " + cont.getValorA());
	}
}