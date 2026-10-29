package ar.edu.unlp.info.oo1.ej28;

import java.time.LocalDate;

public abstract class LibroImpreso extends Material {
	private String autor;
    private String ubicacion;

    public LibroImpreso(String titulo, LocalDate fechaIncorporacion,
                        String autor, String ubicacion) {
        super(titulo, fechaIncorporacion);
        this.autor = autor;
        this.ubicacion = ubicacion;
    }
}
