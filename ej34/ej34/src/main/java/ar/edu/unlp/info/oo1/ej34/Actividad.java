package ar.edu.unlp.info.oo1.ej34;

import java.time.LocalDate;

public abstract class Actividad {
	protected LocalDate fechaInicio;
	protected String direccionIp;
	protected int duracionMinutos;
	
	public Actividad(LocalDate fechaInicio, int duracionMinutos, String direccionIp) {
        this.fechaInicio = fechaInicio;
        this.duracionMinutos = duracionMinutos;
        this.direccionIp = direccionIp;
    }
	
	
	public boolean ocurreEn(DateLapse periodo) {
        return periodo.includesDate(this.fechaInicio);
    }

    public String getDireccionIp() {
        return direccionIp;
    }

    public abstract double calcularMonto();
}
