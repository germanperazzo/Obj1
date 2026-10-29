package ar.edu.unlp.info.oo1.ej31;

public class Transferencia implements MedioPago {

	@Override
	public double calcularComision(double monto) {
		// TODO Auto-generated method stub
		return monto * 0.01;
	}

}
