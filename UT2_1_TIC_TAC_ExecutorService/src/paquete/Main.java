package paquete;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        
        //define un pool fijo de dos hilos
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Arrancamos los hilos
        Future<?> tic = executor.submit(new Escribir("TIC"));
        Future<?> tac = executor.submit(new Escribir("TAC"));
        Future<?> toc = executor.submit(new Escribir("TOC"));

        //ordena la destrucción de los dos hilos del pool cuando hayan
        //completado todas las tareas
        executor.shutdown();
               
        
		
		while(!executor.isTerminated()) { 
			Thread.sleep(1000);
		 	System.out.println("Estoy esperando a que acabe el TIC / TAC"); 
		 	}              
        
        // 1º parámetro. Tiempo máximo de espera
        // 2º parámetro. Unidad del timpo
        // Retorna true si acaba antes del tiempo máximo y false cuando supera ese tiempo
		
		 //if(executor.awaitTermination(1,TimeUnit.DAYS))
			// System.out.println("Otra forma de esperar a que acaben los hilos");
		 
        //executor.awaitTermination(40,TimeUnit.SECONDS);
        
        // También podemos controlar las tareas de forma individual
		/*
		 * while(!tic.isDone()||!tac.isDone()) {
		 * System.out.println("Estoy esperando a que acabe el TIC / TAC");
		 * Thread.sleep(1000); }
		 */
        
        System.out.println("Ojo, que no se para en el shutdown");
        
    }
}
