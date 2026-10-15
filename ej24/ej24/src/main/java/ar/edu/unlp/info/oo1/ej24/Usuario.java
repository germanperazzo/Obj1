package ar.edu.unlp.info.oo1.ej24;

import java.util.List;

public class Usuario {
	private String nombreCompleto;
	private String domicilio;
	private List<Orden> ordenes;
	
	
	
	
	public Usuario(String nombreCompleto, String domicilio, List<Orden> ordenes) {
		
		this.nombreCompleto = nombreCompleto;
		this.domicilio = domicilio;
		this.ordenes = ordenes;
	}

	public void agregarOrden(Orden orden) {
		this.ordenes.add(orden);
	}
	
	public List<Orden> getOrdenes(){
		return this.ordenes;
	}
}
