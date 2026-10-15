package ar.edu.unlp.info.oo1.ej24;

import java.time.LocalDate;
import java.util.List;

public class OrdenServicio extends Orden {
	private String descripcion;
	private int horas;
	private List<Tecnico> tecnicos;
	
	
	
	public OrdenServicio(LocalDate fecha, String domicilio, List<Producto> productos, String descripcion, int horas,
			List<Tecnico> tecnicos) {
		super(fecha, domicilio, productos);
		this.descripcion = descripcion;
		this.horas = horas;
		this.tecnicos = tecnicos;
	}

	@Override
	public double calcularCosto() {
	    double costo = super.calcularCosto()
	                  + this.calcularCostoTecnicos();

	    if (this.horas > 10) {
	        costo = costo * 0.90;
	    }

	    return costo;
	}
	
	private double calcularCostoTecnicos() {
	    return this.tecnicos.stream()
	        .mapToDouble(tecnico -> this.horas * tecnico.getValorHora())
	        .sum();
	}
}
