package Controlador;


public class Node {

	public int positionX;
	public int positionY;
	public int Heuristic; //Morado
	public int Gcost; // Celeste +1
	public int Fvalue; //Gcost + Heuristic  VERDE
	public Node Parent;
	
	public Node(){
		
	}
	
	public Node(int x, int y, int pGcost)
    {
			positionX = x;
			positionY = y;
			Gcost = pGcost;
    }
	public Node(int x,int y,int pGcost, Node pParent)
    {
			positionX = x;
			positionY = y;
			Gcost = pGcost;
			Parent = pParent;
    }
	
	public Node(int x, int y, int pGcost, int pcuadraX , int pcuadraY)
    {
			positionX = x;
			positionY = y;
			Heuristic = Math.abs(x - pcuadraX ) + Math.abs(y - pcuadraY);
			Gcost = pGcost;
			Fvalue = pGcost + Heuristic;

    }
	public Node(int x,int y, int pcuadraX , int pcuadraY,int pGcost, Node pParent)
    {
			positionX = x;
			positionY = y;
			Heuristic = Math.abs(x - pcuadraX ) + Math.abs(y - pcuadraY);
			Gcost = pGcost;
			Fvalue = pGcost + Heuristic;
			Parent = pParent;
    }
	
}
