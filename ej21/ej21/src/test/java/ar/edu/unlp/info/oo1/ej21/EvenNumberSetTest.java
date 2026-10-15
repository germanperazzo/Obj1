package ar.edu.unlp.info.oo1.ej21;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EvenNumberSetTest {
	
	EvenNumberSet numbers;
	
	@BeforeEach
	void setUp()  {
		
		numbers = new EvenNumberSet();
	}

	@Test
	void testAgregarPar() {

	    assertTrue(numbers.add(4));
	    assertTrue(numbers.contains(4));
	}
	
	@Test
	void testNoAgregarImpar() {
		assertFalse(numbers.add(3));
	    assertFalse(numbers.contains(3));
	}
	
	@Test
	void testNoAgregarDuplicado() {
		numbers.add(4);

	    assertFalse(numbers.add(4));
	    assertEquals(1, numbers.size());
	}
}
