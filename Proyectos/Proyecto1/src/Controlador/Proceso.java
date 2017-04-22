package Controlador;

public class Proceso extends Thread {


	public int nanosegundos;
	
	public Proceso (String msg, int pnanosegundos){
		super(msg);
		nanosegundos = pnanosegundos;
	}
	
	
	public void run(){
		
		try {
			Main.Animar(nanosegundos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
