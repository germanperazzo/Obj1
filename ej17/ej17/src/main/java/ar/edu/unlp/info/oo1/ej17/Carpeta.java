package ar.edu.unlp.info.oo1.ej17;

import java.util.ArrayList;
import java.util.List;



public class Carpeta {
	private String nombre;
	private List<Email> emails;
	
	
	public Carpeta(String nombre) {
		this.nombre = nombre;
		this.emails = new ArrayList<Email>();
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public List<Email> getEmails() {
		return emails;
	}
	
	public void agregarCorreo(Email email) {
		this.emails.add(email);
	}
	
	public void removerCorreo(Email email) {
		this.emails.remove(email);
	}
	
	public void mover(Email email, Carpeta destino) {
		this.removerCorreo(email);
		destino.agregarCorreo(email);
	}
	
	public int espacioOcupado() {
		return this.emails
				   .stream()
				   .mapToInt(Email::espacioOcupado)
				   .sum();
	}
	
	public Email buscar(String texto) {
		return this.emails
				   .stream()
				   .filter(e -> e.contiene(texto))
				   .findFirst().orElse(null);
	}
}
