package ar.edu.unlp.info.oo1.ej34;

import java.util.Set;

public abstract class Plan {
	protected int limiteIps;

    public Plan(int limiteIps) {
        this.limiteIps = limiteIps;
    }
    
    public abstract double calcularPrecioBase();
    
    public abstract double evaluarPenalizacion(Set<String> ipsUtilizadas, int antiguedadAnios);
    
    public int getLimiteIps() {
        return limiteIps;
    }
}
