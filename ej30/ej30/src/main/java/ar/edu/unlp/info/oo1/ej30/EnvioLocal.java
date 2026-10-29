package ar.edu.unlp.info.oo1.ej30;

import java.time.LocalDate;

public class EnvioLocal extends Envio {
	
	
	
	public EnvioLocal(LocalDate fechaDespacho, 
			String direccionOrigen, 
			String direccionDestino, 
			double peso,
			boolean entregaRapida) {
		
		super(fechaDespacho, direccionOrigen, direccionDestino, peso, entregaRapida);
	}

	@Override
	public double calcularCosto() {
		double costo = 1000.0; // Costo fijo base
        if (this.isEntregaRapida()) {
            costo += 500.0;
        }
        return costo;
	}

}
