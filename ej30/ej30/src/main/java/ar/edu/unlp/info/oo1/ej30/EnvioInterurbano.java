package ar.edu.unlp.info.oo1.ej30;

import java.time.LocalDate;

public class EnvioInterurbano extends Envio {
	private double distancia;
	
	public EnvioInterurbano(LocalDate fechaDespacho, String direccionOrigen, String direccionDestino, double peso,
			boolean entregaRapida,double distancia) {
		super(fechaDespacho, direccionOrigen, direccionDestino, peso, entregaRapida);
		this.distancia = distancia;
	}

	
	@Override
	public double calcularCosto() {
		if (distancia < 100) {
            return getPeso() * 20.0;
        } else if (distancia <= 500) {
            return getPeso() * 25.0;
        } else {
            return getPeso() * 30.0;
        }
	}

}
