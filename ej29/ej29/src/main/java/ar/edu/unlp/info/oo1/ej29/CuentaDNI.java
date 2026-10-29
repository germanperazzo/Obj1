package ar.edu.unlp.info.oo1.ej29;

import java.util.List;

public class CuentaDNI implements MedioDePago{
	private String sucursal;
    private String numero;
    private double saldo;
    
    
    
    @Override
    public boolean autorizarPago(double monto) {
        return this.saldo >= monto;
    }

    @Override
    public void pagar(double monto) {
        this.saldo = this.saldo - monto;
    }
    
    
}
