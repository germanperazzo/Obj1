package ar.edu.unlp.info.oo1.ej15;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
	
	private String nombre;
	private List<Inversion> inversiones;
	
	public Inversor(String nombre) {
		this.nombre = nombre;
		this.inversiones = new ArrayList<Inversion>(); 
	}
	
	public void agregarInversion(Inversion i){
		this.inversiones.add(i);
	}
	
	public void quitarInversion(Inversion i){
		this.inversiones.remove(i);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double valorActual(){
		return this.inversiones.stream()
				.mapToDouble(i -> i.valorActual())
				.sum();
	}
}
