package ar.edu.unlp.info.oo1.ej34;

import java.util.Set;

public class PlanIndividual extends Plan{
	private int minutosContratados;

    public PlanIndividual(int minutosContratados) {
        super(1); 
        this.minutosContratados = minutosContratados;
    }

    @Override
    public double calcularPrecioBase() {
        return 20.0 * this.minutosContratados;
    }
    
    @Override
    public double evaluarPenalizacion(Set<String> ipsUtilizadas, int antiguedadAnios) {
        // Penaliza si utilizó más de una dirección IP distinta en el Set
        if (ipsUtilizadas.size() > 1) {
            int ipsAdicionales = ipsUtilizadas.size() - 1;
            return ipsAdicionales * 300.0;
        }
        return 0.0;
    }
}
