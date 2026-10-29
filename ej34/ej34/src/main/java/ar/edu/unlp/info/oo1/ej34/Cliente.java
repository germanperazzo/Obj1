package ar.edu.unlp.info.oo1.ej34;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cliente {
	 private String nombre;
	 private LocalDate fechaAlta;
	 private Plan plan;
	 private List<Actividad> actividades;
	 
	 public Cliente(String nombre, LocalDate fechaAlta, Plan plan) {
	        this.nombre = nombre;
	        this.fechaAlta = fechaAlta;
	        this.plan = plan;
	        this.actividades = new ArrayList<>();
	    }
	 
	 public void agregarActividad(Actividad actividad) {
	        this.actividades.add(actividad);
	    }

	 public void cambiarPlan(Plan nuevoPlan) {
	        this.plan = nuevoPlan;
	    }
	    
	 public int calcularAntiguedadEnAnios() {
	        return Period.between(this.fechaAlta, LocalDate.now()).getYears();
	    }
	 
	 
	 public double getMontoActividades(DateLapse periodo) {
	        return this.actividades.stream()
	                .filter(a -> a.ocurreEn(periodo))
	                .mapToDouble(a -> a.calcularMonto())
	                .sum();
	    }
	 
	 public double getMontoTotal(DateLapse periodo) {
	        double precioBase = this.plan.calcularPrecioBase();
	        double montoActividades = getMontoActividades(periodo);
	        double montoPenalizacion = getMontoPenalizacion(periodo);

	        return precioBase + montoActividades + montoPenalizacion;
	    }
	 
	 public double getMontoPenalizacion(DateLapse periodo) {
	        
	        Set<String> ipsUtilizadas = this.actividades.stream()
	                .filter(a -> a.ocurreEn(periodo))
	                .map(Actividad::getDireccionIp)
	                .collect(Collectors.toSet()); 

	        int antiguedad = calcularAntiguedadEnAnios();
	        
	        
	        return this.plan.evaluarPenalizacion(ipsUtilizadas, antiguedad);
	    }
}
