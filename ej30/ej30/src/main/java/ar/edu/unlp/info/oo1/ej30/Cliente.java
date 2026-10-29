package ar.edu.unlp.info.oo1.ej30;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	private String direccion;
    private List<Envio> envios;

    public Cliente(String direccion) {
        this.direccion = direccion;
        this.envios = new ArrayList<>();
    }
    
    public void agregarEnvio(Envio unEnvio) {
        this.envios.add(unEnvio);
    }
    
    
    public double calcularMontoTotal(LocalDate inicio, LocalDate fin) {
    	double montoBruto = envios.stream()
    			.filter(e -> e.esEnFecha(inicio, fin))
    			.mapToDouble(Envio::calcularCosto)
                .sum();
    	
    	return aplicarDescuento(montoBruto);
    }
    
    public abstract double aplicarDescuento(double montoBruto);
}
