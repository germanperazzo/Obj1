package ar.edu.unlp.info.oo1.ej22;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTest {
	
	Propiedad casa;
    Persona persona;
    Reserva reserva;
	
	@BeforeEach
	void setUp() {
		
		casa = new Propiedad("a", "a", 2.1);
        persona = new Persona("Juan", "Perez", "12345678");

        DateLapse periodo = new DateLapse(
            LocalDate.of(2026, 11, 1),
            LocalDate.of(2026, 11, 5)
        );

        reserva = new Reserva(periodo, casa, persona);
		
	}

	// overlaps
	@Test
	void testOverlaps() {
	    DateLapse periodo = new DateLapse(
	        LocalDate.of(2026, 11, 3),
	        LocalDate.of(2026, 11, 7)
	    );

	    assertTrue(reserva.overlaps(periodo));
	}
	
	@Test
	void testNoOverlaps() {
	    DateLapse periodo = new DateLapse(
	        LocalDate.of(2026, 11, 10),
	        LocalDate.of(2026, 11, 15)
	    );

	    assertFalse(reserva.overlaps(periodo));
	}
	
	// costo
	
	@Test
	void testCosto() {
	    assertEquals(8.4, reserva.costo(), 0.001);
	}
	
	// encurso
	
	@Test
	void testEstaEnCurso() {
	    DateLapse periodo = new DateLapse(
	        LocalDate.of(2026, 10, 10),
	        LocalDate.of(2026, 10, 20)
	    );

	    Reserva reservaActual = new Reserva(periodo, casa, persona);

	    assertTrue(reservaActual.estaEnCurso());
	}

	@Test
	void testNoEstaEnCurso() {
	    assertFalse(reserva.estaEnCurso());
	}
}
