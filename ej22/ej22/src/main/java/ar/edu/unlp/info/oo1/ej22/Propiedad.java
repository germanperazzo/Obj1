package ar.edu.unlp.info.oo1.ej22;

import java.util.ArrayList;
import java.util.List;




public class Propiedad {
	private String direccion;
	private String nombre;
	private double precioNoche;
	private List<Reserva> reservas;
	
	
	public Propiedad(String direccion, String nombre, double precioNoche) {
		this.direccion = direccion;
		this.nombre = nombre;
		this.precioNoche = precioNoche;
		this.reservas = new ArrayList<Reserva>();
	}
	
	
	
	public String getDireccion() {
		return direccion;
	}

	public boolean isDisponible(DateLapse periodo) {
		return this.reservas
				   .stream()
				   .noneMatch(r -> r.overlaps(periodo));
	}
	
	public boolean crearReserva(Persona inquilino, DateLapse periodo) {
		if (this.isDisponible(periodo)) {
			Reserva r = new Reserva(periodo, this, inquilino);
			this.reservas.add(r);
			return true;
		}
		return false;
	}
	
	public double getPrecioNoche() {
		return this.precioNoche;
	}
	
	public boolean cancelarReserva(Reserva r) {
	    if (!r.estaEnCurso()) {
	        return this.reservas.remove(r);
	    }
	    return false;
	}
	
	public double calcularIngresoPropiedad(DateLapse periodo) {
		return this.reservas
				   .stream()
				   .filter(reserva -> reserva.overlaps(periodo))
				   .mapToDouble(reserva -> reserva.costo())
				   .sum();
		
	}
	
}
