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
	public int horastrabajo;
	public int horasdescanso;
	
	public int horasdescansadas;
	public int horastrabajadas;
	public String estadopasado;
	public boolean cambio = false;
	
	States state = new States();
	@SuppressWarnings("serial")
	public ArrayList<State> STATES = new ArrayList<State>() {{
	    add(state.new hogar());
	    add(state.new trabajando());
	    add(state.new viajando());
	    add(state.new esperando());
	    
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
    	this.posXdestino = posiciones[0]-1;
    	this.posYdestino = posiciones[1];
    	
		this.id = id;
		this.eventEmiter = eventEmiter;		
		this.horastrabajo =  (int) ((tiempodia/2)*0.30);
		this.horasdescanso = (int) ((tiempodia/2)*0.30);
		this.horastrabajadas = horastrabajo;
		this.horasdescansadas = 0;
		this.fsm = new Fsm(this, this.STATES,id,eventEmiter);
		this.estadopasado = "hogar";
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
	
	
	public void trabajando() {
		
		horastrabajadas--;
		System.out.print(" "+ horastrabajadas);
		this.estadopasado = "trabajando";
		
		if (cambio == false){
			char temp2;
			temp2 = inicio;
			inicio = destino;
			destino = temp2;
			cambio = true;
		}

		
		if (horastrabajadas <= 0){
			
			cambio = false;
			
			int temp = 0;
			temp = posX;
			posX = this.posXdestino;
			posXdestino = temp;
			
			temp = posY;
			posY = posYdestino;
			posYdestino =  temp;
			

			Mapa.mapaciudad[posX][posY] = 'o';
			eventEmiter.send("esperando", this.id);
			
		}
	}
	
	public void hogar() {

		horastrabajadas = horastrabajo;
		this.estadopasado = "hogar";
		horasdescansadas++;
		
		if (cambio == false){
			char temp2;
			temp2 = inicio;
			inicio = destino;
			destino = temp2;
			cambio = true;
		}
		
		System.out.print(" "+ horasdescansadas);
		if (horasdescansadas == horasdescanso){
			
			cambio = false;
			
			int temp = 0;
			temp = posX;
			posX = this.posXdestino;
			posXdestino = temp;
			
			temp = posY;
			posY = posYdestino;
			posYdestino =  temp;
			
			
			Mapa.mapaciudad[posX][posY] = 'o';
			horasdescansadas = 0;
			eventEmiter.send("esperando", this.id);
		}
		
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
