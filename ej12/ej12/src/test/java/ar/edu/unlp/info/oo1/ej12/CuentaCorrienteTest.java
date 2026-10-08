package ar.edu.unlp.info.oo1.ej12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaCorrienteTest {
	
	private CuentaCorriente cuentaCorriente1;
	private CuentaCorriente cuentaCorriente2;
	
	@BeforeEach
	void setUp() {
		cuentaCorriente1 = new CuentaCorriente();
		cuentaCorriente2 = new CuentaCorriente();
	}
	
	@Test
	void testDepositar() {
		cuentaCorriente1.depositar(100);
		assertEquals(100, cuentaCorriente1.getSaldo() );
	}
	
	@Test
	void testExtraer1() {
		cuentaCorriente1.setDescubirto(500);
		assertTrue(cuentaCorriente1.extraer(300));
		assertEquals(-300, cuentaCorriente1.getSaldo());
		
	}
	
	@Test
	void testExtraer2() {
		cuentaCorriente1.setDescubirto(500);
		assertFalse(cuentaCorriente1.extraer(600));
		assertEquals(0, cuentaCorriente1.getSaldo());
		
	}
	
	@Test
	void testTransferir() {
		cuentaCorriente1.setDescubirto(200);
		assertFalse(cuentaCorriente1.transferirACuenta(300, cuentaCorriente2));
		assertEquals(0, cuentaCorriente2.getSaldo());
		assertEquals(0, cuentaCorriente1.getSaldo());
		
		assertTrue(cuentaCorriente1.transferirACuenta(100, cuentaCorriente2));
		assertEquals(100, cuentaCorriente2.getSaldo());
		assertEquals(-100, cuentaCorriente1.getSaldo());
		
	}

}
