package ar.edu.unlp.info.oo1.ej12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransferirTest {
	private CajaDeAhorro cajaDeAhorro;
	private CuentaCorriente cuentaCorriente;
	
	@BeforeEach
	void setUp() throws Exception {
		cajaDeAhorro = new CajaDeAhorro();
		cuentaCorriente = new CuentaCorriente();
	}

	@Test
	void testCuentaCorrienteACajaDeAhorro() {
		cuentaCorriente.setDescubirto(200);
		assertFalse(cuentaCorriente.transferirACuenta(300, cajaDeAhorro));
		assertEquals(0, cajaDeAhorro.getSaldo());
		assertEquals(0, cuentaCorriente.getSaldo());
		
		assertTrue(cuentaCorriente.transferirACuenta(100, cajaDeAhorro));
		assertEquals(98, cajaDeAhorro.getSaldo());
		assertEquals(-100, cuentaCorriente.getSaldo());
	}
	
	@Test
	void testCajaDeAhorroACuentaCorriente() {
		cajaDeAhorro.depositar(100);
		assertEquals(98, cajaDeAhorro.getSaldo() );
		
		assertFalse(cajaDeAhorro.transferirACuenta(98, cuentaCorriente));
		assertEquals(98, cajaDeAhorro.getSaldo() );
		assertEquals(0, cuentaCorriente.getSaldo() );
		
		assertTrue(cajaDeAhorro.transferirACuenta(50, cuentaCorriente));
		assertEquals(47, cajaDeAhorro.getSaldo() );
		assertEquals(50, cuentaCorriente.getSaldo() );
	}
	
}
