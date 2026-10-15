package ar.edu.unlp.info.oo1.ej23;

import java.time.LocalDate;

public class Reserva {
	private DateLapse periodo;
	private Propiedad propiedad;
	private Persona inquilino;
	
	public Reserva(DateLapse periodo, Propiedad propiedad, Persona inquilino) {
		this.periodo = periodo;
		this.propiedad = propiedad;
		this.inquilino = inquilino;
	}
	
	public boolean overlaps(DateLapse p) {
		return this.periodo.overlapse(p);
	}
	
	
	
	public double costo() {
		return this.periodo.sizeInDays() * this.propiedad.getPrecioNoche();
	}
	
	public boolean estaEnCurso() {
	    return this.periodo.includesDate(LocalDate.now());
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;

	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }

	    Reserva otra = (Reserva) obj;

	    return this.periodo.getFrom().equals(otra.periodo.getFrom())
	        && this.periodo.getTo().equals(otra.periodo.getTo())
	        && this.propiedad.getDireccion().equals(otra.propiedad.getDireccion())
	        && this.inquilino.getDni().equals(otra.inquilino.getDni());
	}

	public LocalDate getPeriodoFrom() {
		
		return this.periodo.getFrom();
	}
}
