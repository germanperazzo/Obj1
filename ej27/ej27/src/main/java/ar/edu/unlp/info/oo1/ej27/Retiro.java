package ar.edu.unlp.info.oo1.ej27;

import java.time.Duration;
import java.time.LocalDateTime;

public class Retiro implements FormaEntrega {

	private String dniPersonaAutorizada;
    private LocalDateTime fechaHoraEstimada;

    public Retiro(String dniPersonaAutorizada,
                  LocalDateTime fechaHoraEstimada) {
        this.dniPersonaAutorizada = dniPersonaAutorizada;
        this.fechaHoraEstimada = fechaHoraEstimada;
    }

    public String getDniPersonaAutorizada() {
        return this.dniPersonaAutorizada;
    }

    public LocalDateTime getFechaHoraEstimada() {
        return this.fechaHoraEstimada;
    }

    @Override
    public int calcularTiempoEstimado() {
        return (int) Duration.between(
            LocalDateTime.now(), this.fechaHoraEstimada
        ).toMinutes();
    }

}
