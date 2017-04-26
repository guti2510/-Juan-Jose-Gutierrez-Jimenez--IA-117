package Controlador;


public class Taxi {
	

	String nombre;

	int posX;
	int posY;
	
	String estado;
	boolean ocupado;
	
	
	public Taxi(){
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public void MoverDerecha(){
		
		posY = posY+1;
		
	}
}
