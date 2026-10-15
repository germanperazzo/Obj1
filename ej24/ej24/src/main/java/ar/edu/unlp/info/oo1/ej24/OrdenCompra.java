package ar.edu.unlp.info.oo1.ej24;

import java.time.LocalDate;
import java.util.List;

public class OrdenCompra extends Orden {
	private double precioEnvio;
	
	
	
	public OrdenCompra(LocalDate fecha, String domicilio, List<Producto> productos, double precioEnvio) {
		super(fecha, domicilio, productos);
		this.precioEnvio = precioEnvio;
	}

	

	@Override
	public double calcularCosto() {
		double costo = super.calcularCosto() + this.precioEnvio;

	    if (this.getCantidadProductos() >= 5) {
	        costo = costo * 0.90;
	    }

	    return costo;
	}
}
