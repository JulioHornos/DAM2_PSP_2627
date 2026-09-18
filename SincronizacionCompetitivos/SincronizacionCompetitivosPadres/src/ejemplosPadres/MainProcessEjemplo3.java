package ejemplosPadres;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainProcessEjemplo3 {

    private static final Random RANDOM = new Random();
    private static final String[] CHILDREN_COMMAND = 
		{"java", // ejecutamos un programa java 
		 "-cp",  // indicamos que le vamos a indicar la ruta de las clases
		 "../SincronizacionCompetitivosHIjos/bin", 
		 // Ruta relativa de la clase del programa llamado desde la ubicación del llamante 
		 //(la carpeta de proyecto del llamante 
		"ejemplosHijos.ChildProcessEjemplo3"};

    public static void main(String[] args) {

        // Crear un processBuilder para poder lanzar varias veces el mismo proceso (varios hijos)
        ProcessBuilder childrenProcessBuilder = new ProcessBuilder(CHILDREN_COMMAND);         
        
        // Lista de procesos para poder lanzar un número determinado de procesos
        List<Process> processes = new ArrayList<>();

        try {
            // Calcular un número aleatorio de hijos que se lanzarán
            int numberOfProcesses = RANDOM.nextInt(10, 20+1); // Entre 10 y 20 a.i.
            // Lanzar los hijos, y guardar la referencia a los procesos creados en la lista
            for (int i = 0; i < numberOfProcesses; i++) {
                processes.add(childrenProcessBuilder.start());
            }

            // Esperar a todos los procesos. Se hace con espera activa para poder monitorizar cuantos está
            // todavía activos. 
            // Inicialmente, se asume que todos los procesos siguen en marcha.
            int childrenAlive = processes.size();
            int[] processesDead = new int[numberOfProcesses];
            System.out.printf("Se han lanzado %d procesos hijos.\n",  childrenAlive);
            // Mientras que haya hijos en marcha...
            while (childrenAlive > 0) {
                // Informar
            	for(int i=0; i<numberOfProcesses; i++) {
            		if(!processes.get(i).isAlive()) processesDead[i]=1;
            	}
            	
                int suma = 0;                
                // Recorre el array y suma los elementos
                for (int i = 0; i < processesDead.length; i++) {
                    suma += processesDead[i]; 
                }
                childrenAlive = processes.size() - suma;
                System.out.printf("Procesos aún en ejecución: %d\n", childrenAlive);

                // Dormir el proceso principal
                Thread.sleep(1000);
            }
            System.out.println("Todos los procesos han finalizado.");
        } catch (IOException e) {
            throw new RuntimeException("Error de E/S al ejecutar procesos hijos.", e);
        } catch (InterruptedException e) {
            throw new RuntimeException("Proceso principal interrumpido mientras esperaba a un proceso hijo", e);
        }
    }
}
