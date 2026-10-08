package ar.edu.unlp.info.oo1.ej15;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class InversionEnPlazoFijo implements Inversion {
	
	private LocalDate fechaDeConstitucion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;

	public InversionEnPlazoFijo(LocalDate fechaDeConstitucion, double montoDepositado, double porcentajeDeInteresDiario) {
		this.fechaDeConstitucion = fechaDeConstitucion;
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}
	
	@Override
	public double valorActual() {
		double cantDias = ChronoUnit.DAYS.between(fechaDeConstitucion, LocalDate.now());
		
		return this.montoDepositado + (this.montoDepositado * this.porcentajeDeInteresDiario * cantDias);
	}

}
