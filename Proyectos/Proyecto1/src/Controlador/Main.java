package Controlador;

import java.util.LinkedList;





public class Main {

	static int ciudadfilas1 = 16;
	static int ciudadcolumnas1 = 31;

	static int ciudadfilas2 = 23;
	static int ciudadcolumnas2 = 54;
	
	static LinkedList<Integer> path =new LinkedList<Integer>();  
    static LinkedList<Node> openlist =new LinkedList<Node>();  
    static LinkedList<Node> closelist =new LinkedList<Node>();
    
    static LinkedList<Character> cuadrasvisitadas =new LinkedList<Character>(); 
	
	static char mapaciudad[][] = {{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
						   {'#',' ','T',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
						   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'},
						   {'#',' ','%','A','%',' ','%','B','%',' ','%','C','%',' ','%','D','%',' ','%','E','%',' ','%','F','%',' ','%','G','%',' ','#'},
						   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'},
						   {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
						   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'},
						   {'#',' ','%','H','%',' ','%','I','%',' ','%','J','%',' ','%','K','%',' ','%','L','%',' ','%','M','%',' ','%','N','%',' ','#'},
						   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'},
						   {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
						   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'},
						   {'#',' ','%','O','%',' ','%','P','%',' ','%','Q','%',' ','%','R','%',' ','%','S','%',' ','%','+','%',' ','%','U','%',' ','#'},
						   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'},
						   {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
						   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'},
						   {'#',' ','%','V','%',' ','%','W','%',' ','%','X','%',' ','%','Y','%',' ','%','Z','%',' ','%','1','%',' ','%','2','%',' ','#'},
						   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#','0','0','0','0','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}, 
						   {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','0','0','0','0','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
						   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#','#','#','#','#','#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'}, 
						   {'#',' ','%','3','%',' ','%','4','%',' ','%','5','%',' ','%','6','%',' ','%','7','%',' ','%','8','%',' ','%','9','%',' ',' ',' ',' ',' ',' ',' ',' ','%','a','%',' ','%','b','%',' ','%','c','%',' ','%','d','%',' ','#'},
						   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#','#','#','#','#','#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'},
						   {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','0','0','0','0','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
						   {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','0','0','0','0','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}};
	
	static char cvisitada;
	
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

	public static void Pasear (){
		
		int posiciones[] = buscarTaxipos();
		int posicionX = posiciones[0];
		int posicionY = posiciones[1];
		
		Taxi taxiinicial = new Taxi(posicionX,posicionY,0);
		cuadrasvisitadas.add('A');
		encontrarCuadra(taxiinicial);
		
		System.out.println("Cuadra visitada:"+cvisitada);
		
		/*
		
		taxiinicial.MoverDerecha();
		
		int posX = taxiinicial.getPosX();
		int posY = taxiinicial.getPosY();
		moverTaxi(posX,posY,"Derecha");
		*/
		
		
	}
	
	private static void moverTaxi(int posX, int posY, String movimiento) {
		
		mapaciudad[posX][posY] = 'T';
		
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
		
	}

	public static void Buscar (){
		
		
	}
	
	public static void Mostrar (boolean pEstado){
		
		
	}
	
	
	public static void Animar (int pNanosegundos) throws InterruptedException{
		
		
		while (true){

			if (pNanosegundos == 0){
				printCiudad();
				break;
			}
			printCiudad();
			Thread.sleep(pNanosegundos*1000);
		}
		
	}
	
	public static void Ruta (boolean pEstado){
		
		
	}

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
			if ( mapaciudad[nearXposition-1][nearYposition] == '%'){
				//Aqui encontramos el destino
				
				char nombrecuadra =  buscarCuadra(nearXposition-1,nearYposition);
				boolean cuadravisitada = revisarCuadra(nombrecuadra);
				if (cuadravisitada == false){
					cvisitada = nombrecuadra;
					cuadrasvisitadas.add(nombrecuadra);
					createPath(popednode);
					break;
					
				}
				
			}
			//ABAJO
			else if (mapaciudad[nearXposition+1][nearYposition] == '%'){
				
				char nombrecuadra = buscarCuadra(nearXposition+1,nearYposition);
				boolean cuadravisitada = revisarCuadra(nombrecuadra);
				if (cuadravisitada == false){
					cvisitada = nombrecuadra;
					cuadrasvisitadas.add(nombrecuadra);
					createPath(popednode);
					break;
					
				}
				
			}
			//IZQUIERDA
			else if (mapaciudad[nearXposition][nearYposition-1] == '%' ){
				
				char nombrecuadra =  buscarCuadra(nearXposition,nearYposition-1);
				boolean cuadravisitada = revisarCuadra(nombrecuadra);
				if (cuadravisitada == false){
					cvisitada = nombrecuadra;
					cuadrasvisitadas.add(nombrecuadra);
					createPath(popednode);
					break;
					
				}
				
			}
			//DERECHA
			else if (mapaciudad[nearXposition][nearYposition+1] == '%'){
				
				char nombrecuadra =  buscarCuadra(nearXposition,nearYposition+1);
				boolean cuadravisitada = revisarCuadra(nombrecuadra);
				if (cuadravisitada == false){
					cvisitada = nombrecuadra;
					cuadrasvisitadas.add(nombrecuadra);
					createPath(popednode);
					break;
					
				}
				
			}

			verificarMovimientos (popednode);
			
			
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
			
			if (posverificar != ' ' && posverificar != '%' && posverificar != 'T' && posverificar != 'o'){
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
		if (mapaciudad[NodeposX-1][NodeposY] != '%' && NodeposX-1 >= 0 && mapaciudad[NodeposX-1][NodeposY] != '#' &&  checkinOpenList(NodeposX-1,NodeposY) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX-1,NodeposY);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX-1, NodeposY , Gcost );
				
			}
			
		}
		else if (mapaciudad[NodeposX-1][NodeposY] != '%' && NodeposX-1 >= 0 && mapaciudad[NodeposX-1][NodeposY] != '#' && checkinCloseList(NodeposX-1,NodeposY) == false){
			Node nodeUp = new Node(NodeposX-1,NodeposY,Gcost,pNode);
			openlist.add(nodeUp);
		}
		
		
		//Izquierda
		if ( mapaciudad[NodeposX][NodeposY-1] != '%' && NodeposY-1 >= 0 && mapaciudad[NodeposX][NodeposY-1] != '#'  && checkinOpenList(NodeposX,NodeposY-1) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX,NodeposY-1);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX, NodeposY-1 , Gcost );
			}
			
		}
		else if ( mapaciudad[NodeposX][NodeposY-1] != '%' && NodeposY-1 >= 0 && mapaciudad[NodeposX][NodeposY-1] != '#' && checkinCloseList(NodeposX,NodeposY-1) == false){
			Node nodeLeft = new Node(NodeposX,NodeposY-1,Gcost,pNode);
			openlist.add(nodeLeft);
		
		}
		//Derecha
		if (mapaciudad[NodeposX][NodeposY+1] != '%' && mapaciudad[NodeposX][NodeposY+1] != '#' && checkinOpenList(NodeposX,NodeposY+1) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX,NodeposY+1);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX, NodeposY+1 , Gcost );
			}
			
		}
		else if (mapaciudad[NodeposX][NodeposY+1] != '%' && mapaciudad[NodeposX][NodeposY+1] != '#' && checkinCloseList(NodeposX,NodeposY+1) == false){
			Node nodeRight = new Node(NodeposX,NodeposY+1,Gcost,pNode);
			openlist.add(nodeRight);
		
		}
		
		//Abajo
		if (mapaciudad[NodeposX+1][NodeposY] != '%' &&  mapaciudad[NodeposX+1][NodeposY] != '#' && checkinOpenList(NodeposX+1,NodeposY) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX+1,NodeposY);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX+1, NodeposY , Gcost );
			}
			
		}
		else if (mapaciudad[NodeposX+1][NodeposY] != '%' && mapaciudad[NodeposX+1][NodeposY] != '#' && checkinCloseList(NodeposX+1,NodeposY) == false ){
			Node nodeDown= new Node(NodeposX+1,NodeposY,Gcost,pNode);
			openlist.add(nodeDown);
		
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
	
}
