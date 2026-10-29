package ar.edu.unlp.info.oo1.ej34;

import java.time.LocalDate;

public class ReproduccionVideo extends Actividad{
	private int duracionPublicidad;
	
	
	public ReproduccionVideo(LocalDate fechaInicio, int duracionMinutos, String direccionIp, int duracionPublicidad) {
		super(fechaInicio, duracionMinutos, direccionIp);
		
		this.duracionPublicidad = duracionPublicidad;
		
	}
	
	public boolean ocurreEn(DateLapse periodo) {
        
		return periodo.includesDate(this.fechaInicio);
    }
	
	private int duracionReal() {
		
		return this.duracionMinutos - this.duracionPublicidad;
	}
	
	@Override
	public double calcularMonto() {
		
		return duracionReal() * 10;
	}
	
}
