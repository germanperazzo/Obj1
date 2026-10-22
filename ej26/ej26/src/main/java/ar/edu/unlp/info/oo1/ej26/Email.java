package ar.edu.unlp.info.oo1.ej26;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Email {
	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;
	private LocalDate fechaRecepcion;
	
	public Email(String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.adjuntos = new ArrayList<Archivo>();
		this.fechaRecepcion = LocalDate.now();
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getCuerpo() {
		return this.cuerpo;
	}
	public List<Archivo> adjuntos(){
		return this.adjuntos;
	}
	
	public int espacioOcupado() {
		return this.titulo.length() 
			 + this.cuerpo.length() 
			 + this.adjuntos.stream()
			 				.mapToInt(Archivo::tamaño)
			 				.sum();
	}
	
	public boolean contiene(String texto) {
		return this.getCuerpo().contains(texto) || this.getTitulo().contains(texto);
	}
	
	public LocalDate getFechaRecepcion() {
	    return this.fechaRecepcion;
	}
	
	
	
}
