package ar.edu.unlp.info.oo1.ej17;

import java.util.ArrayList;
import java.util.List;



public class ClienteDeCorreo {
	
	private Carpeta inbox;
	private List<Carpeta> carpetas;
	
	public ClienteDeCorreo(String nombre) {
		this.inbox = new Carpeta(nombre);
		this.carpetas = new ArrayList<Carpeta>();
		this.carpetas.add(this.inbox);
	}
	
	public Carpeta getInbox() {
		return inbox;
	}

	public List<Carpeta> getCarpetas() {
		return carpetas;
	}
	
	public void agregarCarpeta(Carpeta carpeta) {
		this.carpetas.add(carpeta);
	}

	public void recibir(Email email) {
		this.inbox.agregarCorreo(email);
	}
	
	public int espacioOcupado() {
		return this.carpetas
				   .stream()
				   .mapToInt(Carpeta::espacioOcupado)
				   .sum();
	}
	
	public Email buscar(String texto) {
		return this.carpetas
				   .stream()
				   .map(c -> c.buscar(texto))
				   .filter(e -> e != null)
				   .findFirst().orElse(null);
	}
}
