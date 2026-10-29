package ar.edu.unlp.info.oo1.ej34;

public class ItemJuego {
	private String nombre;
    private int cantidad;
    private double precioUnitario;

    public ItemJuego(String nombre, int cantidad, double precioUnitario) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public double precioFinal() {
        return this.cantidad * this.precioUnitario;
    }
}
