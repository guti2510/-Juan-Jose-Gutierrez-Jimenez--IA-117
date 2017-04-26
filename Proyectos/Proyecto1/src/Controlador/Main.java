package Controlador;

import java.util.LinkedList;
import java.util.Random;





public class Main {

	static int ciudadfilas1 = 16;
	static int ciudadcolumnas1 = 31;

	static int ciudadfilas2 = 23;
	static int ciudadcolumnas2 = 54;
	
	static float tiempoespera;
	
	static LinkedList<Integer> path =new LinkedList<Integer>();  
    static LinkedList<Node> openlist =new LinkedList<Node>();  
    static LinkedList<Node> closelist =new LinkedList<Node>();
    static LinkedList<Character> cuadrasvisitadas =new LinkedList<Character>();
    
    
	static LinkedList<Integer> path2 =new LinkedList<Integer>();  
    static LinkedList<Node> openlist2 =new LinkedList<Node>();  
    static LinkedList<Node> closelist2 =new LinkedList<Node>();
    static LinkedList<Character> cuadrasvisitadas2 =new LinkedList<Character>(); 
    
    
    
    
    static LinkedList<Cliente> listaclientes =new LinkedList<Cliente>();
    static LinkedList<Character> listacuadras =new LinkedList<Character>(); 
    static LinkedList<Integer> listamostrar =new LinkedList<Integer>();
    static LinkedList<Integer> listamostrar2 =new LinkedList<Integer>();
    
    static Taxi Taxi = new Taxi();
    static Taxi Taxi2 = new Taxi();
    
    static boolean mostrar = false;
    static boolean mostrar2 = false;
    
    
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
						   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#','0','0','0','0','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}, 
						   {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','0','0','0','0','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
						   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#','#','#','#','#','#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'}, 
						   {'#',' ','%','3','%',' ','%','4','%',' ','%','5','%',' ','%','6','%',' ','%','7','%',' ','%','8','%',' ','%','9','%',' ',' ',' ',' ',' ',' ',' ',' ','%','z','%',' ','%','w','%',' ','%','y','%',' ','%','k','%',' ','#'},
						   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#','#','#','#','#','#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'},
						   {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','0','0','0','0','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
						   {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','0','0','0','0','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}};
	
	static char cvisitada;
	
	static int posCuadraClienteX;
	static int posCuadraClienteY;
	
	static int posCuadraClienteX2;
	static int posCuadraClienteY2;
	
	static String accion;

	/*  ---------------------------------------------------------------------------------------------------------------*/
	/*  ----------------------------------- FUNCIONES PRINCIPALES ----------------------------------------------------- */
	/*  ---------------------------------------------------------------------------------------------------------------*/
	
	public static void Animar (float pNanosegundos) throws InterruptedException{
		
		//AQUI AGREGO EL CLIENTE QUE YA ESTA EN EL MAPA
		Cliente cliente = new Cliente(2,7,'A','M');
		listaclientes.add(cliente);
		Taxi.setNombre("Taxi 1");
		tiempoespera = pNanosegundos*1000;
		cargarCuadras();
		while (true){

			if (pNanosegundos == 0){
				printCiudad();
				break;
			}
			printCiudad();
			System.out.println(accion);
			Thread.sleep((long) tiempoespera);
		}
		
	}
	
	public static void Pasear () throws InterruptedException{
		
		path.clear();
	    openlist.clear();
	    closelist.clear();
	    cuadrasvisitadas.clear();
		
		int posiciones[] = buscarTaxipos();
		int posicionX = posiciones[0];
		int posicionY = posiciones[1];
		
		Taxi.setPosX(posicionX);
		Taxi.setPosY(posicionY);
		//Taxi Taxi = new Taxi(posicionX,posicionY,0);
		Taxi.estado = "Paseando";
		accion = "Paseando";
		
		while (accion == "Paseando"){
			

			encontrarCuadra(Taxi);
			
			System.out.println("Cuadra visitada:"+cvisitada);
			String movimiento = "";
			
			//REMUEVO LA POSICION ACTUAL DEL T QUE NO NECESITO
			path.removeLast();
			path.removeLast();
			while (path.size() != 0 ){
				
				int nuevaposY = path.getLast();
				path.removeLast();
				int nuevaposX = path.getLast();
				path.removeLast();
				
				if (nuevaposX > posicionX){
					movimiento = "Abajo";
				}
				else if(nuevaposX < posicionX){
					movimiento = "Arriba";
				}
	            else if(nuevaposY > posicionY){
	            	movimiento = "Derecha";
				}
	            else if(nuevaposY < posicionY){
	            	movimiento = "Izquierda";
				}
				
				if (mostrar == true){
					limpiarNumeros();
				}
				moverTaxi(nuevaposX,nuevaposY,movimiento);
				
				posicionX = nuevaposX;
				posicionY = nuevaposY;
				//moverTaxiMarcando(nuevaposX,nuevaposY,movimiento);
				Thread.sleep((long) tiempoespera);
			}
			if (mostrar == true){
				limpiarNumeros();
			}
			limpiarCamino();
			int posiciones2[] = buscarTaxipos();
			posicionX = posiciones2[0];
			posicionY = posiciones2[1];
			
			System.out.println("PASEANDO");
			System.out.println("Pos TAXI X: "+posicionX);
			System.out.println("Pos TAXI Y: "+posicionY);
			Taxi.setPosX(posicionX);
			Taxi.setPosY(posicionY);
		    path.clear();
		    openlist.clear();
		    closelist.clear();
			
		}
	}
	
	public static void Buscar () throws InterruptedException{
		
		
		
		Taxi.estado = "Buscar";	
		accion = "Buscar";

		path.clear();
	    openlist.clear();
	    closelist.clear();
	    cuadrasvisitadas.clear();
	    
		int posiciones[] = buscarTaxipos();
		int posicionX = posiciones[0];
		int posicionY = posiciones[1];
		
		Taxi.setPosX(posicionX);
		Taxi.setPosY(posicionY);
		
		
		while (accion == "Buscar"){
			
			encontrarCuadra(Taxi);
			
			System.out.println("Cuadra visitada:"+cvisitada);
			String movimiento = "";
			
			//REMUEVO LA POSICION ACTUAL DEL T QUE NO NECESITO
			path.removeLast();
			path.removeLast();
			while (path.size() != 0 ){
				
				int nuevaposY = path.getLast();
				path.removeLast();
				int nuevaposX = path.getLast();
				path.removeLast();
				
				if (nuevaposX > posicionX){
					movimiento = "Abajo";
				}
				else if(nuevaposX < posicionX){
					movimiento = "Arriba";
				}
	            else if(nuevaposY > posicionY){
	            	movimiento = "Derecha";
				}
	            else if(nuevaposY < posicionY){
	            	movimiento = "Izquierda";
				}	
				moverTaxiBuscando(nuevaposX,nuevaposY,movimiento);
				posicionX = nuevaposX;
				posicionY = nuevaposY;
				//moverTaxiMarcando(nuevaposX,nuevaposY,movimiento);
				Thread.sleep((long) tiempoespera);
			}
			int posiciones2[] = buscarTaxipos();
			posicionX = posiciones2[0];
			posicionY = posiciones2[1];
			
			System.out.println("BUSCANDO");
			System.out.println("Pos TAXI X: "+posicionX);
			System.out.println("Pos TAXI Y: "+posicionY);
			Taxi.setPosX(posicionX);
			Taxi.setPosY(posicionY);
		    path.clear();
		    openlist.clear();
		    closelist.clear();
	
		
		}
	}
	
	public static void Mostrar (boolean pEstado){
		
		if (pEstado == true){
			mostrar = pEstado;
		}
		else {
			
			limpiarCamino();
			mostrar = false;
			
		}
	}
	

	
	private static void limpiarCamino() {
		int i = 0;
		int j = 0;
		char posverificar;
		for( i = 0; i< ciudadfilas1; i++){
			for ( j = 0 ; j< ciudadcolumnas1; j++){
			   
				posverificar = mapaciudad[i][j];
				
					if (posverificar == '*'){
						mapaciudad[i][j] = ' ';
					}
	
			}
		}
	   
	
	   for( i = 16; i< ciudadfilas2; i++){
		   for ( j = 0 ; j< ciudadcolumnas2; j++){
			   posverificar = mapaciudad[i][j];
				
			   if (posverificar == '*'){
					mapaciudad[i][j] = ' ';
				}
		   }
	   }
		
	}
	
	private static void limpiarNumeros() {


		for( int i = 0; i< listamostrar.size(); i=i+2){
			int posx = listamostrar.get(i);
			int posy = listamostrar.get(i+1);
			mapaciudad[posx][posy] = ' ';
		}
		listamostrar.clear();
	}

	public static void Ruta (boolean pEstado){
		
		if (pEstado == true){
			int posY;
			int posX;
			for (int i = path.size()-1; i >= 0 ; i=i-2){
				posY = path.get(i);
				posX = path.get(i-1);
	
				mapaciudad[posX][posY] = '*';
			}
		}
		else{
			
			int posY;
			int posX;
			for (int i = path.size()-1; i >= 0 ; i=i-2){
				posY = path.get(i);
				posX = path.get(i-1);
	
				mapaciudad[posX][posY] = ' ';
			}
			
		}
	}
	
	public static void Clientes(int numeroclientes){
		
		
		if (numeroclientes == 0){
			eliminarClientes();
			
		}
		else {
			int posicionXrandom;
			int posicionYrandom;
			
			int i = 0;
			
			
			Random random = new Random();
			while (i < numeroclientes){
				
				 posicionXrandom = (int)(random.nextDouble() * 22 + 0);
				 posicionYrandom = (int)(random.nextDouble() * 53 + 0);
				 
				 if (posicionXrandom <= 15 && posicionYrandom >= 31){
					 while (posicionYrandom >= 31){
						 posicionYrandom = (int)(random.nextDouble() * 53 + 0);
					 }
				 }
				 
				 if (mapaciudad[posicionXrandom][posicionYrandom] == '%'){
					 
					 char cuadrainicial = buscarCuadra(posicionXrandom, posicionYrandom);
					 int numerorandom = (int)(random.nextDouble() * 38 + 0);;
					 char cuadrafinal = listacuadras.get(numerorandom);
					 mapaciudad[posicionXrandom][posicionYrandom] = 'o';
	
					 Cliente nuevocliente = new Cliente(posicionXrandom,posicionYrandom,cuadrainicial,cuadrafinal);
					 listaclientes.add(nuevocliente);
					 i++;
				 }
		 
			}
		}
		
	}
	
	private static void eliminarClientes() {
		
		int i = 0;
		int j = 0;
		char posverificar;
		
		for( i = 0; i< ciudadfilas1; i++){
			for ( j = 0 ; j< ciudadcolumnas1; j++){
			   
			   posverificar = mapaciudad[i][j];
				
				if (posverificar == 'o' ){
					mapaciudad[i][j] = '%';
				}
		
			}
		}
   

		for( i = 16; i< ciudadfilas2; i++){
		   for ( j = 0 ; j< ciudadcolumnas2; j++){
			   posverificar = mapaciudad[i][j];
				
			   if (posverificar == 'o' ){
					mapaciudad[i][j] = '%';
				}
		   }
		}
		   
		listaclientes.clear();
		
		
	}

	public static void Cliente (char origen, char destino){
		
		int posiciones[] = buscarCuadraPos(origen);
    	int posClienteNuevoX = posiciones[0];
    	int posClienteNuevoY = posiciones[1];
    	
    	posClienteNuevoX = posClienteNuevoX-1;
    	
    	//SI ARRIBA YA HAY CLIENTE, LO PONEMOS ABAJO
    	if (mapaciudad[posClienteNuevoX][posClienteNuevoY] == 'o'){
    		posClienteNuevoX = posClienteNuevoX +2;
    	}
    	
    	//SI ABAJO YA HAY CLIENTE, LO PONES DERECHA
    	if (mapaciudad[posClienteNuevoX][posClienteNuevoY] == 'o'){
    		
    		posClienteNuevoX = posClienteNuevoX - 1;
    		posClienteNuevoY = posClienteNuevoY + 1;
    	}
    	
    	//SI DERECHA YA HAY CLIENTE, LO PONEMOS IZQUIERDA
    	if (mapaciudad[posClienteNuevoX][posClienteNuevoY] == 'o'){
    		
    		posClienteNuevoY = posClienteNuevoY - 2;
    	}
    	
    	//SI IZQUIERDA YA HAY CLIENTE, LO PONEMOS EZQUINA SUPERIOR IZQUIERDA
    	if (mapaciudad[posClienteNuevoX][posClienteNuevoY] == 'o'){
    		
    		posClienteNuevoX = posClienteNuevoX  -1;
    	}
    	
    	

    	mapaciudad[posClienteNuevoX][posClienteNuevoY] = 'o';
    	Cliente nuevocliente = new Cliente(posClienteNuevoX,posClienteNuevoY,origen,destino);
		listaclientes.add(nuevocliente);
    	
		
	}
	
	public static void Parquear(char destino) throws InterruptedException{
		
		
		Taxi.estado = "Parqueando";	
		accion = "Parqueando";

		path.clear();
	    openlist.clear();
	    closelist.clear();
	    cuadrasvisitadas.clear();
	    
		int posiciones[] = buscarTaxipos();
		int posicionX = posiciones[0];
		int posicionY = posiciones[1];
		
		Taxi.setPosX(posicionX);
		Taxi.setPosY(posicionY);

		encontrarCuadraParquear(Taxi,destino);
		
		System.out.println("Cuadra visitada:"+cvisitada);
		String movimiento = "";
		
		//REMUEVO LA POSICION ACTUAL DEL T QUE NO NECESITO
		path.removeLast();
		path.removeLast();
		while (path.size() != 0 ){
			
			int nuevaposY = path.getLast();
			path.removeLast();
			int nuevaposX = path.getLast();
			path.removeLast();
			
			if (nuevaposX > posicionX){
				movimiento = "Abajo";
			}
			else if(nuevaposX < posicionX){
				movimiento = "Arriba";
			}
            else if(nuevaposY > posicionY){
            	movimiento = "Derecha";
			}
            else if(nuevaposY < posicionY){
            	movimiento = "Izquierda";
			}	
			
			if (mostrar == true){
				limpiarNumeros();
			}
			moverTaxi(nuevaposX,nuevaposY,movimiento);

			posicionX = nuevaposX;
			posicionY = nuevaposY;
			//moverTaxiMarcando(nuevaposX,nuevaposY,movimiento);
			Thread.sleep((long) tiempoespera);
		}
		if (mostrar == true){
			limpiarNumeros();
		}
		limpiarCamino();
		int posiciones2[] = buscarTaxipos();
		posicionX = posiciones2[0];
		posicionY = posiciones2[1];
		
		System.out.println("PARQUEANDO");
		System.out.println("Pos TAXI X: "+posicionX);
		System.out.println("Pos TAXI Y: "+posicionY);
		Taxi.setPosX(posicionX);
		Taxi.setPosY(posicionY);
	    path.clear();
	    openlist.clear();
	    closelist.clear();
	    accion = "Esperando";	
		

	}
	
	/*  ----------------------------------- FUNCIONES SECUNDARIAS ----------------------------------------------------- */
	
	
	
	private static boolean buscarCliente(int nearXposition, int nearYposition) {
		
		int i = nearXposition-1;
		int j = nearYposition-1;
		char posverificar = ' ';
		int contador = 0;
		boolean clientecerca = false;
		for (int cantidad = 0; cantidad<9; cantidad++){
			
			if (contador == 3){
				i++;
				contador = 0;
				j = nearYposition-1;
			}
			posverificar = mapaciudad[i][j];
			
			if (posverificar == 'o'){
				clientecerca = true;
				return clientecerca;
			}
			
			contador++;
			j++;
		}
		
		return clientecerca;
	}
	
	private static int[] buscarClientePos(int nearXposition, int nearYposition) {
		
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
			
			if (posverificar == 'o'){
				return new int[] {i, j};
			}
			
			contador++;
			j++;
		}
		
		return new int[] {i, j};
	}
	
	
	private static void moverTaxi(int posX, int posY, String movimiento) {
		
		
		if (mostrar == false){
		
			if (movimiento == "Derecha"){
				mapaciudad[posX][posY-1] = ' ';
			}
			else if (movimiento == "Izquierda"){
				mapaciudad[posX][posY+1] = ' ';
			}
			else if (movimiento == "Abajo"){
				mapaciudad[posX-1][posY] = ' ';		
			}
			else if (movimiento == "Arriba"){
				mapaciudad[posX+1][posY] = ' ';
			}
			
			mapaciudad[posX][posY] = 'T';
		
		}
		else{
			
			if (movimiento == "Derecha"){
				mapaciudad[posX][posY-1] = '*';
			}
			else if (movimiento == "Izquierda"){
				mapaciudad[posX][posY+1] = '*';
			}
			else if (movimiento == "Abajo"){
				mapaciudad[posX-1][posY] = '*';		
			}
			else if (movimiento == "Arriba"){
				mapaciudad[posX+1][posY] = '*';
			}
			
			mapaciudad[posX][posY] = 'T';
			
			int nextY = 0;
			int nextX = 0;
			if (path.size() != 0){
				nextY = path.getLast();
				path.removeLast();
				nextX = path.getLast();
				path.removeLast();
				
				listamostrar.add(nextX);
				listamostrar.add(nextY);
				
				path.addLast(nextX);
				path.addLast(nextY);
			}
			
			if (nextX > posX){
				movimiento = "Abajo";
			}
			else if(nextX < posX){
				movimiento = "Arriba";
			}
            else if(nextY > posY){
            	movimiento = "Derecha";
			}
            else if(nextY < posY){
            	movimiento = "Izquierda";
			}	
			
			int cantidadcaminos = 1;
			
			if ( mapaciudad[nextX][nextY] == ' '){
				mapaciudad[nextX][nextY] = '1';
				cantidadcaminos++;
			}
			
			if (mapaciudad[posX+1][posY] == ' ' && movimiento != "Abajo"){

				char cant = (char)(cantidadcaminos + '0');
				mapaciudad[posX+1][posY] = cant;
				listamostrar.add(posX+1);
				listamostrar.add(posY);
				cantidadcaminos++;
			}
			
			if (mapaciudad[posX-1][posY] == ' ' && movimiento != "Arriba"){
				char cant = (char)(cantidadcaminos + '0');
				mapaciudad[posX-1][posY] = cant;
				listamostrar.add(posX-1);
				listamostrar.add(posY);
				cantidadcaminos++;
			}
			
			if (mapaciudad[posX][posY+1] == ' ' && movimiento != "Derecha"){
				char cant = (char)(cantidadcaminos + '0');
				mapaciudad[posX][posY+1] = cant;
				listamostrar.add(posX);
				listamostrar.add(posY+1);
				cantidadcaminos++;
			}
			
			if (mapaciudad[posX][posY-1] == ' ' && movimiento != "Izquierda"){
				char cant = (char)(cantidadcaminos + '0');
				mapaciudad[posX][posY-1] = cant;
				listamostrar.add(posX);
				listamostrar.add(posY-1);
				cantidadcaminos++;
			}
			
		}
	}
	
	private static void moverTaxiBuscando(int posX, int posY, String movimiento) throws InterruptedException {
		
		
		if (movimiento == "Derecha"){
			mapaciudad[posX][posY-1] = ' ';
		}
		else if (movimiento == "Izquierda"){
			mapaciudad[posX][posY+1] = ' ';
		}
		else if (movimiento == "Abajo"){
			mapaciudad[posX-1][posY] = ' ';		
		}
		else if (movimiento == "Arriba"){
			mapaciudad[posX+1][posY] = ' ';
		}
		
		mapaciudad[posX][posY] = 'T';
		//Busca Clientes
		if(buscarCliente(posX,posY)){
			
			int posiciones[] = buscarClientePos(posX,posY);
			int clienteX = posiciones[0];
			int clienteY = posiciones[1];
			
			recogerCliente(clienteX,clienteY);
			Taxi.estado = "Buscar";
		    removerCliente(clienteX, clienteY);
		    Buscar();
			
		}
	}
	
    private static void recogerCliente(int clienteX, int clienteY) throws InterruptedException {
		
    	mapaciudad[clienteX][clienteY] = '%';
    	char destino = clienteDestino(clienteX,clienteY);
    	
    	System.out.println("DESTINO CLIENTE : "+destino);
    	
    	int posiciones[] = buscarCuadraPos(destino);
    	posCuadraClienteX = posiciones[0];
    	posCuadraClienteY = posiciones[1];
    	
    	System.out.println("CUADRA Cliente X : "+posCuadraClienteX);
    	System.out.println("CUADRA Cliente Y : "+posCuadraClienteY);
    	
    	path.clear();
	    openlist.clear();
	    closelist.clear();
	    cuadrasvisitadas.clear();
	    
		int posiciones2[] = buscarTaxipos();
		int posicionX = posiciones2[0];
		int posicionY = posiciones2[1];
		
		Taxi.setPosX(posicionX);
		Taxi.setPosY(posicionY);
    	
    	Taxi.estado = "Ocupado";
    	
		encontrarCuadraCliente(Taxi);
		
		System.out.println("Cuadra visitada:"+cvisitada);
		String movimiento = "";
		
		//REMUEVO LA POSICION ACTUAL DEL T QUE NO NECESITO
		path.removeLast();
		path.removeLast();
		while (path.size() != 0 ){
			
			int nuevaposY = path.getLast();
			path.removeLast();
			int nuevaposX = path.getLast();
			path.removeLast();
			
			if (nuevaposX > posicionX){
				movimiento = "Abajo";
			}
			else if(nuevaposX < posicionX){
				movimiento = "Arriba";
			}
            else if(nuevaposY > posicionY){
            	movimiento = "Derecha";
			}
            else if(nuevaposY < posicionY){
            	movimiento = "Izquierda";
			}
			
			if (mostrar == true){
				limpiarNumeros();
			}
			moverTaxi(nuevaposX,nuevaposY,movimiento);

			posicionX = nuevaposX;
			posicionY = nuevaposY;
			//moverTaxiMarcando(nuevaposX,nuevaposY,movimiento);
			Thread.sleep((long) tiempoespera);
		}
		if (mostrar == true){
			limpiarNumeros();
		}
		
		limpiarCamino();
		int posiciones3[] = buscarTaxipos();
		posicionX = posiciones3[0];
		posicionY = posiciones3[1];
		
		System.out.println("BUSCANDO");
		System.out.println("Pos TAXI X: "+posicionX);
		System.out.println("Pos TAXI Y: "+posicionY);
		Taxi.setPosX(posicionX);
		Taxi.setPosY(posicionY);
	    path.clear();
	    openlist.clear();
	    closelist.clear();

		
	}


	private static int[] buscarCuadraPos(char destino) {
		
		   int posX = 0;
		   int posY = 0;
		   int i = 0;
		   int j = 0;
	       for( i = 0; i< ciudadfilas1; i++){
	    	   for ( j = 0 ; j< ciudadcolumnas1; j++){
	    		   if (mapaciudad[i][j] == destino){
	    			   posX = i;
	    			   posY = j;
	    		   }
	    	   }
	       }
	       

	       for( i = 16; i< ciudadfilas2; i++){
	    	   for ( j = 0 ; j< ciudadcolumnas2; j++){
	    		   if (mapaciudad[i][j] == destino){
	    			   posX = i;
	    			   posY = j;
	    		   }
	    	   }
	       }
		
	       return new int[] {posX, posY};

	}

	private static char clienteDestino(int clienteX, int clienteY) {

		char destino = ' ';
		
		
		for (int i = 0; i<listaclientes.size(); i++){
			
			Cliente clientetemp = new Cliente();
			clientetemp = listaclientes.get(i);
			
			int postempX = clientetemp.getPosX();
			int postempY = clientetemp.getPosY();
			
			if (postempX == clienteX && postempY == clienteY){
				destino = clientetemp.getDestino();
				return destino;
			}
			
			
		}

		return destino;
	}

	private static void removerCliente(int clienteX, int clienteY) {
		
		
		for (int i = 0; i<listaclientes.size(); i++){
			
			Cliente clientetemp = new Cliente();
			clientetemp = listaclientes.get(i);
			
			int postempX = clientetemp.getPosX();
			int postempY = clientetemp.getPosY();
			
			if (postempX == clienteX && postempY == clienteY){
				listaclientes.remove(i);
			}

		}
		
	}

	public static void CambiarTiempo (float pNanosegundos){
		tiempoespera  = pNanosegundos*1000;

	}
	// ------- B U S C A R --------//
	public static void encontrarCuadraCliente (Taxi taxi){
		
		int posinicialX = taxi.getPosX();
		int posinicialY = taxi.getPosY();
		
		path.clear();
	    openlist.clear();
	    closelist.clear();
	    cuadrasvisitadas.clear();
		
		Node initialnode = new Node(posinicialX,posinicialY,0,posCuadraClienteX,posCuadraClienteY);
		verificarMovimientos2 (initialnode);
		
		closelist.add(initialnode);
		int nearXposition = initialnode.positionX;
		int nearYposition = initialnode.positionY;
		boolean notfound = true;
		while(notfound){
			
			Node popednode = popLowestNode();
			closelist.add(popednode);
			nearXposition = popednode.positionX;
			nearYposition = popednode.positionY;
			
			//Reviso Arriba
			if ((posCuadraClienteX-2 == nearXposition && posCuadraClienteY == nearYposition) || (posCuadraClienteX == nearXposition && posCuadraClienteY-2 == nearYposition) 
			  || (posCuadraClienteX == nearXposition && posCuadraClienteY+2 == nearYposition) || (posCuadraClienteX+2 == nearXposition && posCuadraClienteY == nearYposition)){
				//Aqui encontramos el destino
				createPath(popednode);
				break;
			}
			
			verificarMovimientos2 (popednode);
			
		}
		
	}

	// ------- P A S E A R --------//
	public static void encontrarCuadra(Taxi taxi){
		
		//Esta es la cola FIFO
		
		int posinicialX = taxi.getPosX();
		int posinicialY = taxi.getPosY();
		
		Node initialnode = new Node(posinicialX,posinicialY,0);
		
		verificarMovimientos (initialnode);
		closelist.add(initialnode);
		int nearXposition = initialnode.positionX;
		int nearYposition = initialnode.positionY;
		boolean notfound = true;
		while(notfound){
			
			Node popednode = openlist.getFirst();
			openlist.removeFirst();
			closelist.add(popednode);
			nearXposition = popednode.positionX;
			nearYposition = popednode.positionY;

			//Reviso que esten cerca de la cuadra
			//ARRIBA
			if ( mapaciudad[nearXposition-1][nearYposition] == '%' || mapaciudad[nearXposition-1][nearYposition] == 'o'){
				//Aqui encontramos el destino
				
				char nombrecuadra =  buscarCuadra(nearXposition-1,nearYposition);
				boolean cuadravisitada = revisarCuadra(nombrecuadra);
				if (cuadravisitada == false){
					cvisitada = nombrecuadra;
					cuadrasvisitadas.add(nombrecuadra);
					
					if (cuadrasvisitadas.size() == 39 ){
						cuadrasvisitadas.clear();
						cuadrasvisitadas.add(nombrecuadra);
					}
					createPath(popednode);
					break;
					
				}
				
			}
			//ABAJO
			else if (mapaciudad[nearXposition+1][nearYposition] == '%' || mapaciudad[nearXposition+1][nearYposition] == 'o'){
				
				char nombrecuadra = buscarCuadra(nearXposition+1,nearYposition);
				boolean cuadravisitada = revisarCuadra(nombrecuadra);
				if (cuadravisitada == false){
					cvisitada = nombrecuadra;
					cuadrasvisitadas.add(nombrecuadra);
					
					if (cuadrasvisitadas.size() == 39 ){
						cuadrasvisitadas.clear();
						cuadrasvisitadas.add(nombrecuadra);
					}
					
					createPath(popednode);
					break;
					
				}
				
			}
			//DERECHA
			else if (mapaciudad[nearXposition][nearYposition+1] == '%' || mapaciudad[nearXposition][nearYposition+1] == 'o'){
				
				char nombrecuadra =  buscarCuadra(nearXposition,nearYposition+1);
				boolean cuadravisitada = revisarCuadra(nombrecuadra);
				if (cuadravisitada == false){
					cvisitada = nombrecuadra;
					cuadrasvisitadas.add(nombrecuadra);
					
					if (cuadrasvisitadas.size() == 39 ){
						cuadrasvisitadas.clear();
						cuadrasvisitadas.add(nombrecuadra);
					}
					
					createPath(popednode);
					break;
					
				}
				
			}
			//IZQUIERDA
			else if (mapaciudad[nearXposition][nearYposition-1] == '%' || mapaciudad[nearXposition][nearYposition-1] == 'o' ){
				
				char nombrecuadra =  buscarCuadra(nearXposition,nearYposition-1);
				boolean cuadravisitada = revisarCuadra(nombrecuadra);
				if (cuadravisitada == false){
					cvisitada = nombrecuadra;
					cuadrasvisitadas.add(nombrecuadra);
					
					if (cuadrasvisitadas.size() == 39 ){
						cuadrasvisitadas.clear();
						cuadrasvisitadas.add(nombrecuadra);
					}
					
					createPath(popednode);
					break;
					
				}
				
			}
			

			verificarMovimientos (popednode);
			
			
		}
		
		
		
	}
	
	// ------ P A R Q U E A R -------------------------------------------------------///
	public static void encontrarCuadraParquear (Taxi taxi, char cuadraparquear){
		
		int posinicialX = taxi.getPosX();
		int posinicialY = taxi.getPosY();
		
		path.clear();
	    openlist.clear();
	    closelist.clear();
	    cuadrasvisitadas.clear();
	    
	    int posiciones[] = buscarCuadraPos(cuadraparquear);
    	posCuadraClienteX = posiciones[0];
    	posCuadraClienteY = posiciones[1];
		
		Node initialnode = new Node(posinicialX,posinicialY,0,posCuadraClienteX,posCuadraClienteY);
		verificarMovimientos2 (initialnode);
		
		closelist.add(initialnode);
		int nearXposition = initialnode.positionX;
		int nearYposition = initialnode.positionY;
		boolean notfound = true;
		while(notfound){
			
			Node popednode = popLowestNode();
			closelist.add(popednode);
			nearXposition = popednode.positionX;
			nearYposition = popednode.positionY;
			
			//Reviso Arriba
			if ((posCuadraClienteX-2 == nearXposition && posCuadraClienteY == nearYposition) || (posCuadraClienteX == nearXposition && posCuadraClienteY-2 == nearYposition) 
			  || (posCuadraClienteX == nearXposition && posCuadraClienteY+2 == nearYposition) || (posCuadraClienteX+2 == nearXposition && posCuadraClienteY == nearYposition)){
				//Aqui encontramos el destino
				createPath(popednode);
				break;
			}
			
			verificarMovimientos2 (popednode);
			
		}
		
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
			
			if (posverificar != 't' && posverificar != ' ' && posverificar != '%' && posverificar != 'T' && posverificar != 'o' && posverificar != '*'){
				return 	posverificar;
			}
			
			contador++;
			j++;
		}
		
		return posverificar;
	}

	public static void verificarMovimientos(Node pNode){
		
		int NodeposX =  pNode.positionX;
		int NodeposY =  pNode.positionY;
		int Gcost = pNode.Gcost +1;
		
		//Arriba
		if (mapaciudad[NodeposX-1][NodeposY] != 'o' && mapaciudad[NodeposX-1][NodeposY] != '%' && NodeposX-1 >= 0 && mapaciudad[NodeposX-1][NodeposY] != '#' &&  checkinOpenList(NodeposX-1,NodeposY) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX-1,NodeposY);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX-1, NodeposY , Gcost );
				
			}
			
		}
		else if (mapaciudad[NodeposX-1][NodeposY] != 'o' && mapaciudad[NodeposX-1][NodeposY] != '%' && NodeposX-1 >= 0 && mapaciudad[NodeposX-1][NodeposY] != '#' && checkinCloseList(NodeposX-1,NodeposY) == false){
			Node nodeUp = new Node(NodeposX-1,NodeposY,Gcost,pNode);
			openlist.add(nodeUp);
		}
		
		
		//Izquierda
		if (mapaciudad[NodeposX][NodeposY-1] != 'o' && mapaciudad[NodeposX][NodeposY-1] != '%' && NodeposY-1 >= 0 && mapaciudad[NodeposX][NodeposY-1] != '#'  && checkinOpenList(NodeposX,NodeposY-1) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX,NodeposY-1);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX, NodeposY-1 , Gcost );
			}
			
		}
		else if (mapaciudad[NodeposX][NodeposY-1] != 'o' && mapaciudad[NodeposX][NodeposY-1] != '%' && NodeposY-1 >= 0 && mapaciudad[NodeposX][NodeposY-1] != '#' && checkinCloseList(NodeposX,NodeposY-1) == false){
			Node nodeLeft = new Node(NodeposX,NodeposY-1,Gcost,pNode);
			openlist.add(nodeLeft);
		
		}
		//Derecha
		if (mapaciudad[NodeposX][NodeposY+1] != 'o' && mapaciudad[NodeposX][NodeposY+1] != '%' && mapaciudad[NodeposX][NodeposY+1] != '#' && checkinOpenList(NodeposX,NodeposY+1) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX,NodeposY+1);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX, NodeposY+1 , Gcost );
			}
			
		}
		else if (mapaciudad[NodeposX][NodeposY+1] != 'o' && mapaciudad[NodeposX][NodeposY+1] != '%' && mapaciudad[NodeposX][NodeposY+1] != '#' && checkinCloseList(NodeposX,NodeposY+1) == false){
			Node nodeRight = new Node(NodeposX,NodeposY+1,Gcost,pNode);
			openlist.add(nodeRight);
		
		}
		
		//Abajo
		if (mapaciudad[NodeposX+1][NodeposY] != 'o' && mapaciudad[NodeposX+1][NodeposY] != '%' &&  mapaciudad[NodeposX+1][NodeposY] != '#' && checkinOpenList(NodeposX+1,NodeposY) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX+1,NodeposY);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX+1, NodeposY , Gcost );
			}
			
		}
		else if (mapaciudad[NodeposX+1][NodeposY] != 'o' && mapaciudad[NodeposX+1][NodeposY] != '%' && mapaciudad[NodeposX+1][NodeposY] != '#' && checkinCloseList(NodeposX+1,NodeposY) == false ){
			Node nodeDown= new Node(NodeposX+1,NodeposY,Gcost,pNode);
			openlist.add(nodeDown);
		
		}
		
	}
	
	public static void verificarMovimientos2(Node pNode){
		
		int NodeposX =  pNode.positionX;
		int NodeposY =  pNode.positionY;
		int Gcost = pNode.Gcost +1;
		
		//Arriba
		if (mapaciudad[NodeposX-1][NodeposY] != 'o' && mapaciudad[NodeposX-1][NodeposY] != '%' && NodeposX-1 >= 0 && mapaciudad[NodeposX-1][NodeposY] != '#' &&  checkinOpenList(NodeposX-1,NodeposY) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX-1,NodeposY);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX-1, NodeposY , Gcost );
				
			}
			
		}
		else if (mapaciudad[NodeposX-1][NodeposY] != 'o' && mapaciudad[NodeposX-1][NodeposY] != '%' && NodeposX-1 >= 0 && mapaciudad[NodeposX-1][NodeposY] != '#' && checkinCloseList(NodeposX-1,NodeposY) == false){
			Node nodeUp = new Node(NodeposX-1,NodeposY, posCuadraClienteX,posCuadraClienteY ,Gcost,pNode);
			openlist.add(nodeUp);
		}
		
		
		//Izquierda
		if (mapaciudad[NodeposX][NodeposY-1] != 'o' && mapaciudad[NodeposX][NodeposY-1] != '%' && NodeposY-1 >= 0 && mapaciudad[NodeposX][NodeposY-1] != '#'  && checkinOpenList(NodeposX,NodeposY-1) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX,NodeposY-1);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX, NodeposY-1 , Gcost );
			}
			
		}
		else if (mapaciudad[NodeposX][NodeposY-1] != 'o' && mapaciudad[NodeposX][NodeposY-1] != '%' && NodeposY-1 >= 0 && mapaciudad[NodeposX][NodeposY-1] != '#' && checkinCloseList(NodeposX,NodeposY-1) == false){
			Node nodeLeft = new Node(NodeposX,NodeposY-1, posCuadraClienteX,posCuadraClienteY ,Gcost,pNode);
			openlist.add(nodeLeft);
		
		}
		//Derecha
		if (mapaciudad[NodeposX][NodeposY+1] != 'o' && mapaciudad[NodeposX][NodeposY+1] != '%' && mapaciudad[NodeposX][NodeposY+1] != '#' && checkinOpenList(NodeposX,NodeposY+1) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX,NodeposY+1);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX, NodeposY+1 , Gcost );
			}
			
		}
		else if (mapaciudad[NodeposX][NodeposY+1] != 'o' && mapaciudad[NodeposX][NodeposY+1] != '%' && mapaciudad[NodeposX][NodeposY+1] != '#' && checkinCloseList(NodeposX,NodeposY+1) == false){
			Node nodeRight = new Node(NodeposX,NodeposY+1, posCuadraClienteX,posCuadraClienteY ,Gcost,pNode);
			openlist.add(nodeRight);
		
		}
		
		//Abajo
		if (mapaciudad[NodeposX+1][NodeposY] != 'o' && mapaciudad[NodeposX+1][NodeposY] != '%' &&  mapaciudad[NodeposX+1][NodeposY] != '#' && checkinOpenList(NodeposX+1,NodeposY) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX+1,NodeposY);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX+1, NodeposY , Gcost );
			}
			
		}
		else if (mapaciudad[NodeposX+1][NodeposY] != 'o' && mapaciudad[NodeposX+1][NodeposY] != '%' && mapaciudad[NodeposX+1][NodeposY] != '#' && checkinCloseList(NodeposX+1,NodeposY) == false ){
			Node nodeDown= new Node(NodeposX+1,NodeposY, posCuadraClienteX,posCuadraClienteY ,Gcost,pNode);
			openlist.add(nodeDown);
		
		}
		
	}
	
	public static void verificarMovimientos3(Node pNode){
		
		int NodeposX =  pNode.positionX;
		int NodeposY =  pNode.positionY;
		int Gcost = pNode.Gcost +1;
		
		//Arriba
		if (mapaciudad[NodeposX-1][NodeposY] != 'o' && mapaciudad[NodeposX-1][NodeposY] != '%' && NodeposX-1 >= 0 && mapaciudad[NodeposX-1][NodeposY] != '#' &&  checkinOpenList2(NodeposX-1,NodeposY) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList2(NodeposX-1,NodeposY);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent2(pNode ,NodeposX-1, NodeposY , Gcost );
				
			}
			
		}
		else if (mapaciudad[NodeposX-1][NodeposY] != 'o' && mapaciudad[NodeposX-1][NodeposY] != '%' && NodeposX-1 >= 0 && mapaciudad[NodeposX-1][NodeposY] != '#' && checkinCloseList2(NodeposX-1,NodeposY) == false){
			Node nodeUp = new Node(NodeposX-1,NodeposY,Gcost,pNode);
			openlist2.add(nodeUp);
		}
		
		
		//Izquierda
		if (mapaciudad[NodeposX][NodeposY-1] != 'o' && mapaciudad[NodeposX][NodeposY-1] != '%' && NodeposY-1 >= 0 && mapaciudad[NodeposX][NodeposY-1] != '#'  && checkinOpenList2(NodeposX,NodeposY-1) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList2(NodeposX,NodeposY-1);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent2(pNode ,NodeposX, NodeposY-1 , Gcost );
			}
			
		}
		else if (mapaciudad[NodeposX][NodeposY-1] != 'o' && mapaciudad[NodeposX][NodeposY-1] != '%' && NodeposY-1 >= 0 && mapaciudad[NodeposX][NodeposY-1] != '#' && checkinCloseList2(NodeposX,NodeposY-1) == false){
			Node nodeLeft = new Node(NodeposX,NodeposY-1,Gcost,pNode);
			openlist2.add(nodeLeft);
		
		}
		//Derecha
		if (mapaciudad[NodeposX][NodeposY+1] != 'o' && mapaciudad[NodeposX][NodeposY+1] != '%' && mapaciudad[NodeposX][NodeposY+1] != '#' && checkinOpenList2(NodeposX,NodeposY+1) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList2(NodeposX,NodeposY+1);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent2(pNode ,NodeposX, NodeposY+1 , Gcost );
			}
			
		}
		else if (mapaciudad[NodeposX][NodeposY+1] != 'o' && mapaciudad[NodeposX][NodeposY+1] != '%' && mapaciudad[NodeposX][NodeposY+1] != '#' && checkinCloseList2(NodeposX,NodeposY+1) == false){
			Node nodeRight = new Node(NodeposX,NodeposY+1,Gcost,pNode);
			openlist2.add(nodeRight);
		
		}
		
		//Abajo
		if (mapaciudad[NodeposX+1][NodeposY] != 'o' && mapaciudad[NodeposX+1][NodeposY] != '%' &&  mapaciudad[NodeposX+1][NodeposY] != '#' && checkinOpenList2(NodeposX+1,NodeposY) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList2(NodeposX+1,NodeposY);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent2(pNode ,NodeposX+1, NodeposY , Gcost );
			}
			
		}
		else if (mapaciudad[NodeposX+1][NodeposY] != 'o' && mapaciudad[NodeposX+1][NodeposY] != '%' && mapaciudad[NodeposX+1][NodeposY] != '#' && checkinCloseList2(NodeposX+1,NodeposY) == false ){
			Node nodeDown= new Node(NodeposX+1,NodeposY,Gcost,pNode);
			openlist2.add(nodeDown);
		
		}
		
	}
	
	public static void verificarMovimientos4(Node pNode){
		
		int NodeposX =  pNode.positionX;
		int NodeposY =  pNode.positionY;
		int Gcost = pNode.Gcost +1;
		
		//Arriba
		if (mapaciudad[NodeposX-1][NodeposY] != 'o' && mapaciudad[NodeposX-1][NodeposY] != '%' && NodeposX-1 >= 0 && mapaciudad[NodeposX-1][NodeposY] != '#' &&  checkinOpenList2(NodeposX-1,NodeposY) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList2(NodeposX-1,NodeposY);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent2(pNode ,NodeposX-1, NodeposY , Gcost );
				
			}
			
		}
		else if (mapaciudad[NodeposX-1][NodeposY] != 'o' && mapaciudad[NodeposX-1][NodeposY] != '%' && NodeposX-1 >= 0 && mapaciudad[NodeposX-1][NodeposY] != '#' && checkinCloseList2(NodeposX-1,NodeposY) == false){
			Node nodeUp = new Node(NodeposX-1,NodeposY, posCuadraClienteX2,posCuadraClienteY2 ,Gcost,pNode);
			openlist2.add(nodeUp);
		}
		
		
		//Izquierda
		if (mapaciudad[NodeposX][NodeposY-1] != 'o' && mapaciudad[NodeposX][NodeposY-1] != '%' && NodeposY-1 >= 0 && mapaciudad[NodeposX][NodeposY-1] != '#'  && checkinOpenList2(NodeposX,NodeposY-1) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList2(NodeposX,NodeposY-1);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent2(pNode ,NodeposX, NodeposY-1 , Gcost );
			}
			
		}
		else if (mapaciudad[NodeposX][NodeposY-1] != 'o' && mapaciudad[NodeposX][NodeposY-1] != '%' && NodeposY-1 >= 0 && mapaciudad[NodeposX][NodeposY-1] != '#' && checkinCloseList2(NodeposX,NodeposY-1) == false){
			Node nodeLeft = new Node(NodeposX,NodeposY-1, posCuadraClienteX2,posCuadraClienteY2 ,Gcost,pNode);
			openlist2.add(nodeLeft);
		
		}
		//Derecha
		if (mapaciudad[NodeposX][NodeposY+1] != 'o' && mapaciudad[NodeposX][NodeposY+1] != '%' && mapaciudad[NodeposX][NodeposY+1] != '#' && checkinOpenList2(NodeposX,NodeposY+1) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList2(NodeposX,NodeposY+1);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent2(pNode ,NodeposX, NodeposY+1 , Gcost );
			}
			
		}
		else if (mapaciudad[NodeposX][NodeposY+1] != 'o' && mapaciudad[NodeposX][NodeposY+1] != '%' && mapaciudad[NodeposX][NodeposY+1] != '#' && checkinCloseList2(NodeposX,NodeposY+1) == false){
			Node nodeRight = new Node(NodeposX,NodeposY+1, posCuadraClienteX2,posCuadraClienteY2,Gcost,pNode);
			openlist2.add(nodeRight);
		
		}
		
		//Abajo
		if (mapaciudad[NodeposX+1][NodeposY] != 'o' && mapaciudad[NodeposX+1][NodeposY] != '%' &&  mapaciudad[NodeposX+1][NodeposY] != '#' && checkinOpenList2(NodeposX+1,NodeposY) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList2(NodeposX+1,NodeposY);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent2(pNode ,NodeposX+1, NodeposY , Gcost );
			}
			
		}
		else if (mapaciudad[NodeposX+1][NodeposY] != 'o' && mapaciudad[NodeposX+1][NodeposY] != '%' && mapaciudad[NodeposX+1][NodeposY] != '#' && checkinCloseList2(NodeposX+1,NodeposY) == false ){
			Node nodeDown= new Node(NodeposX+1,NodeposY, posCuadraClienteX2,posCuadraClienteY2 ,Gcost,pNode);
			openlist2.add(nodeDown);
		
		}
		
	}
	
	public static Node popLowestNode(){
		
		Node lowestnode = new Node();
		Node temporal = new Node();
		
		int lowestcost = 0;
		int nodetoremove = 0;
		for (int i=0; i< openlist.size() ; i++){
			temporal = openlist.get(i);
			if (lowestcost == 0){
				lowestnode = temporal;
				lowestcost = temporal.Fvalue;
				nodetoremove = i;
			}
			else if (temporal.Fvalue < lowestcost ){
				lowestnode = temporal;	
				lowestcost = temporal.Fvalue;
				nodetoremove = i;
			}
				
		}
		openlist.remove(nodetoremove);
		return lowestnode;
	}
	
	public static Node popLowestNode2(){
		
		Node lowestnode = new Node();
		Node temporal = new Node();
		
		int lowestcost = 0;
		int nodetoremove = 0;
		for (int i=0; i< openlist2.size() ; i++){
			temporal = openlist2.get(i);
			if (lowestcost == 0){
				lowestnode = temporal;
				lowestcost = temporal.Fvalue;
				nodetoremove = i;
			}
			else if (temporal.Fvalue < lowestcost ){
				lowestnode = temporal;	
				lowestcost = temporal.Fvalue;
				nodetoremove = i;
			}
				
		}
		openlist2.remove(nodetoremove);
		return lowestnode;
	}
	
	
	public static Node getNodeinOpenList(int pNodeXpos , int pNodeYpos){
		
		Node specificnode = new Node();
		Node temporal = new Node();

		for (int i=0; i< openlist.size() ; i++){
			temporal = openlist.get(i);
			if (temporal.positionX == pNodeXpos && temporal.positionY == pNodeYpos ){
				specificnode = temporal;
				return specificnode;
			}
				
		}
		return specificnode;
		
	}
	
	
	public static Node getNodeinOpenList2(int pNodeXpos , int pNodeYpos){
		
		Node specificnode = new Node();
		Node temporal = new Node();

		for (int i=0; i< openlist2.size() ; i++){
			temporal = openlist2.get(i);
			if (temporal.positionX == pNodeXpos && temporal.positionY == pNodeYpos ){
				specificnode = temporal;
				return specificnode;
			}
				
		}
		return specificnode;
		
	}
	
	public static boolean revisarCuadra(char pCuadra){
		
		
		boolean incuadraList = false;
		for (int i=0; i< cuadrasvisitadas.size() ; i++){
			char cuadra = cuadrasvisitadas.get(i);
			if (cuadra == pCuadra){
				incuadraList = true;
				return incuadraList;
			}
				
		}
		return incuadraList;
	}
	
	public static boolean revisarCuadra2(char pCuadra){
		
		
		boolean incuadraList = false;
		for (int i=0; i< cuadrasvisitadas2.size() ; i++){
			char cuadra = cuadrasvisitadas2.get(i);
			if (cuadra == pCuadra){
				incuadraList = true;
				return incuadraList;
			}
				
		}
		return incuadraList;
	}
	
	public static boolean checkinCloseList(int pNodeXpos , int pNodeYpos){
		
		Node temporal = new Node();
		
		boolean isInCloseList = false;
		for (int i=0; i< closelist.size() ; i++){
			temporal = closelist.get(i);
			if (temporal.positionX == pNodeXpos && temporal.positionY == pNodeYpos ){
				isInCloseList = true;
				return isInCloseList;
			}
				
		}
		return isInCloseList;
	}
	
	public static boolean checkinCloseList2(int pNodeXpos , int pNodeYpos){
		
		Node temporal = new Node();
		
		boolean isInCloseList = false;
		for (int i=0; i< closelist2.size() ; i++){
			temporal = closelist2.get(i);
			if (temporal.positionX == pNodeXpos && temporal.positionY == pNodeYpos ){
				isInCloseList = true;
				return isInCloseList;
			}
				
		}
		return isInCloseList;
	}
	
	public static boolean checkinOpenList(int pNodeXpos , int pNodeYpos){
		
		Node temporal = new Node();
		
		boolean checkinOpenList = false;
		for (int i=0; i< openlist.size() ; i++){
			temporal = openlist.get(i);
			if (temporal.positionX == pNodeXpos && temporal.positionY == pNodeYpos ){
				checkinOpenList = true;
				return checkinOpenList;
			}
				
		}
		return checkinOpenList;
	}
	
	public static boolean checkinOpenList2(int pNodeXpos , int pNodeYpos){
			
			Node temporal = new Node();
			
			boolean checkinOpenList = false;
			for (int i=0; i< openlist2.size() ; i++){
				temporal = openlist2.get(i);
				if (temporal.positionX == pNodeXpos && temporal.positionY == pNodeYpos ){
					checkinOpenList = true;
					return checkinOpenList;
				}
					
			}
			return checkinOpenList;
	}
	
	public static void changeParent(Node pNode , int pNodeposXnew, int pNodeposYnew , int pGcost){
		
		Node temporal = new Node(); 
		
		for (int i=0; i< openlist.size() ; i++){
			temporal = openlist.get(i);
			if (temporal.positionX == pNodeposXnew && temporal.positionY == pNodeposYnew ){
				
				Node newnode = new Node(temporal.positionX, temporal.positionY,pGcost,pNode );
				openlist.set(i, newnode);
				break;
			}
				
		}
			
	}
	
	public static void changeParent2(Node pNode , int pNodeposXnew, int pNodeposYnew , int pGcost){
		
		Node temporal = new Node(); 
		
		for (int i=0; i< openlist2.size() ; i++){
			temporal = openlist2.get(i);
			if (temporal.positionX == pNodeposXnew && temporal.positionY == pNodeposYnew ){
				
				Node newnode = new Node(temporal.positionX, temporal.positionY,pGcost,pNode );
				openlist2.set(i, newnode);
				break;
			}
				
		}
			
	}
	
	//ESTE METODO CREA EL CAMINO
	public static void createPath(Node pnode){
		
		Node temporal = new Node();
		temporal = pnode;
		while (temporal.Parent != null){
			
			System.out.println(temporal.positionX + " - "+temporal.positionY);
			path.add(temporal.positionX);
			path.add(temporal.positionY);
			temporal = temporal.Parent;
			
		}
		path.add(temporal.positionX);
		path.add(temporal.positionY);
		System.out.println(temporal.positionX + " - "+temporal.positionY);
	}
	
	public static void createPath2(Node pnode){
		
		Node temporal = new Node();
		temporal = pnode;
		while (temporal.Parent != null){
			
			System.out.println(temporal.positionX + " - "+temporal.positionY);
			path2.add(temporal.positionX);
			path2.add(temporal.positionY);
			temporal = temporal.Parent;
			
		}
		path2.add(temporal.positionX);
		path2.add(temporal.positionY);
		System.out.println(temporal.positionX + " - "+temporal.positionY);
	}
	
	public static void printCiudad(){
		
		   int i = 0;
		   int j = 0;
	       for( i = 0; i< ciudadfilas1; i++){
	    	   for ( j = 0 ; j< ciudadcolumnas1; j++){
	    		   System.out.print(mapaciudad[i][j]);
	    	   }
	    	   System.out.println(" ");
	       }
	       

	       for( i = 16; i< ciudadfilas2; i++){
	    	   for ( j = 0 ; j< ciudadcolumnas2; j++){
	    		   
	    		   if (mapaciudad[i][j] == '0'){
	    			   System.out.print(" ");
	    			   
	    		   }else{
	    			   System.out.print(mapaciudad[i][j]);
	    		   }
	    	   }
	    	   System.out.println(" ");
	       }
			
		
		}
		
		public static int[] buscarTaxipos(){
			
		   int posX = 0;
		   int posY = 0;
		   int i = 0;
		   int j = 0;
	       for( i = 0; i< ciudadfilas1; i++){
	    	   for ( j = 0 ; j< ciudadcolumnas1; j++){
	    		   if (mapaciudad[i][j] == 'T'){
	    			   posX = i;
	    			   posY = j;
	    		   }
	    	   }
	       }
	       

	       for( i = 16; i< ciudadfilas2; i++){
	    	   for ( j = 0 ; j< ciudadcolumnas2; j++){
	    		   if (mapaciudad[i][j] == 'T'){
	    			   posX = i;
	    			   posY = j;
	    		   }
	    	   }
	       }
		
	       return new int[] {posX, posY};
		}
		
		public static int[] buscarTaxipos2(){
			
			   int posX = 0;
			   int posY = 0;
			   int i = 0;
			   int j = 0;
		       for( i = 0; i< ciudadfilas1; i++){
		    	   for ( j = 0 ; j< ciudadcolumnas1; j++){
		    		   if (mapaciudad[i][j] == 't'){
		    			   posX = i;
		    			   posY = j;
		    		   }
		    	   }
		       }
		       

		       for( i = 16; i< ciudadfilas2; i++){
		    	   for ( j = 0 ; j< ciudadcolumnas2; j++){
		    		   if (mapaciudad[i][j] == 't'){
		    			   posX = i;
		    			   posY = j;
		    		   }
		    	   }
		       }
			
		       return new int[] {posX, posY};
			}
		
		public static void cargarCuadras(){
			
		   int i = 0;
		   int j = 0;
		   char posverificar;
		   for( i = 0; i< ciudadfilas1; i++){
			   for ( j = 0 ; j< ciudadcolumnas1; j++){
				   
				   posverificar = mapaciudad[i][j];
					
					if (posverificar != 't' && posverificar != ' ' && posverificar != '%' && posverificar != 'T' && posverificar != 'o' && posverificar != '*' && posverificar != '#' && posverificar != '0'){
						listacuadras.add(posverificar);
					}

			   }
		   }
		   
		
		   for( i = 16; i< ciudadfilas2; i++){
			   for ( j = 0 ; j< ciudadcolumnas2; j++){
				   posverificar = mapaciudad[i][j];
					
					if (posverificar != 't' && posverificar != ' ' && posverificar != '%' && posverificar != 'T' && posverificar != 'o' && posverificar != '*' && posverificar != '#' && posverificar != '0'){
						listacuadras.add(posverificar);
					}
			   }
		   }
			
		}
		
		/*-------------------------------------------------------------------------------------------*/
		/*---------------------   C A M B I O S  -------------------------------------------------- */
		/*-------------------------------------------------------------------------------------------*/
		
		
		public static void Taxi2(){

			mapaciudad[21][1] = 't';
			Taxi2.setPosX(21);
			Taxi2.setPosY(1);
			Taxi2.setNombre("Taxi 2");
			
		}
		
		public static void Pasear2 () throws InterruptedException{
			
			path2.clear();
		    openlist2.clear();
		    closelist2.clear();
		    cuadrasvisitadas2.clear();
			
			int posiciones[] = buscarTaxipos2();
			int posicionX = posiciones[0];
			int posicionY = posiciones[1];
			
			Taxi2.setPosX(posicionX);
			Taxi2.setPosY(posicionY);
			//Taxi Taxi = new Taxi(posicionX,posicionY,0);
			Taxi2.estado = "Paseando";
			
			while (Taxi2.estado == "Paseando"){
				

				encontrarCuadra2();
				
				System.out.println("Cuadra visitada:"+cvisitada);
				String movimiento = "";
				
				//REMUEVO LA POSICION ACTUAL DEL T QUE NO NECESITO
				path2.removeLast();
				path2.removeLast();
				while (path2.size() != 0 ){
					
					int nuevaposY = path2.getLast();
					path2.removeLast();
					int nuevaposX = path2.getLast();
					path2.removeLast();
					
					if (nuevaposX > posicionX){
						movimiento = "Abajo";
					}
					else if(nuevaposX < posicionX){
						movimiento = "Arriba";
					}
		            else if(nuevaposY > posicionY){
		            	movimiento = "Derecha";
					}
		            else if(nuevaposY < posicionY){
		            	movimiento = "Izquierda";
					}
					
					if (mostrar2 == true){
						limpiarNumeros();
					}
					moverTaxi2(nuevaposX,nuevaposY,movimiento);
					
					posicionX = nuevaposX;
					posicionY = nuevaposY;
					//moverTaxiMarcando(nuevaposX,nuevaposY,movimiento);
					Thread.sleep((long) tiempoespera);
				}
				/*
				if (mostrar2 == true){
					limpiarNumeros();
				}
				else if (mostrar2 == false){
					limpiarCamino();
				}
				*/
				int posiciones2[] = buscarTaxipos2();
				posicionX = posiciones2[0];
				posicionY = posiciones2[1];
				
				System.out.println("PASEANDO");
				System.out.println("Pos TAXI X: "+posicionX);
				System.out.println("Pos TAXI Y: "+posicionY);
				Taxi2.setPosX(posicionX);
				Taxi2.setPosY(posicionY);
			    path2.clear();
			    openlist2.clear();
			    closelist2.clear();
				
			}
		}
		
		public static void Buscar2 () throws InterruptedException{
			
			
			Taxi2.estado = "Buscar";	

			path2.clear();
		    openlist2.clear();
		    closelist2.clear();
		    cuadrasvisitadas2.clear();
		    
			int posiciones[] = buscarTaxipos2();
			int posicionX = posiciones[0];
			int posicionY = posiciones[1];
			
			Taxi2.setPosX(posicionX);
			Taxi2.setPosY(posicionY);
			
			
			while (Taxi2.estado == "Buscar"){
				
				encontrarCuadra2();
				
				System.out.println("Cuadra visitada:"+cvisitada);
				String movimiento = "";
				
				//REMUEVO LA POSICION ACTUAL DEL T QUE NO NECESITO
				path2.removeLast();
				path2.removeLast();
				while (path2.size() != 0 ){
					
					int nuevaposY = path2.getLast();
					path2.removeLast();
					int nuevaposX = path2.getLast();
					path2.removeLast();
					
					if (nuevaposX > posicionX){
						movimiento = "Abajo";
					}
					else if(nuevaposX < posicionX){
						movimiento = "Arriba";
					}
		            else if(nuevaposY > posicionY){
		            	movimiento = "Derecha";
					}
		            else if(nuevaposY < posicionY){
		            	movimiento = "Izquierda";
					}	
					moverTaxiBuscando2(nuevaposX,nuevaposY,movimiento);
					posicionX = nuevaposX;
					posicionY = nuevaposY;
					//moverTaxiMarcando(nuevaposX,nuevaposY,movimiento);
					Thread.sleep((long) tiempoespera);
				}
				int posiciones2[] = buscarTaxipos2();
				posicionX = posiciones2[0];
				posicionY = posiciones2[1];
				
				System.out.println("BUSCANDO Taxi 2");
				System.out.println("Pos TAXI2 X: "+posicionX);
				System.out.println("Pos TAXI2 Y: "+posicionY);
				Taxi2.setPosX(posicionX);
				Taxi2.setPosY(posicionY);
			    path2.clear();
			    openlist2.clear();
			    closelist2.clear();
		
			
			}
		}
		
		public static void encontrarCuadra2(){
			
			//Esta es la cola FIFO
			
			int posinicialX = Taxi2.getPosX();
			int posinicialY = Taxi2.getPosY();
			
			Node initialnode = new Node(posinicialX,posinicialY,0);
			
			verificarMovimientos3 (initialnode);
			closelist2.add(initialnode);
			int nearXposition = initialnode.positionX;
			int nearYposition = initialnode.positionY;
			boolean notfound = true;
			while(notfound){
				
				Node popednode = openlist2.getFirst();
				openlist2.removeFirst();
				closelist2.add(popednode);
				nearXposition = popednode.positionX;
				nearYposition = popednode.positionY;

				//Reviso que esten cerca de la cuadra
				//ARRIBA
				if ( mapaciudad[nearXposition-1][nearYposition] == '%' || mapaciudad[nearXposition-1][nearYposition] == 'o'){
					//Aqui encontramos el destino
					
					char nombrecuadra =  buscarCuadra(nearXposition-1,nearYposition);
					boolean cuadravisitada = revisarCuadra2(nombrecuadra);
					if (cuadravisitada == false){
						cvisitada = nombrecuadra;
						cuadrasvisitadas2.add(nombrecuadra);
						
						if (cuadrasvisitadas2.size() == 39 ){
							cuadrasvisitadas2.clear();
							cuadrasvisitadas2.add(nombrecuadra);
						}
						createPath2(popednode);
						break;
						
					}
					
				}
				//ABAJO
				else if (mapaciudad[nearXposition+1][nearYposition] == '%' || mapaciudad[nearXposition+1][nearYposition] == 'o'){
					
					char nombrecuadra = buscarCuadra(nearXposition+1,nearYposition);
					boolean cuadravisitada = revisarCuadra2(nombrecuadra);
					if (cuadravisitada == false){
						cvisitada = nombrecuadra;
						cuadrasvisitadas2.add(nombrecuadra);
						
						if (cuadrasvisitadas2.size() == 39 ){
							cuadrasvisitadas2.clear();
							cuadrasvisitadas2.add(nombrecuadra);
						}
						
						createPath2(popednode);
						break;
						
					}
					
				}
				//DERECHA
				else if (mapaciudad[nearXposition][nearYposition+1] == '%' || mapaciudad[nearXposition][nearYposition+1] == 'o'){
					
					char nombrecuadra =  buscarCuadra(nearXposition,nearYposition+1);
					boolean cuadravisitada = revisarCuadra2(nombrecuadra);
					if (cuadravisitada == false){
						cvisitada = nombrecuadra;
						cuadrasvisitadas2.add(nombrecuadra);
						
						if (cuadrasvisitadas2.size() == 39 ){
							cuadrasvisitadas2.clear();
							cuadrasvisitadas2.add(nombrecuadra);
						}
						
						createPath2(popednode);
						break;
						
					}
					
				}
				//IZQUIERDA
				else if (mapaciudad[nearXposition][nearYposition-1] == '%' || mapaciudad[nearXposition][nearYposition-1] == 'o' ){
					
					char nombrecuadra =  buscarCuadra(nearXposition,nearYposition-1);
					boolean cuadravisitada = revisarCuadra2(nombrecuadra);
					if (cuadravisitada == false){
						cvisitada = nombrecuadra;
						cuadrasvisitadas2.add(nombrecuadra);
						
						if (cuadrasvisitadas2.size() == 39 ){
							cuadrasvisitadas2.clear();
							cuadrasvisitadas2.add(nombrecuadra);
						}
						
						createPath2(popednode);
						break;
						
					}
					
				}
				

				verificarMovimientos3 (popednode);
				
				
			}
			
			
			
		}
	
		private static void moverTaxiBuscando2(int posX, int posY, String movimiento) throws InterruptedException {
			
			
			if (movimiento == "Derecha"){
				mapaciudad[posX][posY-1] = ' ';
			}
			else if (movimiento == "Izquierda"){
				mapaciudad[posX][posY+1] = ' ';
			}
			else if (movimiento == "Abajo"){
				mapaciudad[posX-1][posY] = ' ';		
			}
			else if (movimiento == "Arriba"){
				mapaciudad[posX+1][posY] = ' ';
			}
			
			mapaciudad[posX][posY] = 't';
			//Busca Clientes
			if(buscarCliente(posX,posY)){
				
				int posiciones[] = buscarClientePos(posX,posY);
				int clienteX = posiciones[0];
				int clienteY = posiciones[1];
				
				recogerCliente2(clienteX,clienteY);
				Taxi.estado = "Buscar";
			    removerCliente(clienteX, clienteY);
			    Buscar();
				
			}
		}
		
	    private static void recogerCliente2(int clienteX, int clienteY) throws InterruptedException {
			
	    	mapaciudad[clienteX][clienteY] = '%';
	    	char destino = clienteDestino(clienteX,clienteY);
	    	
	    	System.out.println("DESTINO CLIENTE : "+destino);
	    	
	    	int posiciones[] = buscarCuadraPos(destino);
	    	posCuadraClienteX2 = posiciones[0];
	    	posCuadraClienteY2 = posiciones[1];
	    	
	    	System.out.println("CUADRA Cliente X : "+posCuadraClienteX);
	    	System.out.println("CUADRA Cliente Y : "+posCuadraClienteY);
	    	
	    	path2.clear();
		    openlist2.clear();
		    closelist2.clear();
		    cuadrasvisitadas2.clear();
		    
			int posiciones2[] = buscarTaxipos2();
			int posicionX = posiciones2[0];
			int posicionY = posiciones2[1];
			
			Taxi2.setPosX(posicionX);
			Taxi2.setPosY(posicionY);
	    	
	    	Taxi2.estado = "Ocupado";
	    	
			encontrarCuadraCliente2(Taxi);
			
			System.out.println("Cuadra visitada:"+cvisitada);
			String movimiento = "";
			
			//REMUEVO LA POSICION ACTUAL DEL T QUE NO NECESITO
			path2.removeLast();
			path2.removeLast();
			while (path2.size() != 0 ){
				
				int nuevaposY = path2.getLast();
				path2.removeLast();
				int nuevaposX = path2.getLast();
				path2.removeLast();
				
				if (nuevaposX > posicionX){
					movimiento = "Abajo";
				}
				else if(nuevaposX < posicionX){
					movimiento = "Arriba";
				}
	            else if(nuevaposY > posicionY){
	            	movimiento = "Derecha";
				}
	            else if(nuevaposY < posicionY){
	            	movimiento = "Izquierda";
				}
				
				if (mostrar2 == true){
					limpiarNumeros();
				}
				moverTaxi2(nuevaposX,nuevaposY,movimiento);

				posicionX = nuevaposX;
				posicionY = nuevaposY;
				//moverTaxiMarcando(nuevaposX,nuevaposY,movimiento);
				Thread.sleep((long) tiempoespera);
			}
			/*
			if (mostrar2 == true){
				limpiarNumeros();
			}
			else if (mostrar2 == false){
				limpiarCamino();
			}
			*/
			int posiciones3[] = buscarTaxipos2();
			posicionX = posiciones3[0];
			posicionY = posiciones3[1];
			
			System.out.println("BUSCANDO");
			System.out.println("Pos TAXI X: "+posicionX);
			System.out.println("Pos TAXI Y: "+posicionY);
			Taxi2.setPosX(posicionX);
			Taxi2.setPosY(posicionY);
		    path2.clear();
		    openlist2.clear();
		    closelist2.clear();

			
		}
	    
	    public static void encontrarCuadraCliente2 (Taxi taxi){
			
			int posinicialX = taxi.getPosX();
			int posinicialY = taxi.getPosY();
			
			path2.clear();
		    openlist2.clear();
		    closelist2.clear();
		    cuadrasvisitadas2.clear();
			
			Node initialnode = new Node(posinicialX,posinicialY,0,posCuadraClienteX2,posCuadraClienteY2);
			verificarMovimientos4 (initialnode);
			
			closelist2.add(initialnode);
			int nearXposition = initialnode.positionX;
			int nearYposition = initialnode.positionY;
			boolean notfound = true;
			while(notfound){
				
				Node popednode = popLowestNode2();
				closelist2.add(popednode);
				nearXposition = popednode.positionX;
				nearYposition = popednode.positionY;
				
				//Reviso Arriba
				if ((posCuadraClienteX2-2 == nearXposition && posCuadraClienteY2 == nearYposition) || (posCuadraClienteX2 == nearXposition && posCuadraClienteY2-2 == nearYposition) 
				  || (posCuadraClienteX2 == nearXposition && posCuadraClienteY2+2 == nearYposition) || (posCuadraClienteX2+2 == nearXposition && posCuadraClienteY2 == nearYposition)){
					//Aqui encontramos el destino
					createPath2(popednode);
					break;
				}
				
				verificarMovimientos4 (popednode);
				
			}
			
		}
	    
	    private static void moverTaxi2(int posX, int posY, String movimiento) {
			
			
			if (mostrar2 == false){
			
				if (movimiento == "Derecha"){
					mapaciudad[posX][posY-1] = ' ';
				}
				else if (movimiento == "Izquierda"){
					mapaciudad[posX][posY+1] = ' ';
				}
				else if (movimiento == "Abajo"){
					mapaciudad[posX-1][posY] = ' ';		
				}
				else if (movimiento == "Arriba"){
					mapaciudad[posX+1][posY] = ' ';
				}
				
				mapaciudad[posX][posY] = 't';
			
			}
			else{
				
				if (movimiento == "Derecha"){
					mapaciudad[posX][posY-1] = '*';
				}
				else if (movimiento == "Izquierda"){
					mapaciudad[posX][posY+1] = '*';
				}
				else if (movimiento == "Abajo"){
					mapaciudad[posX-1][posY] = '*';		
				}
				else if (movimiento == "Arriba"){
					mapaciudad[posX+1][posY] = '*';
				}
				
				mapaciudad[posX][posY] = 't';
				
				int nextY = 0;
				int nextX = 0;
				if (path2.size() != 0){
					nextY = path2.getLast();
					path2.removeLast();
					nextX = path.getLast();
					path2.removeLast();
					
					listamostrar2.add(nextX);
					listamostrar2.add(nextY);
					
					path2.addLast(nextX);
					path2.addLast(nextY);
				}
				
				if (nextX > posX){
					movimiento = "Abajo";
				}
				else if(nextX < posX){
					movimiento = "Arriba";
				}
	            else if(nextY > posY){
	            	movimiento = "Derecha";
				}
	            else if(nextY < posY){
	            	movimiento = "Izquierda";
				}	
				
				int cantidadcaminos = 1;
				
				if ( mapaciudad[nextX][nextY] == ' '){
					mapaciudad[nextX][nextY] = '1';
					cantidadcaminos++;
				}
				
				if (mapaciudad[posX+1][posY] == ' ' && movimiento != "Abajo"){

					char cant = (char)(cantidadcaminos + '0');
					mapaciudad[posX+1][posY] = cant;
					listamostrar2.add(posX+1);
					listamostrar2.add(posY);
					cantidadcaminos++;
				}
				
				if (mapaciudad[posX-1][posY] == ' ' && movimiento != "Arriba"){
					char cant = (char)(cantidadcaminos + '0');
					mapaciudad[posX-1][posY] = cant;
					listamostrar2.add(posX-1);
					listamostrar2.add(posY);
					cantidadcaminos++;
				}
				
				if (mapaciudad[posX][posY+1] == ' ' && movimiento != "Derecha"){
					char cant = (char)(cantidadcaminos + '0');
					mapaciudad[posX][posY+1] = cant;
					listamostrar2.add(posX);
					listamostrar2.add(posY+1);
					cantidadcaminos++;
				}
				
				if (mapaciudad[posX][posY-1] == ' ' && movimiento != "Izquierda"){
					char cant = (char)(cantidadcaminos + '0');
					mapaciudad[posX][posY-1] = cant;
					listamostrar2.add(posX);
					listamostrar2.add(posY-1);
					cantidadcaminos++;
				}
				
			}
		}
}
