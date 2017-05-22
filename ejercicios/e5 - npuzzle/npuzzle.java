
import java.util.LinkedList;
import java.util.Scanner;


public class npuzzle {

	static int sizematrix; //TAMAÑO DEL TABLERO
	static LinkedList<String> path =new LinkedList<String>();  
    static LinkedList<node> openlist =new LinkedList<node>();  
    static LinkedList<node> closelist =new LinkedList<node>();
    static boolean notfound = true;
    static int numberofmoves;
    
	class node {
		
		//public boolean visited;
		public int emptyspaceX;
		public int emptyspaceY;
		public int Heuristic; //Morado
		public int Gcost; // Celeste +1
		public int Fvalue; //Gcost + Heuristic  VERDE
		public node Parent;
		public int matrix[][] = new int[sizematrix][sizematrix];
		public String movement;
		
		public node(){
			
		}
		public node(int pGcost, int  pmatrix [][], node pParent, String pmovement )
        {
				
				
				emptyspaceX = getXvalue(pmatrix);
				emptyspaceY = getYvalue(pmatrix);
				Heuristic = heuristic(pmatrix);
				matrix = pmatrix;
				Gcost = pGcost;
				Fvalue = pGcost + Heuristic;
				Parent = pParent;
				movement = pmovement;
        }

		
	}
	
	//ESTE METODO CREA EL CAMINO
	public static void createPath(){
		
		npuzzle instance = new npuzzle();
		node temporal = instance.new node();
		
		int CloseListsize = closelist.size()-1;
		temporal = closelist.get(CloseListsize);
		numberofmoves = temporal.Gcost;
		temporal = temporal.Parent;
		
		while (temporal.Parent != null){
			
			path.add(temporal.movement);
			temporal = temporal.Parent;
			
		}

	}
			
	public static void printPath(){
		
		int cost = numberofmoves;
		System.out.println(cost);
		
		for(int i = path.size(); i>=0 ; i--){
			String movement = path.getLast();
			path.removeLast();
			System.out.println(movement);
			i = path.size();
		}
		
	}
	
	public static int heuristic(int pmatrix [][]) {
	    int cnt = 0, ret = 0;
		for(int i = 0; i < sizematrix; ++i){
	        for(int j = 0; j < sizematrix; ++j) {
	            if(pmatrix[i][j] != cnt) ++ret;
	            ++cnt;
	        }
		}
	    return ret;
	}
	
	public static boolean isGoalState(int pmatrix [][]) {
	    return heuristic(pmatrix) == 0;
	}
	
	public static node popLowestNode(){
		
		npuzzle instance = new npuzzle();
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
	
	public static int getXvalue(int pmatrix[][]){
		
		int xvalue = 0;
		for(int i = 0; i < sizematrix; ++i){
	        for(int j = 0; j < sizematrix; ++j) {
	            if(pmatrix[i][j] == 0 ){
	            	xvalue = i;
	            	return xvalue;
	            }     
	        }
		}
		return xvalue;
	}
	
	public static int getYvalue(int pmatrix[][] ){
		
		int yvalue = 0;
		for(int i = 0; i < sizematrix; ++i){
	        for(int j = 0; j < sizematrix; ++j) {
	            if(pmatrix[i][j] == 0 ){
	            	yvalue = j;
	            	return yvalue;
	            }     
	        }
		}
		return yvalue;
	}
	
	public static boolean checkinOpenList(int[][] newmatrix){
		
		npuzzle instance = new npuzzle();
		node temporal = instance.new node();
		
		boolean isInOpenList = false;
		for (int i=0; i< openlist.size() ; i++){
			temporal = openlist.get(i);
			if (checkinMatrix(temporal.matrix,newmatrix)){
				isInOpenList = true;
				return isInOpenList;
			}
				
		}
		return isInOpenList;
	}
	
	public static boolean checkinCloseList(int[][] newmatrix){
		
		npuzzle instance = new npuzzle();
		node temporal = instance.new node();
		
		boolean isInCloseList = false;
		for (int i=0; i< closelist.size() ; i++){
			temporal = closelist.get(i);
			if (checkinMatrix(temporal.matrix,newmatrix)){
				isInCloseList = true;
				return isInCloseList;
			}
				
		}
		return isInCloseList;
	}
	
	public static boolean checkinMatrix(int[][] newmatrix , int[][] newmatrix2){
		
		npuzzle instance = new npuzzle();
		node temporal = instance.new node();
		
		boolean isInCloseList = true;
		
		for (int i=0; i< sizematrix ; i++){
			for (int j=0; j< sizematrix ; j++){
				if (newmatrix[i][j] != newmatrix2[i][j] ){
					isInCloseList = false;
					return isInCloseList;
				}
			}	
		}
		return isInCloseList;
	}
	
	public static int[][] swapPosition(int pmatrix[][],int pEmptyXpos,int pEmptyYpos,String pMovement){
		
		int newmatrix[][] = new int[sizematrix][sizematrix];
		
		
		if (pMovement.equals("UP")){
			
			int valor = pmatrix[pEmptyXpos-1][pEmptyYpos];
			for(int i = 0; i < pmatrix.length; i++)
				newmatrix[i] = pmatrix[i].clone();
			
			newmatrix[pEmptyXpos][pEmptyYpos] = valor;
			newmatrix[pEmptyXpos-1][pEmptyYpos] = 0;
			
			return newmatrix;
			
		}
		else if(pMovement.equals("LEFT")){
			
			int valor = pmatrix[pEmptyXpos][pEmptyYpos-1];
			for(int i = 0; i < pmatrix.length; i++)
				newmatrix[i] = pmatrix[i].clone();
			newmatrix[pEmptyXpos][pEmptyYpos] = valor;
			newmatrix[pEmptyXpos][pEmptyYpos-1] = 0;
			
			return newmatrix;
			
		}
		else if(pMovement.equals("RIGHT")){
			
			int valor = pmatrix[pEmptyXpos][pEmptyYpos+1];
			for(int i = 0; i < pmatrix.length; i++)
				newmatrix[i] = pmatrix[i].clone();
			newmatrix[pEmptyXpos][pEmptyYpos] = valor;
			newmatrix[pEmptyXpos][pEmptyYpos+1] = 0;
			
			return newmatrix;
			
		}
		else if(pMovement.equals("DOWN")){
			
			int valor = pmatrix[pEmptyXpos+1][pEmptyYpos];
			for(int i = 0; i < pmatrix.length; i++)
				newmatrix[i] = pmatrix[i].clone();
			newmatrix[pEmptyXpos][pEmptyYpos] = valor;
			newmatrix[pEmptyXpos+1][pEmptyYpos] = 0;
			
			return newmatrix;
			
		}
		
		return newmatrix;
	}
	
	public static void calculatedParent(node pNode){
		
		
		int NodeposX =  pNode.emptyspaceX;
		int NodeposY =  pNode.emptyspaceY;
		int Gcost = pNode.Gcost +1;
		int newmatrix[][];
		
		npuzzle instance = new npuzzle();
		
		//Arriba

		if (NodeposX-1 >= 0 ){
			
			int temporal[][] = new int[sizematrix][sizematrix];
			for(int i = 0; i < pNode.matrix.length; i++)
				temporal[i] = pNode.matrix[i].clone();
			newmatrix = swapPosition(temporal,NodeposX,NodeposY,"UP");
			if (checkinCloseList(newmatrix) == false && checkinOpenList(newmatrix) == false){
				node nodeUp = instance.new node(Gcost,newmatrix,pNode,"UP");
				openlist.add(nodeUp);
			}
			
		}
		
		
		//Izquierda
		if (NodeposY-1 >= 0 ){
			
			int temporal[][] = new int[sizematrix][sizematrix];
			for(int i = 0; i < pNode.matrix.length; i++)
				temporal[i] = pNode.matrix[i].clone();
			newmatrix = swapPosition(temporal,NodeposX,NodeposY,"LEFT");
			if (checkinCloseList(newmatrix) == false && checkinOpenList(newmatrix) == false){
				node nodeLeft = instance.new node(Gcost,newmatrix,pNode,"LEFT");
				openlist.add(nodeLeft);
			}
			
		
		}
		//Derecha
		
		if (NodeposY+1 != sizematrix ){
			
			int temporal[][] = new int[sizematrix][sizematrix];
			for(int i = 0; i < pNode.matrix.length; i++)
				temporal[i] = pNode.matrix[i].clone();
			newmatrix = swapPosition(temporal,NodeposX,NodeposY,"RIGHT");
			
			if (checkinCloseList(newmatrix) == false && checkinOpenList(newmatrix) == false){
				node nodeRight = instance.new node(Gcost,newmatrix,pNode,"RIGHT");
				openlist.add(nodeRight);
			}
		
		}
		
		//Abajo
		if (NodeposX+1 != sizematrix){
			
			int temporal[][] = new int[sizematrix][sizematrix];
			for(int i = 0; i < pNode.matrix.length; i++)
				temporal[i] = pNode.matrix[i].clone();
			newmatrix = swapPosition(temporal,NodeposX,NodeposY,"DOWN");
			
			if (checkinCloseList(newmatrix) == false && checkinOpenList(newmatrix) == false ){
			
				node nodeDown= instance.new node(Gcost,newmatrix,pNode,"DOWN");
				openlist.add(nodeDown);
			}
		
		}
		
	}
	
	public static void nPuzzleefunction(int pmatrix[][]){
		
		npuzzle instance = new npuzzle();
		node initialnode = instance.new node(0, pmatrix , null, null);
		
		calculatedParent (initialnode);
		closelist.add(initialnode);

		while(notfound){
			
			node popednode = popLowestNode();
			closelist.add(popednode);
			
			if( isGoalState(popednode.matrix) ) {
		        
				node lastnode = instance.new node(popednode.Gcost,popednode.matrix,popednode,"Found");
				closelist.add(lastnode);
				
				notfound = true;				
		        break;
		    }

			calculatedParent (popednode);
			
			
		}
		
		createPath();
		
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		 
        sizematrix = in.nextInt();
        
   
        int matrix[][] = new int[sizematrix][sizematrix];
 
        for(int i = 0; i < sizematrix; ++i){
	        for(int j = 0; j < sizematrix; ++j) {
	            matrix[i][j] = in.nextInt();
	        }
		}

		nPuzzleefunction(matrix1);
		printPath();
		

	}

}
