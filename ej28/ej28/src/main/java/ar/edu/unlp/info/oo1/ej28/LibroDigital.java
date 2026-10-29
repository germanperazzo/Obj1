package ar.edu.unlp.info.oo1.ej28;

import java.time.LocalDate;

public class LibroDigital extends Material implements Descargable {
	private String autor;
    private String nombreArchivo;
    private double pesoArchivoMB;
	
	
	public LibroDigital(String titulo, LocalDate fechaIncorporacion,
            String autor, String nombreArchivo,
            double pesoArchivoMB) {
		super(titulo, fechaIncorporacion);
		this.autor = autor;
        this.nombreArchivo = nombreArchivo;
        this.pesoArchivoMB = pesoArchivoMB;
	}
	
	@Override
    public String enlaceDeDescarga() {
        return "https://biblioteca.example.org/descargas/libros/"
                + nombreArchivo;
    }

    @Override
    public double tamanioEnMB() {
        return pesoArchivoMB;
    }
}
