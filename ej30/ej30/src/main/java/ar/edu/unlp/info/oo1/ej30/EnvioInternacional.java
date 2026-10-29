package ar.edu.unlp.info.oo1.ej30;

import java.time.LocalDate;

public class EnvioInternacional extends Envio {
	private String paisDestino;
    private boolean entregaRapida;

    public EnvioInternacional(LocalDate fechaDespacho, String direccionOrigen, String direccionDestino, double peso, String paisDestino, boolean entregaRapida) {
        super(fechaDespacho, direccionOrigen, direccionDestino, peso, entregaRapida);
        this.paisDestino = paisDestino;
        this.entregaRapida = entregaRapida;
    }

    @Override
    public double calcularCosto() {
        double costo = 5000.0; // Base para cualquier destino
        
        // Costo por peso (1 kg = 1000 gramos)
        if (getPeso() <= 1000) {
            costo += getPeso() * 10.0;
        } else {
            costo += getPeso() * 12.0;
        }
        
        // Adicional por entrega rápida
        if (entregaRapida) {
            costo += 800.0;
        }
        
        return costo;
    }

}
