package Model;

import Controler.Fsm;

public class States {

		
	public class pasear implements State{
		
		public boolean accepts(String event) {
	        //criteria to be able to get in that state
	        return event == "pasear";
	    }

		public void onEnter(Fsm fsm) {
			
	        this.onUpdate(fsm);
	        
	    }

	    public void onUpdate(Fsm fsm) {
	        ((Taxi) fsm.owner()).pasear();
	        System.out.println("TAXI" + fsm.id()+"  "+ "paseando");
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
	        System.out.println("TAXI " + fsm.id()+"  "+ "buscando");
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
	        System.out.println("TAXI" + fsm.id()+"  " + "con cliente");
	    }

		@Override
		public void onExit(Fsm fsm) {
			// TODO Auto-generated method stub
			
		}
	    
	}
	
	public class hogar implements State{
		
		public boolean accepts(String event) {
	        //criteria to be able to get in that state
	        return event == "hogar";
	    }

		public void onEnter(Fsm fsm) {
			
	        this.onUpdate(fsm);
	        
	    }

		public void onUpdate(Fsm fsm) {
	        ((Cliente) fsm.owner()).hogar();
	        System.out.println("Cliente" + fsm.id()+"  " + "descansando hogar");
	    }

		@Override
		public void onExit(Fsm fsm) {
			// TODO Auto-generated method stub
			
		}
	    
	}
	
	public class esperando implements State{
		
		public boolean accepts(String event) {
	        //criteria to be able to get in that state
	        return event == "esperando";
	    }

		public void onEnter(Fsm fsm) {
			
	        this.onUpdate(fsm);
	        
	    }

		public void onUpdate(Fsm fsm) {
	        System.out.println("Cliente" + fsm.id()+"  " + " esperando");
	    }

		@Override
		public void onExit(Fsm fsm) {
			// TODO Auto-generated method stub
			
		}
	    
	}
	
	public class trabajando implements State{
		
		public boolean accepts(String event) {
	        //criteria to be able to get in that state
	        return event == "trabajando";
	    }

		public void onEnter(Fsm fsm) {
			
	        this.onUpdate(fsm);
	        
	    }

		public void onUpdate(Fsm fsm) {
	        System.out.println("Cliente" + fsm.id()+"  " + " trabajando");
	        ((Cliente) fsm.owner()).trabajando();
	    }

		@Override
		public void onExit(Fsm fsm) {
			// TODO Auto-generated method stub
			
		}
	    
	}
	
	public class viajando implements State{
		
		public boolean accepts(String event) {
	        //criteria to be able to get in that state
	        return event == "viajando";
	    }

		public void onEnter(Fsm fsm) {
			
	        this.onUpdate(fsm);
	        
	    }

		public void onUpdate(Fsm fsm) {
	        System.out.println("Cliente" + fsm.id()+"  " + " viajando");
	    }

		@Override
		public void onExit(Fsm fsm) {
			// TODO Auto-generated method stub
			
		}
	    
	}

}
