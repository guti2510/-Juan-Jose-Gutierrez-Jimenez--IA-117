package Controler;


public class Event {

	public String msg = null;
	public int id = 0;
	public Event(String msg, int id) {

		this.msg = msg;
		this.id = id;
	}

	public String toString(){
		
		return id + " = "+msg ;
	}
}
