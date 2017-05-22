import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class pacman_astar {
	
	class node {
		
		public int positionX;
		public int positionY;
		public int Heuristic; //Morado
		public int Gcost; // Celeste +1
		public int Fvalue; //Gcost + Heuristic  VERDE
		public node Parent;
		
		public node(){
			
		}
		public node(int x, int y, int pGcost)
        {
				positionX = x;
				positionY = y;
				Heuristic = Math.abs(x - food_x ) + Math.abs(y - food_x);
				Gcost = pGcost;
				Fvalue = pGcost + Heuristic;

        }
		public node(int x,int y, int pGcost, node pParent)
        {
				positionX = x;
				positionY = y;
				Heuristic = Math.abs(x - food_x ) + Math.abs(y - food_x);
				Gcost = pGcost;
				Fvalue = pGcost + Heuristic;
				Parent = pParent;
        }
		
	}
	
	static int pacman_x;
	static int pacman_y;
	static int food_x;
	static int food_y;
	static int rows;
    static int columns;
    static int cantX = 0;
    static LinkedList<Integer> path =new LinkedList<Integer>();  
    static LinkedList<node> openlist =new LinkedList<node>();  
    static LinkedList<node> closelist =new LinkedList<node>();
    
    
	//Con esta funcion imprimimos la matriz
		public static void printMatrix(char [][]matrix, int prows, int pcolumns){
			
		   int i = 0;
		   int j = 0;
	       for( i = 0; i< prows; i++){
	    	   for ( j = 0 ; j< pcolumns; j++){
	    		   System.out.print(matrix[i][j]);
	    	   }
	    	   System.out.println(" ");
	       }
			
		}
		public static void printPath(){
			
			int cost = path.getFirst();
			path.removeFirst();
			System.out.println(cost);
			
			for(int i = path.size(); i>=0 ; i--){
				int y = path.getLast();
				path.removeLast();
				int x = path.getLast();
				path.removeLast();
				System.out.println(x+" "+y);
				i = path.size();
			}
			
		}
		
		
		//ESTE METODO CREA EL CAMINO
		public static void createPath(){
			
			pacman_astar instance = new pacman_astar();
			node temporal = instance.new node();
			
			int CloseListsize = closelist.size()-1;
			temporal = closelist.get(CloseListsize);
			path.add(temporal.Gcost+1);
			while (temporal.Parent != null){
				path.add(temporal.positionX);
				path.add(temporal.positionY);
				temporal = temporal.Parent;
				
			}
			path.add(temporal.positionX);
			path.add(temporal.positionY);
		}
		
		public static void changeParent(node pNode , int pNodeposXnew, int pNodeposYnew , int pGcost){
			
			pacman_astar instance = new pacman_astar();
			node temporal = instance.new node(); 
			
			for (int i=0; i< openlist.size() ; i++){
				temporal = openlist.get(i);
				if (temporal.positionX == pNodeposXnew && temporal.positionY == pNodeposYnew ){
					
					node newnode = instance.new node(temporal.positionX, temporal.positionY,pGcost,pNode );
					openlist.set(i, newnode);
					break;
				}
					
			}
				
		}
		
		public static void calculatedParent(node pNode , char[][]pmatrix){
			
			int NodeposX =  pNode.positionX;
			int NodeposY =  pNode.positionY;
			int Gcost = pNode.Gcost +1;
			pacman_astar instance = new pacman_astar();
			
			//Arriba
			if (NodeposX-1 >= 0 && checkinOpenList(NodeposX-1,NodeposY) == true ){
				node nodeUp = instance.new node();
				nodeUp = getNodeinOpenList(NodeposX-1,NodeposY);
				int GcostNodeUp = nodeUp.Gcost;
				
				if (Gcost < GcostNodeUp ){
					changeParent(pNode ,NodeposX-1, NodeposY , Gcost );
					
				}
				
			}
			else if (NodeposX-1 >= 0 && pmatrix[NodeposX-1][NodeposY] != '%' && checkinCloseList(NodeposX-1,NodeposY) == false){
				node nodeUp = instance.new node(NodeposX-1,NodeposY,Gcost,pNode);
				openlist.add(nodeUp);
			}
			
			
			//Izquierda
			if ( NodeposY-1 >= 0 && checkinOpenList(NodeposX,NodeposY-1) == true ){
				node nodeUp = instance.new node();
				nodeUp = getNodeinOpenList(NodeposX,NodeposY-1);
				int GcostNodeUp = nodeUp.Gcost;
				
				if (Gcost < GcostNodeUp ){
					changeParent(pNode ,NodeposX, NodeposY-1 , Gcost );
				}
				
			}
			else if (NodeposY-1 >= 0 && pmatrix[NodeposX][NodeposY-1] != '%' && checkinCloseList(NodeposX,NodeposY-1) == false){
				node nodeLeft = instance.new node(NodeposX,NodeposY-1,Gcost,pNode);
				openlist.add(nodeLeft);
			
			}
			//Derecha
			if ( NodeposY+1 != columns && checkinOpenList(NodeposX,NodeposY+1) == true ){
				node nodeUp = instance.new node();
				nodeUp = getNodeinOpenList(NodeposX,NodeposY+1);
				int GcostNodeUp = nodeUp.Gcost;
				
				if (Gcost < GcostNodeUp ){
					changeParent(pNode ,NodeposX, NodeposY+1 , Gcost );
				}
				
			}
			else if (NodeposY+1 != columns  && pmatrix[NodeposX][NodeposY+1] != '%' && checkinCloseList(NodeposX,NodeposY+1) == false){
				node nodeRight = instance.new node(NodeposX,NodeposY+1,Gcost,pNode);
				openlist.add(nodeRight);
			
			}
			
			//Abajo
			if ( NodeposX+1 != rows && checkinOpenList(NodeposX+1,NodeposY) == true ){
				node nodeUp = instance.new node();
				nodeUp = getNodeinOpenList(NodeposX+1,NodeposY);
				int GcostNodeUp = nodeUp.Gcost;
				
				if (Gcost < GcostNodeUp ){
					changeParent(pNode ,NodeposX+1, NodeposY , Gcost );
				}
				
			}
			else if (NodeposX+1 != rows && pmatrix[NodeposX+1][NodeposY] != '%' && checkinCloseList(NodeposX+1,NodeposY) == false ){
				node nodeDown= instance.new node(NodeposX+1,NodeposY,Gcost,pNode);
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
		
		public static node getNodeinOpenList(int pNodeXpos , int pNodeYpos){
			
			pacman_astar instance = new pacman_astar();
			node specificnode = instance.new node();
			node temporal = instance.new node();

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
			
			pacman_astar instance = new pacman_astar();
			node temporal = instance.new node();
			
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
			
			pacman_astar instance = new pacman_astar();
			node temporal = instance.new node();
			
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

		
	public static void calculatePacmanAstar(char [][]matrix, int prows, int pcolumns, int pacmanX, int pacmanY, int foodX, int foodY){
		
		//Esta es la cola FIFO
        
		pacman_astar instance = new pacman_astar();
		node initialnode = instance.new node(pacmanX,pacmanY,0);
		
		calculatedParent (initialnode, matrix);
		closelist.add(initialnode);
		int nearXposition = initialnode.positionX;
		int nearYposition = initialnode.positionY;
		boolean notfound = true;
		while(notfound){
			
			node popednode = popLowestNode();
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
	
	public static void main(String[] args) {
		

		Scanner in = new Scanner(System.in);
		 
        int pacman_x = in.nextInt();
        int pacman_y = in.nextInt();
 
        int food_x = in.nextInt();
        int food_y = in.nextInt();
 
       int r = in.nextInt();
       int c = in.nextInt();
   
        char matrix[][] = new char[r][c];
 
        for(int i = 0; i < r; i++) {
            matrix[i] = in.next().toCharArray();
        }
        
       printMatrix(matrix,rows,columns);
       calculatePacmanAstar(matrix, rows, columns, pacman_x, pacman_y, food_x, food_y);
       printPath();
	}

}
