package mispaquetes;

import java.util.Random;

public class Consumidor extends Thread {
    private Cola cola;
    private int n;
    private String tipo;
    private Random rd = new Random();

    public Consumidor(Cola c, int n, String tipo) {
        cola = c;
        this.n = n;
        this.tipo = tipo;
    }

    public void run() {
        int valor = 0;
        for (int i = 0; i < 5; i++) {
            valor = cola.get(tipo); //recoge el número
            if(valor==0) {
            	System.out.println("CONSUMIDOR = "+n+" -  Vuelta :"+i
                        + " => No había número para mi");              	
            }else {
                System.out.println("CONSUMIDOR = "+n+" -  Vuelta :"+i
                        + " => consume el número: " + valor);            	
            }
            try {
                sleep(rd.nextInt(500,1000));
            } catch (InterruptedException e) { }	
        }
    }
}