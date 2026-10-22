package ar.edu.unlp.info.oo1.ej27;

public class ArticuloSupermercado extends Producto {
	private String categoria;
    private double peso;
    private int stockActual;

    public ArticuloSupermercado(String nombre, double precio,
                                String categoria, double peso,
                                int stockActual) {
        super(nombre, precio);
        this.categoria = categoria;
        this.peso = peso;
        this.stockActual = stockActual;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public double getPeso() {
        return this.peso;
    }

    public int getStockActual() {
        return this.stockActual;
    }
}
