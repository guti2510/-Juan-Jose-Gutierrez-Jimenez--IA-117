package Model;

import Controler.Fsm;

public interface State {
	
	public boolean accepts(String event);
	
	public void onEnter(Fsm fsm);
	
	public void onUpdate(Fsm fsm);

	public void onExit(Fsm fsm);
}
