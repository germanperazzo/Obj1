package ar.edu.unlp.info.oo1.ej27;

public class Vianda extends Producto {
	private boolean aptaCeliacos;
    private boolean disponible;

    public Vianda(String nombre, double precio,
                  boolean aptaCeliacos, boolean disponible) {
        super(nombre, precio);
        this.aptaCeliacos = aptaCeliacos;
        this.disponible = disponible;
    }

    public boolean esAptaCeliacos() {
        return this.aptaCeliacos;
    }

    public boolean estaDisponible() {
        return this.disponible;
    }
}
