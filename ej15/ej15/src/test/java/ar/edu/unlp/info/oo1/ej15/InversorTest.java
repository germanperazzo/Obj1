package ar.edu.unlp.info.oo1.ej15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InversorTest {
	private Inversor inversor;
	private InversionEnAcciones accion;
	private InversionEnPlazoFijo plazoFijo;
	
	@BeforeEach
	void setUp() {
		inversor = new Inversor("Matias");
		accion = new InversionEnAcciones("meli", 10, 30);
		plazoFijo = new InversionEnPlazoFijo(LocalDate.of(2026, 10, 10), 100, 0.05);
	}

	@Test
	void testValorActual() {
		inversor.agregarInversion(accion);
        inversor.agregarInversion(plazoFijo);

        assertEquals(450, inversor.valorActual());
	}

}
