package ar.edu.unlp.info.oo1.ej29;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tarjeta implements MedioDePago {
	private String numero;
	private String titular;
	private LocalDate vencimiento;
	private List<Compra> compras;
	
	public Tarjeta(String numero, String titular, LocalDate vencimiento) {
        this.numero = numero;
        this.titular = titular;
        this.vencimiento = vencimiento;
        this.compras = new ArrayList<>();
    }
	
	
	@Override
	public boolean autorizarPago(double monto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void pagar(double monto) {
		// TODO Auto-generated method stub

	}

}
