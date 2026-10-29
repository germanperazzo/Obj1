package ar.edu.unlp.info.oo1.ej30;

import java.time.LocalDate;

public abstract class Envio {
	private LocalDate fechaDespacho;
    private String direccionOrigen;
    private String direccionDestino;
    private double peso; // expresado en gramos
    private boolean entregaRapida;
    
    
    public Envio(LocalDate fechaDespacho, 
    		String direccionOrigen, 
    		String direccionDestino, 
    		double peso,
    		boolean entregaRapida) {
    	
        this.fechaDespacho = fechaDespacho;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.peso = peso;
        this.entregaRapida = entregaRapida;
    }
    
    public String getDireccionOrigen() {
		return direccionOrigen;
	}

	public String getDireccionDestino() {
		return direccionDestino;
	}

	public boolean isEntregaRapida() {
		return entregaRapida;
	}

	public LocalDate getFechaDespacho() {
        return fechaDespacho;
    }

    public double getPeso() {
        return peso;
    }


    
	// Método abstracto polimórfico
    public abstract double calcularCosto();

    // Método para verificar si el envío está dentro de un período
    public boolean esEnFecha(LocalDate inicio, LocalDate fin) {
        return !fechaDespacho.isBefore(inicio) && !fechaDespacho.isAfter(fin);
    }

    
}
