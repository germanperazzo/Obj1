package ar.edu.unlp.info.oo1.ej12;

public class CajaDeAhorro extends Cuenta {
	public CajaDeAhorro() {
		super();
	}
	
	// no se esto si se tieen q hacer 
	public CajaDeAhorro(double saldo) {
		super.depositar(saldo);
	}
	
	@Override
    public void depositar(double monto) {
        super.depositar(monto * 0.98);
    }
	
	 @Override
	    protected void extraerSinControlar(double monto) {
	        super.extraerSinControlar(monto * 1.02);
	}
	
	@Override
	protected boolean puedeExtraer(double monto) {
		return this.getSaldo() >= monto*1.02;
	}

}
