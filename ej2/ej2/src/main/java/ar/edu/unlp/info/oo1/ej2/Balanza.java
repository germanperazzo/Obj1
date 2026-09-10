package ar.edu.unlp.info.oo1.ej2;

public class Balanza {
	
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	private List<Producto> productos;
	
	public List<Producto> getProductos(){
		return this.productos;
	}
	
	public void ponerEnCero()  {
		this.cantidadDeProductos = 0;
		this.precioTotal = 0;
		this.pesoTotal =0;
		this.productos.clear();
	}
	
	public void agregarProducto(Producto p) {
		this.cantidadDeProductos ++;
		this.precioTotal += p.getPrecio();
		this.pesoTotal += p.getPeso();
		this.productos.add(new Producto(p.getDescripcion(),p.getPeso(),p.getPrecioPorKilo()));
	}

	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}
		
	public Ticket emitirTicket() {
		Ticket t= new Ticket(cantidadDeProductos, pesoTotal, precioTotal);
		return t;
	}
	
}
