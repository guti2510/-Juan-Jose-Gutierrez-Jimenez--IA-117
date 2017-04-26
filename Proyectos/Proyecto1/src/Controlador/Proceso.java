package Controlador;

public class Proceso extends Thread {


	public float nanosegundos;
	public String accion;
	public char cuadraparquear;
	
	public Proceso (String msg){
		super(msg);
	}
	
	public Proceso (String msg, float pnanosegundos, String paccion){
		super(msg);
		nanosegundos = pnanosegundos;
		accion = paccion;
	}
	
	public Proceso (String msg, String paccion,char pcuadraparquear){
		super(msg);
		accion = paccion;
		cuadraparquear = pcuadraparquear;
	}
	
	public Proceso (String msg,String paccion){
		super(msg);
		accion = paccion;
	}
	
	public void CambiarAccion(String pNuevaAccion) throws InterruptedException{
		accion = pNuevaAccion;
	}
	
	public void CambiarSegundos(float pNanosegund){
		nanosegundos = pNanosegund;
		Main.CambiarTiempo(pNanosegund);
	}
	
	public String getAccion (){
		return accion;
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
		else if (accion == "Parquear"){
			
			try {
				Main.Parquear(cuadraparquear);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else if (accion == "Pasear2"){
			
			try {
				Main.Pasear2();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		else if (accion == "Buscar2"){
			
			try {
				Main.Buscar2();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}
}
