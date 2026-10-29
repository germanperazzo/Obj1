package ar.edu.unlp.info.oo1.ej29;

public interface MedioDePago {
	public boolean autorizarPago(double monto);
	public void pagar(double monto);
}
