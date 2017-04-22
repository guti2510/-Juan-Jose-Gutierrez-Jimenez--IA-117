package Controlador;

public class Proceso extends Thread {


	public int nanosegundos;
	public String accion;
	
	public Proceso (String msg, int pnanosegundos, String paccion){
		super(msg);
		nanosegundos = pnanosegundos;
		accion = paccion;
	}
	
	public Proceso (String msg,String paccion){
		super(msg);
		accion = paccion;
	}
	
	public void CambiarAccion(String pNuevaAccion){
		accion = pNuevaAccion;	
	}
	
	public void run(){
		
		if (accion == "Animar"){
			try {
				Main.Animar(nanosegundos);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (accion == "Pasear"){
			
			try {
				Main.Pasear();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (accion == "Buscar"){
			
			try {
				Main.Buscar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
