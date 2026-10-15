package ar.edu.unlp.info.oo1.ej22;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropiedadTest {
	
	Propiedad casa;
	Persona persona;
	
	@BeforeEach
	void setUp()  {
		
		casa = new Propiedad("a", "a", 2.1);
		persona = new Persona("Juan", "perez", "123");
	}
	//tests de isDisponible.
	// tendria q hacer teset de es disonible con reserva sin superpuesta ?
	@Test
	void testIsDisponibleSinReservas() {
	    DateLapse periodo = new DateLapse(
	        LocalDate.of(2026, 10, 20),
	        LocalDate.of(2026, 10, 25)
	    );

	    assertTrue(casa.isDisponible(periodo));
	}

	@Test
	void testIsDisponibleConReservaSuperpuesta() {
	    DateLapse reserva = new DateLapse(
	        LocalDate.of(2026, 10, 20),
	        LocalDate.of(2026, 10, 25)
	    );

	    DateLapse consulta = new DateLapse(
	        LocalDate.of(2026, 10, 22),
	        LocalDate.of(2026, 10, 28)
	    );

	    casa.crearReserva(persona, reserva);

	    assertFalse(casa.isDisponible(consulta));
	}
	
	//test de crearReserva
	@Test
	void testCrearReservaDisponible() {
	    DateLapse periodo = new DateLapse(
	        LocalDate.of(2026, 10, 20),
	        LocalDate.of(2026, 10, 25)
	    );

	    assertTrue(casa.crearReserva(persona, periodo));
	}

	@Test
	void testCrearReservaNoDisponible() {
	    DateLapse periodo = new DateLapse(
	        LocalDate.of(2026, 10, 20),
	        LocalDate.of(2026, 10, 25)
	    );

	    casa.crearReserva(persona, periodo);

	    assertFalse(casa.crearReserva(persona, periodo));
	}
	
	// test de calcular 
	@Test
	void testCalcularIngresoSinReservas() {
	    DateLapse periodo = new DateLapse(
	        LocalDate.of(2026, 10, 20),
	        LocalDate.of(2026, 10, 25)
	    );

	    assertEquals(0.0, casa.calcularIngresoPropiedad(periodo), 0.001);
	}

	@Test
	void testCalcularIngresoConReservaSuperpuesta() {
	    DateLapse reserva = new DateLapse(
	        LocalDate.of(2026, 10, 20),
	        LocalDate.of(2026, 10, 25)
	    );

	    DateLapse consulta = new DateLapse(
	        LocalDate.of(2026, 10, 22),
	        LocalDate.of(2026, 10, 28)
	    );

	    casa.crearReserva(persona, reserva);

	    assertEquals(10.5, casa.calcularIngresoPropiedad(consulta), 0.001);
	}
	
	// canselar reserva 
	
	@Test
	void testCancelarReservaFutura() {
	    DateLapse periodo = new DateLapse(
	        LocalDate.of(2026, 11, 1),
	        LocalDate.of(2026, 11, 5)
	    );

	    casa.crearReserva(persona, periodo);

	    Reserva reserva = new Reserva(periodo, casa, persona);

	    assertTrue(casa.cancelarReserva(reserva));
	    assertTrue(casa.isDisponible(periodo));
	}
	
	@Test
	void testCancelarReservaEnCurso() {
	    LocalDate hoy = LocalDate.now();

	    DateLapse periodo = new DateLapse(
	        hoy.minusDays(2),
	        hoy.plusDays(3)
	    );

	    casa.crearReserva(persona, periodo);

	    Reserva reserva = new Reserva(periodo, casa, persona);

	    assertFalse(casa.cancelarReserva(reserva));
	    assertFalse(casa.isDisponible(periodo));
	}
}
