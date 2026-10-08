package ar.edu.unlp.info.oo1.ej18;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;





class DateLapseTest {
	LocalDate desde;
	LocalDate hasta;
	
	LocalDate desde2;
	LocalDate hasta2;
	
	DateLapse periodo1;
	DateLapse periodo2;
	
	
	@BeforeEach
	void setUp() {
		
		desde = LocalDate.of(2026, 5, 1);
		 hasta = LocalDate.of(2026, 5, 30);

	
		 desde2 = LocalDate.of(2026, 5, 15);
		 hasta2 = LocalDate.of(2026, 5, 25);
		 
		 periodo1 = new DateLapse(desde, hasta);
		 periodo2 = new DateLapse(desde2, hasta2);
	}

	@Test
	void testSizeInDays() {
		assertEquals(29, periodo1.sizeInDays()); 
	    assertEquals(10, periodo2.sizeInDays());
	}

	@Test
	void testIncludesDate() {
		// Fechas dentro del rango
	    assertTrue(periodo1.includesDate(LocalDate.of(2026, 5, 15)));
	    
	    // Extremos (si tu método es inclusivo)
	    assertTrue(periodo1.includesDate(LocalDate.of(2026, 5, 1)));
	    assertTrue(periodo1.includesDate(LocalDate.of(2026, 5, 30)));

	    // Fuera del rango
	    assertFalse(periodo1.includesDate(LocalDate.of(2026, 4, 30)));
	    assertFalse(periodo1.includesDate(LocalDate.of(2026, 6, 1)));
	}
}
