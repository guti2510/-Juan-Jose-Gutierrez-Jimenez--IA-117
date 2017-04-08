

public class Taxi {
	
	int posX;
	int posY;
	
	String estado;
	boolean ocupado;
	
	public int Heuristic; //Morado
	public int Gcost; // Celeste +1
	public int Fvalue; //Gcost + Heuristic  VERDE
	public Taxi Parent;
	
	
	public Taxi(){
		
	}
	public Taxi(int x, int y, int pGcost,int destino_x, int destino_y)
    {
		posX = x;
		posY = y;
		Heuristic = Math.abs(x - destino_x ) + Math.abs(y - destino_y);
		Gcost = pGcost;
		Fvalue = pGcost + Heuristic;

    }
	public Taxi(int x,int y, int pGcost,int destino_x, int destino_y, Taxi pParent)
    {
		posX = x;
		posY = y;
		Heuristic = Math.abs(x - destino_x ) + Math.abs(y - destino_y);
		Gcost = pGcost;
		Fvalue = pGcost + Heuristic;
		Parent = pParent;
    }
}