package ar.edu.unlp.info.oo1.ej27;

import java.time.LocalDateTime;

public class Delivery implements FormaEntrega {

	private String domicilio;
    private LocalDateTime fechaHoraEstimada;

    public Delivery(String domicilio, LocalDateTime fechaHoraEstimada) {
        this.domicilio = domicilio;
        this.fechaHoraEstimada = fechaHoraEstimada;
    }

    public String getDomicilio() {
        return this.domicilio;
    }

    public LocalDateTime getFechaHoraEstimada() {
        return this.fechaHoraEstimada;
    }

    @Override
    public int calcularTiempoEstimado() {
        // Pendiente: calcular el tiempo real mediante GPS,
        // tráfico y distancia.
        return 0;
    }
}
