package Controler;

public class Action {

	public Fsm fsm;
	public Event event;
	public Action(Fsm fsm, Event event) {
		this.fsm = fsm;
		this.event = event;
	}
	
	public String toString(){
		
		return fsm.toString() + " " + event.toString();
	}
	
}
