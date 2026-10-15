package ar.edu.unlp.info.oo1.ej23;

import java.time.LocalDate;

public class PoliticaModerada implements PoliticaCancelacion {

	@Override
    public double calcularReembolso(Reserva reserva) {
        long dias = java.time.temporal.ChronoUnit.DAYS.between(
            LocalDate.now(), reserva.getPeriodoFrom()
        );

        if (dias >= 7) {
            return reserva.costo();
        }

        if (dias >= 2) {
            return reserva.costo() * 0.5;
        }

        return 0;
    }

}
