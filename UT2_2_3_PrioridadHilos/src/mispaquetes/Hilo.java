package mispaquetes;

public class Hilo extends Thread {
	
	private MemoriaComun miMemoriaComun;

    /**************************************************************************
     * constructor por defecto
     */
    public Hilo(MemoriaComun miMemoriaComun) {
        //hereda la prioridad del hilo padre
    	this.miMemoriaComun = miMemoriaComun;
    }

    /**************************************************************************
     * constructor personalizado
     */
    public Hilo(int prioridad, MemoriaComun miMemoriaComun) {

        //establece la prioridad indicada
        this.setPriority(prioridad);
        this.miMemoriaComun = miMemoriaComun;
    }

    /**************************************************************************
     * ejecuta una tarea pesada
     */
    @Override
    public void run() {

        for (int i = 0; i < 5000; ++i) {
        	this.miMemoriaComun.pasar();
           //this.yield();
           try {
        	   this.sleep(1);
           } catch (InterruptedException e) {
			// TODO Auto-generated catch block
        	   e.printStackTrace();
           }
        }

        System.out.println("Hilo de prioridad " + this.getPriority()
                + " termina ahora");
    }
}
