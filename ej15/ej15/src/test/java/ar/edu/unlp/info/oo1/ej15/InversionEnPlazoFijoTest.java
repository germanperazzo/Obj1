package ar.edu.unlp.info.oo1.ej15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InversionEnPlazoFijoTest {
	private InversionEnPlazoFijo plazoFijo1;
	private InversionEnPlazoFijo plazoFijo2;
	private InversionEnPlazoFijo plazoFijo3;
	private InversionEnPlazoFijo plazoFijo4;
	
	@BeforeEach
	void setUp() {
		plazoFijo1 = new InversionEnPlazoFijo(LocalDate.of(2026, 9, 22), 100, 0.05);
		plazoFijo2 = new InversionEnPlazoFijo(LocalDate.of(2026, 9, 22),100,0);
		plazoFijo3 = new InversionEnPlazoFijo(LocalDate.now(),100,0.05);
		plazoFijo4 = new InversionEnPlazoFijo(LocalDate.of(2026, 9, 22),0,0.05);
	}

	@Test
	void testValorActual() {
		assertEquals(150, plazoFijo1.valorActual());
		
	}
	
	@Test
    void testValorActualConInteresCero() {
        
        assertEquals(100, plazoFijo2.valorActual());
    }

    @Test
    void testValorActualConFechaDeConstitucionHoy() {
        
        assertEquals(100, plazoFijo3.valorActual());
    }

    @Test
    void testValorActualConMontoCero() {
        
        assertEquals(0, plazoFijo4.valorActual());
    }

}
