package ar.edu.unlp.info.oo1.ej34;

import java.util.Set;

public class PlanGrupal extends Plan {
	public PlanGrupal(int limiteIpsMaximo) {
        super(limiteIpsMaximo);
    }

	@Override
	public double calcularPrecioBase() {
		
		return 800.0 * this.limiteIps;
	}

	@Override
	public double evaluarPenalizacion(Set<String> ipsUtilizadas, int antiguedadAnios) {
		// Si la antigüedad es mayor a 10 años, no hay penalización
        if (antiguedadAnios > 10) {
            return 0.0;
        }
        // Si el tamaño del Set supera el límite contratado
        if (ipsUtilizadas.size() > this.limiteIps) {
            int ipsAdicionales = ipsUtilizadas.size() - this.limiteIps;
            return ipsAdicionales * 500.0;
        }
        return 0.0;
	}
}
