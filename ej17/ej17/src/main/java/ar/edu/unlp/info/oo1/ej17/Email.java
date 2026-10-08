package ar.edu.unlp.info.oo1.ej17;

import java.util.ArrayList;
import java.util.List;


public class Email {
	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;
	
	public Email(String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.adjuntos = new ArrayList<Archivo>();
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
	
}
