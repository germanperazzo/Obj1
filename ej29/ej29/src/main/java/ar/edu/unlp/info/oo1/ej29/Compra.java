package ar.edu.unlp.info.oo1.ej29;

import java.time.LocalDate;

public class Compra {
	private LocalDate fecha;
    private double monto;

    public Compra(LocalDate fecha, double monto) {
        this.fecha = fecha;
        this.monto = monto;
    }
}
