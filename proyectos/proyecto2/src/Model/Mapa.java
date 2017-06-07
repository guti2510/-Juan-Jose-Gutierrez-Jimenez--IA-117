package Model;

import java.util.LinkedList;

import Controler.EventEmitter;
import View.VistaPrincipal;

public class Mapa {

	
	static int ciudadfilas = 0;
	static int ciudadcolumnas = 0;
	
	static float tiempoespera;
	
	/*
	static char mapaciudad[][] = {{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
			   {'#','T',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			   {'#',' ','%','%','%',' ','%','o','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'},
			   {'#',' ','%','A','%',' ','%','B','%',' ','%','C','%',' ','%','D','%',' ','%','E','%',' ','%','F','%',' ','%','G','%',' ','#'},
			   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'},
			   {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'},
			   {'#',' ','%','H','%',' ','%','I','%',' ','%','J','%',' ','%','K','%',' ','%','L','%',' ','%','M','%',' ','%','N','%',' ','#'},
			   {'#',' ','%','%','%',' ','%','%','%',' ','%','o','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'},
			   {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'},
			   {'#',' ','%','O','%',' ','%','P','%',' ','%','Q','%',' ','%','R','%',' ','%','S','%',' ','%','a','%',' ','%','U','%',' ','#'},
			   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'},
			   {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'},
			   {'#',' ','%','V','%',' ','%','W','%',' ','%','X','%',' ','%','Y','%',' ','%','Z','%',' ','%','1','%',' ','%','2','%',' ','#'},
			   {'#',' ','o','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#','0','0','0','0','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}, 
			   {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','0','0','0','0','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#','#','#','#','#','#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'}, 
			   {'#',' ','%','3','%',' ','%','4','%',' ','%','5','%',' ','%','6','%',' ','%','7','%',' ','%','8','%',' ','%','9','%',' ',' ',' ',' ',' ',' ',' ',' ','%','z','%',' ','%','w','%',' ','%','y','%',' ','%','k','%',' ','#'},
			   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#','#','#','#','#','#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'},
			   {'#','T',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','0','0','0','0','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			   {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','0','0','0','0','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}};

	*/

	static char[][] mapaciudad = new char[100][100];
	
	static EventEmitter eventEmitter = EventEmitter.getInstance( );
	
	public static LinkedList<Taxi> TaxiList =new LinkedList<Taxi>();
	
	public static LinkedList<Cliente> listaclientes =new LinkedList<Cliente>();
	public static LinkedList<Character> listacuadras =new LinkedList<Character>(); 
	
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
					listacuadras.add(letra);
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
			printCiudad();
			eventEmitter.update();
			eventEmitter.send("update",0);
			VistaPrincipal.printMapa();
			Thread.sleep((long) tiempoespera);
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
	
	public static void Cliente (char origen, char destino){
		
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
    	Cliente nuevocliente = new Cliente(posClienteNuevoX,posClienteNuevoY,origen,destino);
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
}
