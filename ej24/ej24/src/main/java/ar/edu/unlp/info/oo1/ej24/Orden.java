package ar.edu.unlp.info.oo1.ej24;

import java.time.LocalDate;
import java.util.List;

public class Orden {
	private LocalDate fecha;
	private String domicilio;
	private List<Producto> productos; 
	
	
	
	
	public Orden(LocalDate fecha, String domicilio, List<Producto> productos) {
		
		this.fecha = fecha;
		this.domicilio = domicilio;
		this.productos = productos;
	}


	public int getCantidadProductos() {
		return this.productos.size();
	}

	public double calcularCosto() {
		 return this.productos.stream()
			        .mapToDouble(producto -> producto.getCosto())
			        .sum();
	}
	
	
	
}
