package ar.edu.unlp.info.oo1.ej28;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Material {
	private String titulo;
	private LocalDate fechaIncorporacion;
	
	 public Material(String titulo, LocalDate fechaIncorporacion) {
	        this.titulo = titulo;
	        this.fechaIncorporacion = fechaIncorporacion;
	    }

	  

		public Integer antiguedad() {
	        return (int) ChronoUnit.YEARS.between(
	            fechaIncorporacion, LocalDate.now()
	        );
	    }

	    public Boolean incorporadoAntesDe(Integer anio) {
	        return fechaIncorporacion.getYear() < anio;
	    }
	
}
