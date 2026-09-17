package ar.edu.unlp.info.oo1.ej10;

import java.util.ArrayList;
import java.util.List;


public class Farola {
	private boolean on;
	private ArrayList<Farola> farolas;
	
	public Farola() {
		this.on = false;
		this.farolas = new ArrayList<Farola>();
	}
	
	public void pairWithNeighbor( Farola otraFarola ) {
		if(!this.farolas.contains(otraFarola)) {
			this.farolas.add(otraFarola);
			otraFarola.pairWithNeighbor(this);
		}
	}
	
	public List<Farola> getNeighbors (){
		return new ArrayList<Farola>(this.farolas);
	}
	
	public void turnOff() {
		if(this.on) {
			this.on = false;
			this.farolas.forEach(l -> l.turnOff());
		}
	}
	public void turnOn() {
		if(!this.on) {
			this.on = true;
			this.farolas.forEach(l -> l.turnOn());
		}
	}
	
	public boolean isOn() {
		return this.on;
	}
	public boolean isOff() {
		return !this.on;
	}
}
