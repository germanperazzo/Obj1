package ar.edu.unlp.info.oo1.ej34;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SesionJuegos extends Actividad {
	private List<ItemJuego> items;
	
	
	public SesionJuegos(LocalDate fechaInicio, int duracionMinutos, String direccionIp) {
		super(fechaInicio, duracionMinutos, direccionIp);
		this.items = new ArrayList<>();
	}
	
	
	public boolean ocurreEn(DateLapse periodo) {
        
		return periodo.includesDate(this.fechaInicio);
    }
	
	private double montoItems() {
		return this.items.stream()
				.mapToDouble(ItemJuego::precioFinal)
				.sum();
	}
	
	@Override
	public double calcularMonto() {
		
		return this.duracionMinutos > 360 ? montoItems() : 0;
	}

}
