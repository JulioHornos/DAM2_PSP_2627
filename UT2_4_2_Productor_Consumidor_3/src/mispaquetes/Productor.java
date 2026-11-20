package mispaquetes;

public class Productor extends Thread {
    private Cola cola;
    private int n;

    public Productor(Cola c, int n) {
        cola = c;
        this.n = n;
    }

    public void run() {
        for (int i = 0; i <= 9; i++) {
            cola.put((i+1)); //pone el número
            System.out.println("PRODUCTOR = " + n + " - Vuelta :"+ i 
                    + " => Produce el número: " + (i+1));
			/*
			 * try { sleep(3000); } catch (InterruptedException e) { }
			 */		
			
        }
    }
}