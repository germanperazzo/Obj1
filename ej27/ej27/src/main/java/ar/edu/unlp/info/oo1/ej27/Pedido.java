package ar.edu.unlp.info.oo1.ej27;

import java.time.LocalDateTime;

public abstract class Pedido {
	private String email;
    private LocalDateTime fechaHoraCreacion;
    private FormaEntrega formaEntrega;

    public Pedido(String email, FormaEntrega formaEntrega) {
        this.email = email;
        this.fechaHoraCreacion = LocalDateTime.now();
        this.formaEntrega = formaEntrega;
    }

    public String getEmail() {
        return this.email;
    }

    public LocalDateTime getFechaHoraCreacion() {
        return this.fechaHoraCreacion;
    }

    public FormaEntrega getFormaEntrega() {
        return this.formaEntrega;
    }

    public abstract double calcularCosto();

    public int calcularTiempoEstimado() {
        return this.formaEntrega.calcularTiempoEstimado();
    }
}
