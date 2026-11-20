package mispaquetes;

public class Cola {
    private int numero;
    private boolean disponible = false;//inicialmente cola vacia

    public synchronized int get(String tipo) {
    	System.out.println("Soy el hilo de "+tipo+" y el número que hay es "+numero);
    	  while (!disponible) {
    	    try {
    	          wait();
    	    } catch (InterruptedException e) { }
    	  }
    	  //visualize valor
    	  if(tipo.equals("PARES")) {
    		  if (numero%2==0) {
    	    	  disponible = false;
    	    	  notifyAll();
    	    	  return numero;
    		  }else {
    			  return 0;
    		  }
    	  }else {
    		  if (numero%2!=0) {
    	    	  disponible = false;
    	    	  notifyAll();
    	    	  return numero;
    		  }else {
    			  return 0;
    		  }
    	  }    	  
    	}

    public synchronized void put(int valor) {
    	  while (disponible){
    	    try {
    	          wait();
    	    } catch (InterruptedException e) { }
    	  }
    	  numero = valor;
    	  disponible = true;
    	  //visualiza valor
    	  notifyAll();
    	}          
}
