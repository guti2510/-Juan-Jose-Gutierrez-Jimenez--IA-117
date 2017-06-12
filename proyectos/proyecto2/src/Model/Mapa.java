package Model;

import java.util.LinkedList;
import java.util.Random;


import Controler.EventEmitter;
import View.VistaPrincipal;

public class Mapa {

	
	static int ciudadfilas = 0;
	static int ciudadcolumnas = 0;
	
	static float tiempoespera;
	
	static char[][] mapaciudad = new char[100][100];
	
	static EventEmitter eventEmitter = EventEmitter.getInstance( );
	
	public static LinkedList<Taxi> TaxiList =new LinkedList<Taxi>();
	
	public static LinkedList<Cliente> listaclientes =new LinkedList<Cliente>();
	public static LinkedList<Character> listahogares =new LinkedList<Character>();
	public static LinkedList<Character> listatrabajos =new LinkedList<Character>();
	
	public static int tiempoactual = 0;
	public static int tiempodia = 0;
	
	public Mapa(StringBuilder stringbuilder) {
		
		int x = 0;
		int y = 0;
		for (int i = 0; i < stringbuilder.length() ; i++){
			
			char letra = stringbuilder.charAt(i);
			if (letra == '\n'){
				x += 1;
				ciudadcolumnas = y;
				y = 0;
				System.out.println();
			}
			else{
				
				if (letra != ' ' && letra != '%' && letra != 'T' && letra != 'o' && letra != '#'){
					
					if (Character.isUpperCase(letra) ){
						listahogares.add(letra);
						
					}else if (Character.isLowerCase(letra)){
						listatrabajos.add(letra);
					}

				}
				
				mapaciudad[x][y] = (char)letra;
				System.out.print(stringbuilder.charAt(i));
				y+=1;
			}
			
		}
		ciudadfilas = x;

		
	}
	
	public static void Animar (float pNanosegundos) throws InterruptedException{
		
		tiempoespera = pNanosegundos*1000;
		while (true){

			if (pNanosegundos == 0){
				printCiudad();
				break;
			}
			//printCiudad();
			tiempoactual = (int) (tiempoactual + pNanosegundos);
		
			
			if (tiempoactual > tiempodia){
				tiempoactual = 0;
			}
			
			
			String tiempo;
			if(tiempoactual <= (tiempodia/2) ){
				tiempo = "Dia";
			}
			else{
				tiempo = "Noche";
			}

			eventEmitter.send("update",0);	

			VistaPrincipal.calcularEdificios();
			VistaPrincipal.setTiempo(tiempo);
			VistaPrincipal.printMapa();
					
			Thread.sleep((long) tiempoespera);
			eventEmitter.update();	
		}
		
	}
	

	public static void printCiudad(){
		
		   int i = 0;
		   int j = 0;
	       for( i = 0; i< ciudadfilas; i++){
	    	   for ( j = 0 ; j< ciudadcolumnas; j++){
	    		   System.out.print(mapaciudad[i][j]);
	    	   }
	    	   System.out.println(" ");
	       }
	       
	}
	
	public static void CambiarTiempo (float pNanosegundos){
		tiempoespera  = pNanosegundos*1000;
	}
	
	 public static char[][] getMapa(){
	    	
	    	return mapaciudad;
	}
	
	public int getCiudadFilas (){
		return ciudadfilas;
		
	}
	
	public int getCiudadColumnas (){
	   return ciudadcolumnas;
		
	}
	
	public static void Cliente (int id, char origen, char destino, EventEmitter eventEmiter){
		
		int posiciones[] = buscarCuadraPos(origen);
    	int posClienteNuevoX = posiciones[0];
    	int posClienteNuevoY = posiciones[1];
    	
    	posClienteNuevoX = posClienteNuevoX-1;
    	
    	//SI ARRIBA YA HAY CLIENTE, LO PONEMOS ABAJO
    	if (Mapa.mapaciudad[posClienteNuevoX][posClienteNuevoY] == 'o'){
    		posClienteNuevoX = posClienteNuevoX +2;
    	}
    	
    	//SI ABAJO YA HAY CLIENTE, LO PONES DERECHA
    	if (Mapa.mapaciudad[posClienteNuevoX][posClienteNuevoY] == 'o'){
    		
    		posClienteNuevoX = posClienteNuevoX - 1;
    		posClienteNuevoY = posClienteNuevoY + 1;
    	}
    	
    	//SI DERECHA YA HAY CLIENTE, LO PONEMOS IZQUIERDA
    	if (Mapa.mapaciudad[posClienteNuevoX][posClienteNuevoY] == 'o'){
    		
    		posClienteNuevoY = posClienteNuevoY - 2;
    	}
    	
    	//SI IZQUIERDA YA HAY CLIENTE, LO PONEMOS EZQUINA SUPERIOR IZQUIERDA
    	if (Mapa.mapaciudad[posClienteNuevoX][posClienteNuevoY] == 'o'){
    		
    		posClienteNuevoX = posClienteNuevoX  -1;
    	}
    	
    	

    	Mapa.mapaciudad[posClienteNuevoX][posClienteNuevoY] = 'o';
    	Cliente nuevocliente = new Cliente(id, posClienteNuevoX, posClienteNuevoY, origen, destino, eventEmiter, tiempodia);
		listaclientes.add(nuevocliente);
    	
		
	}

	private static int[] buscarCuadraPos(char destino) {
		
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

	public static void setDia(int diasegundos) {	
		tiempodia = diasegundos;
	}
	
	public static void Clientes(int numeroclientes, int idsgenerales, EventEmitter eventEmitter){
		
		int idgeneral = idsgenerales;
		if (numeroclientes == 0){
			eliminarClientes();
			
		}
		else {
			int posicionXrandom;
			int posicionYrandom;
			
			int i = 0;
			
			
			Random random = new Random();
			while (i < numeroclientes){
				
				 posicionXrandom = (int)(random.nextDouble() * (ciudadfilas-1) + 1);
				 posicionYrandom = (int)(random.nextDouble() * (ciudadcolumnas-1) + 1);
				 
				 char cuadrainicial = buscarCuadra(posicionXrandom, posicionYrandom);
				 
				 boolean aprovado= false;
				 for (int j = 0; j<listahogares.size(); j++){
					 if (listahogares.get(j) == cuadrainicial){
						 aprovado = true;
					 }
					 
				 }
	 
				 if (Mapa.mapaciudad[posicionXrandom][posicionYrandom] == '%' && aprovado == true){
					 
					 int numerorandom = (int)(random.nextDouble() * listatrabajos.size() + 0);;
					 char cuadrafinal = listatrabajos.get(numerorandom);
					 Mapa.mapaciudad[posicionXrandom][posicionYrandom] = 'o';

			    	Cliente nuevocliente = new Cliente(idgeneral, posicionXrandom, posicionYrandom, cuadrainicial, cuadrafinal, eventEmitter, tiempodia);
			    	eventEmitter.send("esperando",idgeneral);
					listaclientes.add(nuevocliente);
					 i++;
					 idgeneral++;
				 }
		 
			}
		}
		
	}
	
	private static void eliminarClientes() {
		
		int i = 0;
		int j = 0;
		char posverificar;
		
		for( i = 0; i< ciudadfilas; i++){
			for ( j = 0 ; j< ciudadcolumnas; j++){
			   
			   posverificar = Mapa.mapaciudad[i][j];
				
				if (posverificar == 'o' ){
					Mapa.mapaciudad[i][j] = '%';
				}
		
			}
		}
		   
		listaclientes.clear();
		
		
	}
	
	private static char buscarCuadra(int nearXposition, int nearYposition) {
		
		int i = nearXposition-1;
		int j = nearYposition-1;
		char posverificar = ' ';
		int contador = 0;
		
		for (int cantidad = 0; cantidad<9; cantidad++){
			
			if (contador == 3){
				i++;
				contador = 0;
				j = nearYposition-1;
			}
			posverificar = mapaciudad[i][j];
			
			if (posverificar != ' ' && posverificar != '%' && posverificar != 'T' && posverificar != 'o' && posverificar != '*' && posverificar != '#'){
				return 	posverificar;
			}
			
			contador++;
			j++;
		}
		
		return posverificar;
	}
	
	public static void nuevoTaxi(int idsgenerales){
		
		Taxi taxi = new Taxi(idsgenerales,eventEmitter,1,1);
		 Mapa.mapaciudad[1][1] = 'T';
	     Mapa.TaxiList.add(taxi);
	     eventEmitter.send("pasear",idsgenerales);
		
	}
	
	public static int calcularEdificio(char edificio) {

		int cantidad = 0;
		for (int i=0; i< listaclientes.size() ; i++){
			Cliente cliente = listaclientes.get(i);
			
			if(cliente.inicio == edificio){
				cantidad++;		
			}

		}
		
		return cantidad;
		
		
	}
	
}
