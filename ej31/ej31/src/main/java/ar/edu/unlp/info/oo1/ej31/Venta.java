package ar.edu.unlp.info.oo1.ej31;

public class Venta {
	private double monto;
    private MedioPago medioPago;

    public Venta(double monto, MedioPago medioPago) {
        this.monto = monto;
        this.medioPago = medioPago;
    }

    public double getMonto() {
        return monto;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }
    
    public class CalculadorComision {
        public double calcular(Venta venta) {
            // Delega el cálculo al polimorfismo del medio de pago
            return venta.getMedioPago().calcularComision(venta.getMonto());
        }
    }
    
}
