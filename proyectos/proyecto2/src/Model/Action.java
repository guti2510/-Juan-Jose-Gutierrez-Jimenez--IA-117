package Model;

import Controler.Fsm;

public class Action {

	public Fsm fsm;
	public Event event;
	public Action(Fsm fsm, Event event) {
		this.fsm = fsm;
		this.event = event;
	}

}
