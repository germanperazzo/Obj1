package ar.edu.unlp.info.oo1.ej26;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;




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
	
	public int cantidadDeEmails() {
	    return this.emails.size();
	}
	
	public Bag<CategoriaEmail> cantidadPorCategoria() {
	    Bag<CategoriaEmail> resultado = new BagImpl<>();

	    for (Email email : this.emails) {
	        int tamaño = email.espacioOcupado();

	        if (tamaño <= 300) {
	            resultado.add(CategoriaEmail.PEQUENO);
	        } else if (tamaño <= 500) {
	            resultado.add(CategoriaEmail.MEDIANO);
	        } else {
	            resultado.add(CategoriaEmail.GRANDE);
	        }
	    }

	    return resultado;
	}
	
	public String reportePorDia() {
	    Bag<LocalDate> fechas = new BagImpl<>();
	    Set<LocalDate> dias = new TreeSet<>();

	    for (Email email : this.emails) {
	        LocalDate fecha = email.getFechaRecepcion();

	        fechas.add(fecha);
	        dias.add(fecha);
	    }

	    DateTimeFormatter formatter =
	            DateTimeFormatter.ofPattern("dd/MM/yyyy");

	    StringBuilder reporte = new StringBuilder();

	    for (LocalDate dia : dias) {
	        if (reporte.length() > 0) {
	            reporte.append("\n");
	        }

	        reporte.append(dia.format(formatter))
	               .append(" - ")
	               .append(fechas.occurrencesOf(dia))
	               .append(" emails");
	    }

	    return reporte.toString();
	}
	
}
