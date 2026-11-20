package mispaquetes;

public class Consumidor extends Thread {
    private Cola cola;
    private int n;

    public Consumidor(Cola c, int n) {
        cola = c;
        this.n = n;
    }

    public void run() {
        int valor = 0;
        for (int i = 0; i < 5; i++) {
            valor = cola.get(); //recoge el número
            System.out.println("CONSUMIDOR = "+n+" -  Vuelta :"+i
                    + " => consume el número: " + valor);
            try {
                sleep(1000);
            } catch (InterruptedException e) { }	
        }
    }
}