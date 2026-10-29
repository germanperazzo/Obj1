package ar.edu.unlp.info.oo1.ej28;

import java.time.LocalDate;

public class RevistaDigital extends Material implements Descargable{
	private Integer numero;
    private String nombreArchivo;
    private double pesoArchivoMB;
	
    

	public RevistaDigital(String titulo, LocalDate fechaIncorporacion, Integer numero, String nombreArchivo,
			double pesoArchivoMB) {
		super(titulo, fechaIncorporacion);
		this.numero = numero;
		this.nombreArchivo = nombreArchivo;
		this.pesoArchivoMB = pesoArchivoMB;
	}
    
	@Override
    public String enlaceDeDescarga() {
        return "https://biblioteca.example.org/descargas/revistas/"
                + nombreArchivo;
    }

    @Override
    public double tamanioEnMB() {
        return pesoArchivoMB;
    }
}
