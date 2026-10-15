package ar.edu.unlp.info.oo1.ej23;

public class PoliticaFlexible implements PoliticaCancelacion {

	 @Override
	    public double calcularReembolso(Reserva reserva) {
	        return reserva.costo();
	    }

}
