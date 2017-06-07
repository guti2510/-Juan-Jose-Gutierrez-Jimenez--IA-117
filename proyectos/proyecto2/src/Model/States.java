package Model;

import Controler.Fsm;

public class States {

		
	public class pasear implements State{
		
		public boolean accepts(String event) {
	        //criteria to be able to get in that state
	        return event == "pasear";
	    }

		public void onEnter(Fsm fsm) {
			
	        this.onUpdate( fsm);
	        
	    }

	    public void onUpdate(Fsm fsm) {
	        ((Taxi) fsm.owner()).pasear();
	        System.out.print("TAXI" + fsm.id()+"  "+ "paseando");
	    }

		@Override
		public void onExit(Fsm fsm) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class buscar implements State{
		
		public boolean accepts(String event) {
	        //criteria to be able to get in that state
	        return event == "buscar";
	    }

		public void onEnter(Fsm fsm) {
			
	        this.onUpdate(fsm);
	        
	    }

		public void onUpdate(Fsm fsm) {
	        ((Taxi) fsm.owner()).buscar();
	        System.out.print("TAXI" + fsm.id()+"  "+ "buscando");
	    }

		@Override
		public void onExit(Fsm fsm) {
			// TODO Auto-generated method stub
			
		}
	    
	}

	
	public class conCliente implements State{
		
		public boolean accepts(String event) {
	        //criteria to be able to get in that state
	        return event == "Ocupado";
	    }

		public void onEnter(Fsm fsm) {
			
	        this.onUpdate(fsm);
	        
	    }

		public void onUpdate(Fsm fsm) {
	        ((Taxi) fsm.owner()).recogerCliente();
	        System.out.print("TAXI" + fsm.id()+"  " + "con cliente");
	    }

		@Override
		public void onExit(Fsm fsm) {
			// TODO Auto-generated method stub
			
		}
	    
	}

}
