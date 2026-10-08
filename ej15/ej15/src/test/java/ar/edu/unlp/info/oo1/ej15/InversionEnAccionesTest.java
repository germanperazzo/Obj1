package ar.edu.unlp.info.oo1.ej15;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InversionEnAccionesTest {
	private InversionEnAcciones accion1;
	private InversionEnAcciones accion2;
	private InversionEnAcciones accion3;
	private InversionEnAcciones accion4;
	
	@BeforeEach
	void setUp() {
		accion1 = new InversionEnAcciones("meli", 10, 30);
		accion2 = new InversionEnAcciones("meli", 0, 30);
		accion3 = new InversionEnAcciones("meli", 10, 0);
		accion4 = new InversionEnAcciones("meli", 0, 0);
	}

	@Test
	void testValorActualConCantidadYValorUnitarioPositivos() {
		assertEquals(300, accion1.valorActual());
		
	}
	
	@Test
	void testValorActualConCantidadCero() {
		assertEquals(0, accion2.valorActual());
		
	}

	@Test
	void testValorActualConValorUnitarioCero() {
		assertEquals(0, accion3.valorActual());
		
	}

	@Test
	void testValorActualConCantidadYValorUnitarioCero() {
		assertEquals(0, accion4.valorActual());
		
	}

}
