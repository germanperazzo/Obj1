package ar.edu.unlp.info.oo1.ej7;

import java.util.ArrayList;
import java.util.List;


public class Balanza {
private List<Producto> productos;
	
	public Balanza() {
		this.productos = new ArrayList<Producto>();
	}
	
	public List<Producto> getProductos() {
		return this.productos;
	}
	
	public void ponerEnCero() {
		this.productos.clear();;
	}
	
	public void agregarProducto(Producto p){
		this.productos.add(p);
	}
	
	public Ticket emitirTicket() {
		Ticket tick = new Ticket(this.getCantidadDeProductos(), this.getPesoTotal(), this.getPrecioTotal(),this.getProductos());
		return tick;
	}
	
	public int getCantidadDeProductos() {
		return this.productos.size();
	}

	public double getPrecioTotal() {
		return this.productos.stream().mapToDouble(producto -> producto.getPrecio()).sum();
	}

	public double getPesoTotal() {
		return this.productos.stream().mapToDouble(producto -> producto.getPeso()).sum();
	}
}
