package ar.edu.unlp.info.oo1.ej15;


public class InversionEnAcciones implements Inversion {
	
	private String nombre;
	private int cantidad;
	private double valorUnitario;
	
	public InversionEnAcciones(String nombre, int cantidad,double valorUnitario) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.valorUnitario = valorUnitario;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	@Override
	public double valorActual() {
		
		return this.valorUnitario * this.cantidad;
	}

}
