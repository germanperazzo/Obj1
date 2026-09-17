package ar.edu.unlp.info.oo1.ej7;

import java.time.LocalDate;
import java.util.List;


public class Ticket {
	private LocalDate fecha;
	private int cantidadDeProducto;
	private List<Producto> productos;
	private double pesoTotal;
	private double precioTotal;
	
	public Ticket(int cantidadDeProductos, double pesoTotal, double precioTotal, List<Producto> productos) {
		this.cantidadDeProducto = cantidadDeProductos;
		this.productos = productos;
		this.pesoTotal = pesoTotal;
		this.precioTotal = precioTotal;
		this.fecha = LocalDate.now();
	}
	
	public List<Producto> getProductos() {
		return productos;
	}
	
	public java.time.LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(java.time.LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public int getCantidadDeProductos() {
		return cantidadDeProducto;
	}
	
	public void setCantidadDeProductos(int cantidadDeProductos) {
		this.cantidadDeProducto = cantidadDeProductos;
	}
	
	public double getPesoTotal() {
		return pesoTotal;
	}
	
	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	
	public double getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public double impuesto() {
		return (this.getPrecioTotal() * 0.21);
	}
}
