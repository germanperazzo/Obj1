package ar.edu.unlp.info.oo1.ej22;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {

	Usuario usuario;
    Propiedad casa;
    Persona persona;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("Juan", "Calle 1", 12345678);
        casa = new Propiedad("Calle 2", "Casa", 2.1);
        persona = new Persona("Pedro", "Perez", "87654321");
    }
    
    
    @Test
    void testCalcularIngresosSinPropiedades() {
        DateLapse periodo = new DateLapse(
            LocalDate.of(2026, 11, 1),
            LocalDate.of(2026, 11, 10)
        );

        assertEquals(0.0, usuario.calcularIngresos(periodo), 0.001);
    }

    @Test
    void testCalcularIngresosConUnaPropiedad() {
        DateLapse reserva = new DateLapse(
            LocalDate.of(2026, 11, 1),
            LocalDate.of(2026, 11, 5)
        );

        DateLapse consulta = new DateLapse(
            LocalDate.of(2026, 11, 1),
            LocalDate.of(2026, 11, 10)
        );

        casa.crearReserva(persona, reserva);
        usuario.agregarPropiedad(casa);

        assertEquals(8.4, usuario.calcularIngresos(consulta), 0.001);
    }

    @Test
    void testCalcularIngresosConVariasPropiedades() {
        Propiedad departamento = new Propiedad("Calle 3", "Departamento", 5.0);

        DateLapse reservaCasa = new DateLapse(
            LocalDate.of(2026, 11, 1),
            LocalDate.of(2026, 11, 5)
        );

        DateLapse reservaDepartamento = new DateLapse(
            LocalDate.of(2026, 11, 2),
            LocalDate.of(2026, 11, 5)
        );

        DateLapse consulta = new DateLapse(
            LocalDate.of(2026, 11, 1),
            LocalDate.of(2026, 11, 10)
        );

        casa.crearReserva(persona, reservaCasa);
        departamento.crearReserva(persona, reservaDepartamento);

        usuario.agregarPropiedad(casa);
        usuario.agregarPropiedad(departamento);

        assertEquals(23.4, usuario.calcularIngresos(consulta), 0.001);
    }
}
