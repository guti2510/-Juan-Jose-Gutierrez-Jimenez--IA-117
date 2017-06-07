package Model;

public class Cliente {

	public int posX;
	public int posY;
	public String estado;
	public char inicio;
	public char destino;
	
	
	public Cliente() {
		
	}
	public Cliente(int pPosX,int pPosY, char pInicio,char  pDestino){
		
		this.posX = pPosX; 
		this.posY = pPosY;
		inicio = pInicio;
		destino	= pDestino;
	}
	
	public char getInicio() {
		return inicio;
	}
	public void setInicio(char inicio) {
		this.inicio = inicio;
	}
	public char getDestino() {
		return destino;
	}
	public void setDestino(char destino) {
		this.destino = destino;
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int pposX) {
		posX = pposX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int pposY) {
		posY = pposY;
	}

		
}
