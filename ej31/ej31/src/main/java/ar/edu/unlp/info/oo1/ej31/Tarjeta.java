package ar.edu.unlp.info.oo1.ej31;

public class Tarjeta implements MedioPago {
	
	
	
	@Override
	public double calcularComision(double monto) {
		// TODO Auto-generated method stub
		return monto * 0.03;
	}

}
