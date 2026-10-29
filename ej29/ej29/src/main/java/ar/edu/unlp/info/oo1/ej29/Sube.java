package ar.edu.unlp.info.oo1.ej29;

public class Sube {
	private double saldo;
	
	public boolean autorizarPago(double monto) {
        return this.saldo >= monto;
    }
	
	public void pagar(double monto) {
        if(autorizarPago(monto)) {
        	this.saldo -= monto;
        }
    }
	
	public boolean recargar(double monto, MedioDePago medioPago) {
        if (medioPago.autorizarPago(monto)) {
            this.saldo = this.saldo + monto;
            medioPago.pagar(monto);
            return true;
        }
        return false;
    }
}
