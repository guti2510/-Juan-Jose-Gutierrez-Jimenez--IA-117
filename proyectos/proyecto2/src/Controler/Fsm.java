package Controler;
import java.util.ArrayList;

import Model.Event;
import Model.State;
import Model.States;


public class Fsm {

	Object owner;
	ArrayList<State> states = new ArrayList<State>();
	public int myId;
	public State _current;
	
	
	public Fsm(Object owner,ArrayList<State> states,int id, EventEmitter eventEmiter) {
		
		this.owner = owner;
	    this.states = states;
	    this.myId = id;
	    States state = new States();
	    this._current = null;
	    eventEmiter.register(this);
		
	}
	
	public String toString(){
		
		return myId + " ENTRO ";
	}

	public int id() {
	    return this.myId;
	}
	
	public Object owner() {
		return this.owner;
	}
	
	public void onMessage(Event event) {    
	    if (event.msg == "update") {
	    	if (this._current != null){
	    		this._current.onUpdate(this);
	    	}
	    } 
	    else {
	    	
	    	State state = null;
			for (int i = 0; i < states.size(); i++)
		    {
			   State temp = states.get(i);
		       if (temp.accepts(event.msg)) 
		       {
		    	   state = temp;
		    	   break;
		       }
		    }
    
			boolean accepted = false;
			 
			 if (state != null && state != this._current){
				 accepted = true;
			 }
		      if (accepted) {
		        if (this._current != null) {
		          this._current.onExit(this);
		        }
		        this._current = state;
		        this._current.onEnter(this);
		      }
	    }
	}  
	
}
