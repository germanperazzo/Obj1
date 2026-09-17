package ar.edu.unlp.info.oo1.ej9;

import java.time.LocalDate;

public class Mamifero {
	private String identificador; 
	private String especie;
	private LocalDate fechaNacimiento;
	private Mamifero padre;
	private Mamifero madre;
	
	public Mamifero (String identificador) {
		this.identificador = identificador;
	}
	
	public Mamifero () {
		
	}
	
	public String getIdentificador() {
		return this.identificador;
	}
	public void setIdentificador(String id) {
		this.identificador = id;
	}
	
	public String getEspecie () {
		return this.especie;
	}
	public void setEspecie(String id) {
		this.especie = id;
	}
	
	public LocalDate getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fecha) {
		this.fechaNacimiento = fecha;
	}
	
	public Mamifero getPadre() {
		return this.padre;
	}
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	
	public Mamifero getMadre() {
		return this.madre;
	}
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	
	public Mamifero getAbueloMaterno() {
		return this.madre != null ? this.madre.getPadre() : null;
	}
	public Mamifero getAbuelaMaterna() {
		return this.madre != null ? this.madre.getMadre() : null;
	}
	
	public Mamifero getAbueloPaterno() {
		return this.padre != null ? this.padre.getPadre() : null;
	}
	public Mamifero getAbuelaPaterna() {
		return this.padre != null ? this.padre.getMadre() : null;
	}
	
	public boolean tieneComoAncestroA(Mamifero unMamifero) {
	    return (tieneAncestro(this.getMadre(), unMamifero) || tieneAncestro(this.getPadre(), unMamifero));
	}

	private boolean tieneAncestro(Mamifero parent, Mamifero unMamifero) {
	    return (parent != null) && (unMamifero.equals(parent) || parent.tieneComoAncestroA(unMamifero));
	}
}
