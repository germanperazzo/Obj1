package ar.edu.unlp.info.oo1.ej30;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnvioTest {

	// 1. Declaración de variables comunes (si las necesitamos reutilizar)
    private LocalDate fechaPrueba;

    // 2. Método @BeforeEach
    @BeforeEach
    void setUp() {
        fechaPrueba = LocalDate.of(2026, 6, 15);
    }

    @Test
    void testEnvioLocalEstandar() {
        Envio envio = new EnvioLocal(fechaPrueba, "Origen", "Destino", 500, false);
        assertEquals(1000.0, envio.calcularCosto());
    }

    @Test
    void testEnvioLocalRapido() {
        Envio envio = new EnvioLocal(fechaPrueba, "Origen", "Destino", 500, true);
        assertEquals(1500.0, envio.calcularCosto());
    }

    // --- ENVIOS INTERURBANOS: ESTUDIO DE LÍMITES EN 100 KM ---
    @Test
    void testEnvioInterurbanoBorde99km() {
        // Límite inferior por izquierda (< 100 km -> $20 por gramo). Peso: 100g -> 100 * 20 = 2000
        Envio envio = new EnvioInterurbano(fechaPrueba, "A", "B", 100, false,99);
        assertEquals(2000.0, envio.calcularCosto());
    }

    @Test
    void testEnvioInterurbanoBorde100km() {
        // Límite exacto (100 a 500 km -> $25 por gramo). Peso: 100g -> 100 * 25 = 2500
        Envio envio = new EnvioInterurbano(fechaPrueba, "A", "B", 100,false, 100);
        assertEquals(2500.0, envio.calcularCosto());
    }

    @Test
    void testEnvioInterurbanoBorde101km() {
        // Límite inferior por derecha (100 a 500 km -> $25 por gramo). Peso: 100g -> 100 * 25 = 2500
        Envio envio = new EnvioInterurbano(fechaPrueba, "A", "B", 100,false, 101);
        assertEquals(2500.0, envio.calcularCosto());
    }

    // --- ENVIOS INTERURBANOS: ESTUDIO DE LÍMITES EN 500 KM ---
    @Test
    void testEnvioInterurbanoBorde499km() {
        // Límite superior por izquierda (100 a 500 km -> $25 por gramo). Peso: 100g -> 100 * 25 = 2500
        Envio envio = new EnvioInterurbano(fechaPrueba, "A", "B", 100,false, 499);
        assertEquals(2500.0, envio.calcularCosto());
    }

    @Test
    void testEnvioInterurbanoBorde500km() {
        // Límite exacto superior (100 a 500 km -> $25 por gramo). Peso: 100g -> 100 * 25 = 2500
        Envio envio = new EnvioInterurbano(fechaPrueba, "A", "B", 100,false, 500);
        assertEquals(2500.0, envio.calcularCosto());
    }

    @Test
    void testEnvioInterurbanoBorde501km() {
        // Límite superior por derecha (> 500 km -> $30 por gramo). Peso: 100g -> 100 * 30 = 3000
        Envio envio = new EnvioInterurbano(fechaPrueba, "A", "B", 100,false, 501);
        assertEquals(3000.0, envio.calcularCosto());
    }

    // --- ENVIOS INTERNACIONALES: ESTUDIO DE LÍMITES EN 1000 GRAMOS (1 KG) ---
    @Test
    void testEnvioInternacionalBorde999gramos() {
        // Límite por izquierda (<= 1000g -> $10 por gramo). Base $5000 + (999 * $10) = 5000 + 9990 = 14990
        Envio envio = new EnvioInternacional(fechaPrueba, "A", "B", 999, "España", false);
        assertEquals(14990.0, envio.calcularCosto());
    }

    @Test
    void testEnvioInternacionalBorde1000gramos() {
        // Límite exacto (<= 1000g -> $10 por gramo). Base $5000 + (1000 * $10) = 15000
        Envio envio = new EnvioInternacional(fechaPrueba, "A", "B", 1000, "España", false);
        assertEquals(15000.0, envio.calcularCosto());
    }

    @Test
    void testEnvioInternacionalBorde1001gramos() {
        // Límite por derecha (> 1000g -> $12 por gramo). Base $5000 + (1001 * $12) = 5000 + 12012 = 17012
        Envio envio = new EnvioInternacional(fechaPrueba, "A", "B", 1001, "España", false);
        assertEquals(17012.0, envio.calcularCosto());
    }

    @Test
    void testEnvioInternacionalConEntregaRapida() {
        // 500g con entrega rápida -> Base 5000 + (500 * 10) + 800 = 10300
        Envio envio = new EnvioInternacional(fechaPrueba, "A", "B", 500, "España", true);
        assertEquals(10300.0, envio.calcularCosto());
    }
}
