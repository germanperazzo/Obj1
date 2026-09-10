package ar.edu.unlp.info.oo1.ej2;

public class Balanza {
	
	private List<Producto> productos;
	
	public List<Producto> getProductos(){
		return this.productos;
	}
	
	public void ponerEnCero()  {
		this.productos.clear();
	}
	
	public void agregarProducto(Producto p) {
		this.productos.add(new Producto(p.getDescripcion(),p.getPeso(),p.getPrecioPorKilo()));
	}

	public int getCantidadDeProductos() {
		return this.productos.size();
	}

	public double getPrecioTotal() {
		double precioTotal = 0;
		for (Producto producto: this.productos ){
			precioTotal += prodcuto.getPrecio();
		}
		return precioTotal;
	}

	public double getPesoTotal() {
		double pesoTotal = 0;
		for(Producto producto: this.productos){
			pesoTotal += producto.getPeso();
		}
		return pesoTotal;
	}
		
	public Ticket emitirTicket() {
		Ticket t= new Ticket(this.getCantidadDeProductos(), pesoTotal, precioTotal);
		return t;
	}
	
}
