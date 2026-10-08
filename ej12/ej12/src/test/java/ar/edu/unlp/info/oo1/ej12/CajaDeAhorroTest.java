package ar.edu.unlp.info.oo1.ej12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CajaDeAhorroTest {
	
	private CajaDeAhorro cajaDeAhorro1;
	private CajaDeAhorro cajaDeAhorro2;
	
	@BeforeEach
	void setUp()  {
		cajaDeAhorro1 = new CajaDeAhorro();
		cajaDeAhorro2 = new CajaDeAhorro();
	}
	
	@Test
	void testDepositar() {
		cajaDeAhorro1.depositar(100);
		assertEquals(98, cajaDeAhorro1.getSaldo() );
	}
	
	@Test
	void testExtraer() {
		cajaDeAhorro1.depositar(100);
		cajaDeAhorro1.extraer(50);
		assertEquals(47, cajaDeAhorro1.getSaldo());
		assertFalse(cajaDeAhorro1.extraer(100));
	}
	
	@Test
	void testTransferirACuenta() {
		cajaDeAhorro1.depositar(100);
		assertEquals(98, cajaDeAhorro1.getSaldo() );
		
		assertFalse(cajaDeAhorro1.transferirACuenta(98, cajaDeAhorro2));
		assertEquals(98, cajaDeAhorro1.getSaldo() );
		assertEquals(0, cajaDeAhorro2.getSaldo() );
		
		assertTrue(cajaDeAhorro1.transferirACuenta(50, cajaDeAhorro2));
		assertEquals(47, cajaDeAhorro1.getSaldo() );
		assertEquals(49, cajaDeAhorro2.getSaldo() );
		
	}

}
