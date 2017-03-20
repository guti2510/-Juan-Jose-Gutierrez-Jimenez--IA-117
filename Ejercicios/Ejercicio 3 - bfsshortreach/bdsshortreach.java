import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.LinkedList;

public class bfsshortreach {

	LinkedList<Integer>[] adj;
	int V;

	//Esta es la lista de los nodos visitados
    boolean [] marked;
	int start;

	public bfsshortreach(int V)
	{
		this.V = V;
		adj = new LinkedList[V + 1];
		for (int i = 0; i <= V ; i++ )
		{
			adj[i] = new LinkedList<>();	
		}
		marked = new boolean[V+1];
	}
	public void addEdge(int v , int w)
	{
		adj[v].add(w);
		adj[w].add(v);
	}	
    public int bfs(int initialnode , int finalnode)
    {
        int counter = 0;
        //Esta es la cola FIFO
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(initialnode);
        while(!queue.isEmpty())
        {
            counter++;
            int v  = queue.poll();
            marked[v] = true;

            for(int w : adj[v])
            {
                if(!marked[w])
                {
                    marked[w] = true;
                    if(finalnode == w)
                        {
                            return counter;   
                        }
                    queue.add(w);
                }
            }
        }
        return -1;
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while(t-- > 0)
        {
            int nodes = input.nextInt();
            int edges = input.nextInt();
            bfsshortreach graph = new bfsshortreach(nodes);
            for(int i = 0 ; i < edges ; i++)
                {
            	graph.addEdge(input.nextInt(),input.nextInt());
                }
            //Nodo inicial
            graph.start = input.nextInt();
            
            //Con este for vamos recorriendo todos los nodos del grafo (1-n)
            for(int i = 1 ; i < nodes + 1 ; i++)
            {
                int c = -1 ;

                if(i != graph.start)
                    {
                        //Con la funcion bfs nos hace el calculo de el nodo inicial a todos los nodos
                		//Pero solo nos dice la cantidad de "saltos", despues lo multiplicamos x6
                		c = graph.bfs(graph.start, i);
                        if(c != -1)
                            System.out.print(6*c + " ");
                        else
                            System.out.print(c + " ");
                    }
                //Seteamos la lista de booleanos a false
                graph.marked = new boolean[nodes+1];            
            }
            System.out.println();
        }
    }

}
