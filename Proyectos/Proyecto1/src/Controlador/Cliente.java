package Controlador;

public class Cliente {

	
	int posX;
	int posY;
	char cuadra;
	char destino;
	
	public Cliente(){
		
		
	}
	public Cliente(int pPosX,int pPosY, char pCuadra,char  pDestino){
		posX = pPosX;
		posY = pPosY;
		cuadra = pCuadra;
		destino	= pDestino;
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
	public char getCuadra() {
		return cuadra;
	}
	public void setCuadra(char cuadra) {
		this.cuadra = cuadra;
	}
	public char getDestino() {
		return destino;
	}
	public void setDestino(char destino) {
		this.destino = destino;
	}
	
	
	
}
