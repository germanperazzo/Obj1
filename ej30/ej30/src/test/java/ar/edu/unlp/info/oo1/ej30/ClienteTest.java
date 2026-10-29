package ar.edu.unlp.info.oo1.ej30;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {

	// 1. Declaración de variables
    private Cliente personaFisica;
    private Cliente clienteCorporativo;
    private LocalDate inicioPeriodo;
    private LocalDate finPeriodo;

    // 2. Método @BeforeEach
    @BeforeEach
    void setUp() {
        personaFisica = new PersonaFisica("Av. Siempre Viva 123", "Juan Pérez", "35123456");
        clienteCorporativo = new ClienteCorporativo("Av. Alem 500", "Empresa SA", "30-12345678-9");
        
        inicioPeriodo = LocalDate.of(2026, 6, 1);
        finPeriodo = LocalDate.of(2026, 6, 30);
    }

    // 3. Los tests
    @Test
    void testPersonaFisicaCalculaMontoConDescuentoEnPeriodo() {
        // Envío dentro del período (10 de Junio de 2026)
        Envio envio = new EnvioLocal(LocalDate.of(2026, 6, 10), "Origen", "Destino", 100, false);
        personaFisica.agregarEnvio(envio);

        // Monto bruto = $1000. Descuento de Persona Física (10%) -> $900.0
        assertEquals(900.0, personaFisica.calcularMontoTotal(inicioPeriodo, finPeriodo));
    }

    @Test
    void testClienteCorporativoCalculoSinDescuentoEnPeriodo() {
        // Envío dentro del período (15 de Junio de 2026)
        Envio envio = new EnvioLocal(LocalDate.of(2026, 6, 15), "Origen", "Destino", 100, false);
        clienteCorporativo.agregarEnvio(envio);

        // Monto bruto = $1000. Sin descuento -> $1000.0
        assertEquals(1000.0, clienteCorporativo.calcularMontoTotal(inicioPeriodo, finPeriodo));
    }

    @Test
    void testEnvioFueraDePeriodoNoSeSuma() {
        // Partición inválida por fecha: Envío en Julio (fuera del período de Junio)
        Envio envioFuera = new EnvioLocal(LocalDate.of(2026, 7, 5), "Origen", "Destino", 100, false);
        personaFisica.agregarEnvio(envioFuera);

        // Como está fuera de rango, el total debe ser 0.0
        assertEquals(0.0, personaFisica.calcularMontoTotal(inicioPeriodo, finPeriodo));
    }
}
