package Controlador;

import java.util.LinkedList;

import Pacman.pacman_astar;
import Pacman.pacman_astar.node;




public class Main {

	static int ciudadfilas1 = 16;
	static int ciudadcolumnas1 = 31;

	static int ciudadfilas2 = 23;
	static int ciudadcolumnas2 = 54;
	
	static LinkedList<Integer> path =new LinkedList<Integer>();  
    static LinkedList<Node> openlist =new LinkedList<Node>();  
    static LinkedList<Node> closelist =new LinkedList<Node>();
	
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
						   {'#',' ','%','O','%',' ','%','P','%',' ','%','Q','%',' ','%','R','%',' ','%','S','%',' ','%','T','%',' ','%','U','%',' ','#'},
						   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'},
						   {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
						   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'},
						   {'#',' ','%','V','%',' ','%','W','%',' ','%','X','%',' ','%','Y','%',' ','%','Z','%',' ','%','1','%',' ','%','2','%',' ','#'},
						   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#','0','0','0','0','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}, 
						   {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','0','0','0','0','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
						   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#','#','#','#','#','#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'}, 
						   {'#',' ','%','3','%',' ','%','4','%',' ','%','5','%',' ','%','6','%',' ','%','7','%',' ','%','8','%',' ','%','9','%',' ',' ',' ',' ',' ',' ',' ',' ','%','@','%',' ','%','?','%',' ','%','$','%',' ','%','&','%',' ','#'},
						   {'#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#','#','#','#','#','#',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','%','%','%',' ','#'},
						   {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','0','0','0','0','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
						   {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','0','0','0','0','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}};
	

	
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
		taxiinicial.MoverDerecha();
		
		int posX = taxiinicial.getPosX();
		int posY = taxiinicial.getPosY();
		moverTaxi(posX,posY,"Derecha");
		
		
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
			
			Node popednode = popLowestNode();
			closelist.add(popednode);
			nearXposition = popednode.positionX;
			nearYposition = popednode.positionY;
			
		
			
			//Reviso Arriba
			if ((foodX-1 == nearXposition && foodY == nearYposition) || (foodX == nearXposition && foodY-1 == nearYposition) 
			  || (foodX == nearXposition && foodY+1 == nearYposition) || (foodX+1 == nearXposition && foodY == nearYposition)){
				//Aqui encontramos el destino
				node lastnode = instance.new node(foodX, foodY, popednode.Gcost ,popednode );
				closelist.add(lastnode);
				break;
			}
			

			
			calculatedParent (popednode, matrix);
			
			
		}
		
		createPath();
		
	}
	
	public static void verificarMovimientos(Node pNode){
		
		int NodeposX =  pNode.positionX;
		int NodeposY =  pNode.positionY;
		int Gcost = pNode.Gcost +1;
		
		//Arriba
		if (NodeposX-1 >= 0 && checkinOpenList(NodeposX-1,NodeposY) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX-1,NodeposY);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX-1, NodeposY , Gcost );
				
			}
			
		}
		else if (NodeposX-1 >= 0 && mapaciudad[NodeposX-1][NodeposY] != '#' && checkinCloseList(NodeposX-1,NodeposY) == false){
			Node nodeUp = new Node(NodeposX-1,NodeposY,Gcost,pNode);
			openlist.add(nodeUp);
		}
		
		
		//Izquierda
		if ( NodeposY-1 >= 0 && checkinOpenList(NodeposX,NodeposY-1) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX,NodeposY-1);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX, NodeposY-1 , Gcost );
			}
			
		}
		else if (NodeposY-1 >= 0 && mapaciudad[NodeposX][NodeposY-1] != '#' && checkinCloseList(NodeposX,NodeposY-1) == false){
			Node nodeLeft = new Node(NodeposX,NodeposY-1,Gcost,pNode);
			openlist.add(nodeLeft);
		
		}
		//Derecha
		if ( mapaciudad[NodeposX][NodeposY+1] != '#' && checkinOpenList(NodeposX,NodeposY+1) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX,NodeposY+1);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX, NodeposY+1 , Gcost );
			}
			
		}
		else if (mapaciudad[NodeposX][NodeposY+1] != '#' && checkinCloseList(NodeposX,NodeposY+1) == false){
			Node nodeRight = new Node(NodeposX,NodeposY+1,Gcost,pNode);
			openlist.add(nodeRight);
		
		}
		
		//Abajo
		if ( mapaciudad[NodeposX+1][NodeposY] != '#' && checkinOpenList(NodeposX+1,NodeposY) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX+1,NodeposY);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX+1, NodeposY , Gcost );
			}
			
		}
		else if (mapaciudad[NodeposX+1][NodeposY] != '#' && checkinCloseList(NodeposX+1,NodeposY) == false ){
			Node nodeDown= new Node(NodeposX+1,NodeposY,Gcost,pNode);
			openlist.add(nodeDown);
		
		}
		
	}
	
	public static node popLowestNode(){
		
		pacman_astar instance = new pacman_astar();
		node lowestnode = instance.new node();
		node temporal = instance.new node();
		
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
	
}
