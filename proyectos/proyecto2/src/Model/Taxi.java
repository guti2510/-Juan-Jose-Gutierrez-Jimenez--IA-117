package Model;
import java.util.ArrayList;
import java.util.LinkedList;

import Controler.EventEmitter;
import Controler.Fsm;


public class Taxi {

	public int id;
	public Fsm fsm;
	public String estado;
	
	States state = new States();
	@SuppressWarnings("serial")
	public ArrayList<State> STATES = new ArrayList<State>() {{
	    add(state.new pasear());
	    add(state.new buscar());
	    add(state.new conCliente());
	}};

	/**
	 * Variables A STAR
	 */
	 
	LinkedList<Integer> path =new LinkedList<Integer>();  
    LinkedList<Node> openlist =new LinkedList<Node>();  
    LinkedList<Node> closelist =new LinkedList<Node>();
    LinkedList<Character> cuadrasvisitadas =new LinkedList<Character>();
    
    LinkedList<Integer> listamostrar =new LinkedList<Integer>();
    
    int posCuadraClienteX;
    int posCuadraClienteY;
    
    int clienteX;
	int clienteY;
	
	char destino;
    
    char cvisitada;
    boolean mostrar = false;
    
    boolean validarcambio = false;
    
    public int posX;
    public int posY;
    
    public Cliente clientemontado;
    
    public EventEmitter eventEmiter;
	
	public Taxi(int id,EventEmitter eventEmiter, int pPosX,int pPosY) {
		this.id = id;
		this.eventEmiter = eventEmiter;	
		this.posX = pPosX;
		this.posY = pPosY;
		this.fsm = new Fsm(this, this.STATES,id,eventEmiter);
		this.estado = "Disponible";
	}

	public int id() {
		return this.id;
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int pposX) {
		posX = pposX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int pposY) {
		posY = pposY;
	}
	
	public void pasear(){
		
		System.out.println("Paseando");

		int posicionX = getPosX();
		int posicionY = getPosY();
		
		if (path.isEmpty()){
			
			openlist.clear();
		    closelist.clear();
		
			encontrarCuadra();
			String movimiento = "";
			
			//REMUEVO LA POSICION ACTUAL DEL T QUE NO NECESITO
			path.removeLast();
			path.removeLast();
			
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
			
			moverTaxi(nuevaposX,nuevaposY,movimiento);
			
			this.setPosX(nuevaposX);
			this.setPosY(nuevaposY);
			
		}
		else{
			
			String movimiento = "";
			
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
			
			moverTaxi(nuevaposX,nuevaposY,movimiento);
			
			this.setPosX(nuevaposX);
			this.setPosY(nuevaposY);
			
		}
		
	}
	
	public void buscar (){
		
	    
	    int posicionX = getPosX();
		int posicionY = getPosY();
		
		setPosX(posicionX);
		setPosY(posicionY);
		
		
		if (path.isEmpty()){
			
			openlist.clear();
		    closelist.clear();
		
			encontrarCuadra();
			String movimiento = "";
			
			//REMUEVO LA POSICION ACTUAL DEL T QUE NO NECESITO
			path.removeLast();
			path.removeLast();
			
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
			
			this.setPosX(nuevaposX);
			this.setPosY(nuevaposY);
			
		}
		else{
			
			String movimiento = "";
			
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
			
			this.setPosX(nuevaposX);
			this.setPosY(nuevaposY);
			
		}
		

	}
	
	public void Mostrar (boolean pEstado){
		
		if (pEstado == true){
			mostrar = pEstado;
		}
		else {
			
			limpiarCamino();
			limpiarNumeros();
			mostrar = false;
			
		}
	}
	
	public void Ruta (boolean pEstado){
		
		if (pEstado == true){
			int posY;
			int posX;
			for (int i = path.size()-1; i >= 0 ; i=i-2){
				posY = path.get(i);
				posX = path.get(i-1);
	
				Mapa.mapaciudad[posX][posY] = '*';
			}
		}
		else{
			
			int posY;
			int posX;
			for (int i = path.size()-1; i >= 0 ; i=i-2){
				posY = path.get(i);
				posX = path.get(i-1);
	
				Mapa.mapaciudad[posX][posY] = ' ';
			}
			
		}
	}
	
	/* ------------------------------------------------------------------------------------------------------------------------------*/
	// F U N C I O N E S  SECUNDARIAS
	
	public void encontrarCuadra(){
		
		//Esta es la cola FIFO
		
		int posinicialX = getPosX();
		int posinicialY = getPosY();
		
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
			if ( Mapa.mapaciudad[nearXposition-1][nearYposition] == '%' || Mapa.mapaciudad[nearXposition-1][nearYposition] == 'o'){
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
			else if (Mapa.mapaciudad[nearXposition+1][nearYposition] == '%' || Mapa.mapaciudad[nearXposition+1][nearYposition] == 'o'){
				
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
			else if (Mapa.mapaciudad[nearXposition][nearYposition+1] == '%' || Mapa.mapaciudad[nearXposition][nearYposition+1] == 'o'){
				
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
			else if (Mapa.mapaciudad[nearXposition][nearYposition-1] == '%' || Mapa.mapaciudad[nearXposition][nearYposition-1] == 'o' ){
				
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
	
	public void verificarMovimientos(Node pNode){
		
		int NodeposX =  pNode.positionX;
		int NodeposY =  pNode.positionY;
		int Gcost = pNode.Gcost +1;
		
		//Arriba
		if (Mapa.mapaciudad[NodeposX-1][NodeposY] != 'o' && Mapa.mapaciudad[NodeposX-1][NodeposY] != '%' && NodeposX-1 >= 0 && Mapa.mapaciudad[NodeposX-1][NodeposY] != '#' &&  checkinOpenList(NodeposX-1,NodeposY) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX-1,NodeposY);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX-1, NodeposY , Gcost );
				
			}
			
		}
		else if (Mapa.mapaciudad[NodeposX-1][NodeposY] != 'o' && Mapa.mapaciudad[NodeposX-1][NodeposY] != '%' && NodeposX-1 >= 0 && Mapa.mapaciudad[NodeposX-1][NodeposY] != '#' && checkinCloseList(NodeposX-1,NodeposY) == false){
			Node nodeUp = new Node(NodeposX-1,NodeposY,Gcost,pNode);
			openlist.add(nodeUp);
		}
		
		
		//Izquierda
		if (Mapa.mapaciudad[NodeposX][NodeposY-1] != 'o' && Mapa.mapaciudad[NodeposX][NodeposY-1] != '%' && NodeposY-1 >= 0 && Mapa.mapaciudad[NodeposX][NodeposY-1] != '#'  && checkinOpenList(NodeposX,NodeposY-1) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX,NodeposY-1);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX, NodeposY-1 , Gcost );
			}
			
		}
		else if (Mapa.mapaciudad[NodeposX][NodeposY-1] != 'o' && Mapa.mapaciudad[NodeposX][NodeposY-1] != '%' && NodeposY-1 >= 0 && Mapa.mapaciudad[NodeposX][NodeposY-1] != '#' && checkinCloseList(NodeposX,NodeposY-1) == false){
			Node nodeLeft = new Node(NodeposX,NodeposY-1,Gcost,pNode);
			openlist.add(nodeLeft);
		
		}
		//Derecha
		if (Mapa.mapaciudad[NodeposX][NodeposY+1] != 'o' && Mapa.mapaciudad[NodeposX][NodeposY+1] != '%' && Mapa.mapaciudad[NodeposX][NodeposY+1] != '#' && checkinOpenList(NodeposX,NodeposY+1) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX,NodeposY+1);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX, NodeposY+1 , Gcost );
			}
			
		}
		else if (Mapa.mapaciudad[NodeposX][NodeposY+1] != 'o' && Mapa.mapaciudad[NodeposX][NodeposY+1] != '%' && Mapa.mapaciudad[NodeposX][NodeposY+1] != '#' && checkinCloseList(NodeposX,NodeposY+1) == false){
			Node nodeRight = new Node(NodeposX,NodeposY+1,Gcost,pNode);
			openlist.add(nodeRight);
		
		}
		
		//Abajo
		if (Mapa.mapaciudad[NodeposX+1][NodeposY] != 'o' && Mapa.mapaciudad[NodeposX+1][NodeposY] != '%' &&  Mapa.mapaciudad[NodeposX+1][NodeposY] != '#' && checkinOpenList(NodeposX+1,NodeposY) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX+1,NodeposY);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX+1, NodeposY , Gcost );
			}
			
		}
		else if (Mapa.mapaciudad[NodeposX+1][NodeposY] != 'o' && Mapa.mapaciudad[NodeposX+1][NodeposY] != '%' && Mapa.mapaciudad[NodeposX+1][NodeposY] != '#' && checkinCloseList(NodeposX+1,NodeposY) == false ){
			Node nodeDown= new Node(NodeposX+1,NodeposY,Gcost,pNode);
			openlist.add(nodeDown);
		
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
			posverificar = Mapa.mapaciudad[i][j];
			
			if (posverificar != 't' && posverificar != ' ' && posverificar != '%' && posverificar != 'T' && posverificar != 'o' && posverificar != '*'){
				return 	posverificar;
			}
			
			contador++;
			j++;
		}
		
		return posverificar;
	}
	
	public boolean revisarCuadra(char pCuadra){
			
			
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
	
	public  boolean checkinCloseList(int pNodeXpos , int pNodeYpos){
		
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
	
	public  boolean checkinOpenList(int pNodeXpos , int pNodeYpos){
		
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
	
	public  Node getNodeinOpenList(int pNodeXpos , int pNodeYpos){
		
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
	
	public  Node popLowestNode(){
		
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
	
	
	public  void changeParent(Node pNode , int pNodeposXnew, int pNodeposYnew , int pGcost){
		
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
	
	public  void createPath(Node pnode){
		
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
	
	private void moverTaxi(int posX, int posY, String movimiento) {
		
		
		if (mostrar == false){
		
			if (movimiento == "Derecha"){
				Mapa.mapaciudad[posX][posY-1] = ' ';
			}
			else if (movimiento == "Izquierda"){
				Mapa.mapaciudad[posX][posY+1] = ' ';
			}
			else if (movimiento == "Abajo"){
				Mapa.mapaciudad[posX-1][posY] = ' ';		
			}
			else if (movimiento == "Arriba"){
				Mapa.mapaciudad[posX+1][posY] = ' ';
			}
			
			Mapa.mapaciudad[posX][posY] = 'T';
			setPosX(posX);
			setPosY(posY);
			
		}
		else{

			if (movimiento == "Derecha"){
				Mapa.mapaciudad[posX][posY-1] = '*';
			}
			else if (movimiento == "Izquierda"){
				Mapa.mapaciudad[posX][posY+1] = '*';
			}
			else if (movimiento == "Abajo"){
				Mapa.mapaciudad[posX-1][posY] = '*';		
			}
			else if (movimiento == "Arriba"){
				Mapa.mapaciudad[posX+1][posY] = '*';
			}
			
			Mapa.mapaciudad[posX][posY] = 'T';
			
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
			
			if ( Mapa.mapaciudad[nextX][nextY] == ' '){
				Mapa.mapaciudad[nextX][nextY] = '1';
				cantidadcaminos++;
			}
			
			if (Mapa.mapaciudad[posX+1][posY] == ' ' && movimiento != "Abajo"){

				char cant = (char)(cantidadcaminos + '0');
				Mapa.mapaciudad[posX+1][posY] = cant;
				listamostrar.add(posX+1);
				listamostrar.add(posY);
				cantidadcaminos++;
			}
			
			if (Mapa.mapaciudad[posX-1][posY] == ' ' && movimiento != "Arriba"){
				char cant = (char)(cantidadcaminos + '0');
				Mapa.mapaciudad[posX-1][posY] = cant;
				listamostrar.add(posX-1);
				listamostrar.add(posY);
				cantidadcaminos++;
			}
			
			if (Mapa.mapaciudad[posX][posY+1] == ' ' && movimiento != "Derecha"){
				char cant = (char)(cantidadcaminos + '0');
				Mapa.mapaciudad[posX][posY+1] = cant;
				listamostrar.add(posX);
				listamostrar.add(posY+1);
				cantidadcaminos++;
			}
			
			if (Mapa.mapaciudad[posX][posY-1] == ' ' && movimiento != "Izquierda"){
				char cant = (char)(cantidadcaminos + '0');
				Mapa.mapaciudad[posX][posY-1] = cant;
				listamostrar.add(posX);
				listamostrar.add(posY-1);
				cantidadcaminos++;
			}
		}
	}
	
	
	private void moverTaxiBuscando(int posX, int posY, String movimiento) {
		
		
		if (movimiento == "Derecha"){
			Mapa.mapaciudad[posX][posY-1] = ' ';
		}
		else if (movimiento == "Izquierda"){
			Mapa.mapaciudad[posX][posY+1] = ' ';
		}
		else if (movimiento == "Abajo"){
			Mapa.mapaciudad[posX-1][posY] = ' ';		
		}
		else if (movimiento == "Arriba"){
			Mapa.mapaciudad[posX+1][posY] = ' ';
		}
		
		Mapa.mapaciudad[posX][posY] = 'T';
		setPosX(posX);
		setPosY(posY);
		//Busca Clientes
		if(buscarCliente(posX,posY)){
			
			int posiciones[] = buscarClientePos(posX,posY);
			clienteX = posiciones[0];
			clienteY = posiciones[1];
			
			path.clear();
		    openlist.clear();
		    closelist.clear();
		    cuadrasvisitadas.clear();
			Mapa.mapaciudad[clienteX][clienteY] = '%';

	    	destino = clienteDestino(clienteX,clienteY);
	    	System.out.println("DESTINO CLIENTE : "+destino);
	    	
	    	Cliente cliente;
	    	for (int i = 0; i < Mapa.listaclientes.size();i++){
	    		cliente = Mapa.listaclientes.get(i);
	    		if (cliente.posX == clienteX && cliente.posY == clienteY && cliente.destino == destino){
	    			clientemontado = cliente;
	    		}
	    	}

			eventEmiter.send("viajando", clientemontado.id);
			eventEmiter.send("Ocupado", this.id);
			
		}
	}
	
	//FUNCION QUE SE LLAMA CUANDO EL TAXI TIENE CLIENTE
	public void recogerCliente(){
		
		this.estado = "Ocupado";
		if (path.isEmpty() && validarcambio == true){
			
			
			validarcambio = false;
			path.clear();
			
			if (clientemontado.estadopasado == "hogar"){
				eventEmiter.send("trabajando", clientemontado.id);
			}
			else {
				eventEmiter.send("hogar", clientemontado.id);
			}
			this.estado = "Disponible";
			eventEmiter.send("buscar", this.id);

		}
		else{
		    if(path.isEmpty()){
		    
		    	int posiciones[] = buscarCuadraPos(destino);
		    	posCuadraClienteX = posiciones[0];
		    	posCuadraClienteY = posiciones[1];
		    	
			    int posicionX = getPosX();
				int posicionY = getPosY();
		
				encontrarCuadraCliente();
				
				System.out.println("Cuadra visitada:"+cvisitada);
				String movimiento = "";
				
				//REMUEVO LA POSICION ACTUAL DEL T QUE NO NECESITO
				path.removeLast();
				path.removeLast();
					
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
					
					setPosX(nuevaposX);
					setPosY(nuevaposY);
					
					//limpiarCamino();
					validarcambio = true;
				
		    }
		    else{
		    	
		    	String movimiento = "";
				
		    	int posicionX = getPosX();
				int posicionY = getPosY();
		    	
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
				
				this.setPosX(nuevaposX);
				this.setPosY(nuevaposY);
		    	
		    	
		    }
		}
	}
	
	private  boolean buscarCliente(int nearXposition, int nearYposition) {
		
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
			posverificar = Mapa.mapaciudad[i][j];
			
			if (posverificar == 'o'){
				clientecerca = true;
				return clientecerca;
			}
			
			contador++;
			j++;
		}
		
		return clientecerca;
	}
	
	private int[] buscarClientePos(int nearXposition, int nearYposition) {
		
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
			posverificar = Mapa.mapaciudad[i][j];
			
			if (posverificar == 'o'){
				return new int[] {i, j};
			}
			
			contador++;
			j++;
		}
		
		return new int[] {i, j};
	}
	
	private char clienteDestino(int clienteX, int clienteY) {

		char destino = ' ';

		for (int i = 0; i<Mapa.listaclientes.size(); i++){
			
			Cliente clientetemp = new Cliente();
			clientetemp = Mapa.listaclientes.get(i);
			
			int postempX = clientetemp.getPosX();
			int postempY = clientetemp.getPosY();
			
			if (postempX == clienteX && postempY == clienteY){
				destino = clientetemp.getDestino();
				return destino;
			}
			
			
		}

		return destino;
	}
	
	private int[] buscarCuadraPos(char destino) {
		
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
	
	
	public void encontrarCuadraCliente (){
		
		int posinicialX = getPosX();
		int posinicialY = getPosY();
		
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
	
	public void verificarMovimientos2(Node pNode){
		
		int NodeposX =  pNode.positionX;
		int NodeposY =  pNode.positionY;
		int Gcost = pNode.Gcost +1;
		
		//Arriba
		if (Mapa.mapaciudad[NodeposX-1][NodeposY] != 'o' && Mapa.mapaciudad[NodeposX-1][NodeposY] != '%' && NodeposX-1 >= 0 && Mapa.mapaciudad[NodeposX-1][NodeposY] != '#' &&  checkinOpenList(NodeposX-1,NodeposY) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX-1,NodeposY);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX-1, NodeposY , Gcost );
				
			}
			
		}
		else if (Mapa.mapaciudad[NodeposX-1][NodeposY] != 'o' && Mapa.mapaciudad[NodeposX-1][NodeposY] != '%' && NodeposX-1 >= 0 && Mapa.mapaciudad[NodeposX-1][NodeposY] != '#' && checkinCloseList(NodeposX-1,NodeposY) == false){
			Node nodeUp = new Node(NodeposX-1,NodeposY, posCuadraClienteX,posCuadraClienteY ,Gcost,pNode);
			openlist.add(nodeUp);
		}
		
		
		//Izquierda
		if (Mapa.mapaciudad[NodeposX][NodeposY-1] != 'o' && Mapa.mapaciudad[NodeposX][NodeposY-1] != '%' && NodeposY-1 >= 0 && Mapa.mapaciudad[NodeposX][NodeposY-1] != '#'  && checkinOpenList(NodeposX,NodeposY-1) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX,NodeposY-1);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX, NodeposY-1 , Gcost );
			}
			
		}
		else if (Mapa.mapaciudad[NodeposX][NodeposY-1] != 'o' && Mapa.mapaciudad[NodeposX][NodeposY-1] != '%' && NodeposY-1 >= 0 && Mapa.mapaciudad[NodeposX][NodeposY-1] != '#' && checkinCloseList(NodeposX,NodeposY-1) == false){
			Node nodeLeft = new Node(NodeposX,NodeposY-1, posCuadraClienteX,posCuadraClienteY ,Gcost,pNode);
			openlist.add(nodeLeft);
		
		}
		//Derecha
		if (Mapa.mapaciudad[NodeposX][NodeposY+1] != 'o' && Mapa.mapaciudad[NodeposX][NodeposY+1] != '%' && Mapa.mapaciudad[NodeposX][NodeposY+1] != '#' && checkinOpenList(NodeposX,NodeposY+1) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX,NodeposY+1);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX, NodeposY+1 , Gcost );
			}
			
		}
		else if (Mapa.mapaciudad[NodeposX][NodeposY+1] != 'o' && Mapa.mapaciudad[NodeposX][NodeposY+1] != '%' && Mapa.mapaciudad[NodeposX][NodeposY+1] != '#' && checkinCloseList(NodeposX,NodeposY+1) == false){
			Node nodeRight = new Node(NodeposX,NodeposY+1, posCuadraClienteX,posCuadraClienteY ,Gcost,pNode);
			openlist.add(nodeRight);
		
		}
		
		//Abajo
		if (Mapa.mapaciudad[NodeposX+1][NodeposY] != 'o' && Mapa.mapaciudad[NodeposX+1][NodeposY] != '%' &&  Mapa.mapaciudad[NodeposX+1][NodeposY] != '#' && checkinOpenList(NodeposX+1,NodeposY) == true ){
			Node nodeUp = new Node();
			nodeUp = getNodeinOpenList(NodeposX+1,NodeposY);
			int GcostNodeUp = nodeUp.Gcost;
			
			if (Gcost < GcostNodeUp ){
				changeParent(pNode ,NodeposX+1, NodeposY , Gcost );
			}
			
		}
		else if (Mapa.mapaciudad[NodeposX+1][NodeposY] != 'o' && Mapa.mapaciudad[NodeposX+1][NodeposY] != '%' && Mapa.mapaciudad[NodeposX+1][NodeposY] != '#' && checkinCloseList(NodeposX+1,NodeposY) == false ){
			Node nodeDown= new Node(NodeposX+1,NodeposY, posCuadraClienteX,posCuadraClienteY ,Gcost,pNode);
			openlist.add(nodeDown);
		
		}
		
	}
	
	private void limpiarNumeros() {


		for( int i = 0; i< listamostrar.size(); i=i+2){
			int posx = listamostrar.get(i);
			int posy = listamostrar.get(i+1);
			Mapa.mapaciudad[posx][posy] = ' ';
		}
		listamostrar.clear();
	}
	
	private void limpiarCamino() {
		int i = 0;
		int j = 0;
		char posverificar;
		for( i = 0; i< Mapa.ciudadfilas; i++){
			for ( j = 0 ; j< Mapa.ciudadcolumnas; j++){
			   
				posverificar = Mapa.mapaciudad[i][j];
				
				if (posverificar == '*'){
					Mapa.mapaciudad[i][j] = ' ';
				}
	
			}
		}
		
	}
	
}
