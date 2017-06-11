package Model;

import java.util.ArrayList;

import Controler.EventEmitter;
import Controler.Fsm;
import Model.States.buscar;
import Model.States.conCliente;
import Model.States.pasear;

public class Cliente {

	public int posX;
	public int posY;
	public char inicio;
	public char destino;
	public int posXdestino;
	public int posYdestino;
	public int id;
	public int horastrabaj;
	
	States state = new States();
	@SuppressWarnings("serial")
	public ArrayList<State> STATES = new ArrayList<State>() {{
	    add(state.new hogar());
	    add(state.new trabajando());
	}};

    public EventEmitter eventEmiter;
	public Fsm fsm;
	
	public Cliente() {
		
	}
	public Cliente(int id,int pPosX,int pPosY, char pInicio,char  pDestino, EventEmitter eventEmiter,int tiempodia){
		
		this.posX = pPosX; 
		this.posY = pPosY;
		
		inicio = pInicio;
		
		destino	= pDestino;
		
    	int posiciones[] = buscarCuadraPos(destino);
    	posXdestino = posiciones[0];
    	posYdestino = posiciones[1];
    	
		this.id = id;
		this.eventEmiter = eventEmiter;		
		this.horastrabaj =  (int) (tiempodia*0.35);
		this.fsm = new Fsm(this, this.STATES,id,eventEmiter);
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
	public void esperandoTaxi() {
		System.out.println("Espernado TAXI");
	}
	
	public void trabajando() {
		
		
	}
	
	private int[] buscarCuadraPos(char destino) {
		
		   int posX = 0;
		   int posY = 0;
		   int i = 0;
		   int j = 0;
	       for( i = 0; i< Mapa.ciudadfilas; i++){
	    	   for ( j = 0 ; j< Mapa.ciudadcolumnas; j++){
	    		   if (Mapa.mapaciudad[i][j] == destino){
	    			   posX = i;
	    			   posY = j;
	    		   }
	    	   }
	       }
		
	       return new int[] {posX, posY};

	}

		
}
