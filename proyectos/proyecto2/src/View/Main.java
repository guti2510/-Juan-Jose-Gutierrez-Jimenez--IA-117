package View;

import Controler.EventEmitter;
import Model.Taxi;

public class Main {

	public static void main(String[] args) {

		EventEmitter eventEmitter = EventEmitter.getInstance( );
		
		
	    Taxi taxi = new Taxi(1,eventEmitter,1,1);
	    //Taxi taxi2 = new Taxi(2,eventEmitter);
	    boolean status = true;
		while (true){
			
			if (status) {
				eventEmitter.send("pasear",0);
			    status = false;
			 } else {
				 eventEmitter.send("buscar",0);
			    status = true;
			 }
	
			eventEmitter.update();
			eventEmitter.send("update",0);
			
		}


	}

}
