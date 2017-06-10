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
		this.id = id;
		this.eventEmiter = eventEmiter;	
		this.fsm = new Fsm(this, this.STATES,id,eventEmiter);
		
		this.horastrabaj =  (int) (tiempodia*0.35);
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

	}
	
	public void trabajando() {
		
		
	}

		
}
