package Controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import Model.Action;
import Model.Event;

public class EventEmitter {

	
	ArrayList<Fsm> listeners = new ArrayList<Fsm>();
	Map<Integer, Fsm> listenersById = new HashMap<Integer, Fsm>();
	LinkedList<Action> queue=new LinkedList<Action> ();


   private static EventEmitter singleton = new EventEmitter( );

   /* A private Constructor prevents any other
    * class from instantiating.
    */
   private EventEmitter() { }

   /* Static 'instance' method */
   public static EventEmitter getInstance( ) {
      return singleton;
   }


   public void update(){
		
		for(int i = this.queue.size(); i > 0 ; i--) {
			
			Action action = this.queue.pop();
			Fsm fsm = action.fsm;
			fsm.onMessage(action.event);

		}
		
	}
	
   protected void register(Fsm listener) {
        this.listenersById.put(listener.id(), listener);
        this.listeners.add(listener);
      }

   public void send(String msg, int id) {
	   Event event = new Event(msg,id);
	   this._send(event);
   }
   
   protected void _send(Event event) {      
     if (event.id != 0) {
       this._sendPrivateMessage(event);
     } else {
       this._sendToAll(event);
     }
   }

   protected void _sendPrivateMessage(Event event) {
     if (this.listenersById.containsKey(event.id)) {
       EventEmitter self = this;
       Fsm fsm = self.listenersById.get(event.id);
       Action action = new Action(fsm, event);
       this._addToQueue(action);
       /*this._addToQueue(() => {
         Fsm fsm = self.listenersById.get(event.id);
         fsm.onMessage(this, event);
       });*/
     } else {
	 
    	 System.out.println("Agente desconocido");
      
     }
   }
   
   protected void _sendToAll(Event event) {
	      EventEmitter self = this;     
	      for (int i = 0; i < self.listeners.size() ; i++){
	    	  Fsm listener = self.listeners.get(i);
	    	  Action action = new Action(listener, event);
	          this._addToQueue(action);
	      }
	      /*
	      this._addToQueue(() => {
	        self._listeners.forEach((l) => l.onMessage(this, event))
	      });*/
   }
   
   public void _addToQueue(Action action) {
	      this.queue.push(action);
   }
   
}
