import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContratoDePlantaTest {

    // Variables de instancia para los datos base
    private double sueldoMensual;
    private double montoConyuge;
    private double montoHijos;

    // Objetos instanciados en el BeforeEach para Antigüedad
    private ContratoDePlanta contrato9Anios;
    private ContratoDePlanta contrato10Anios;
    private ContratoDePlanta contrato11Anios;
    private Empleado empleadoBase;

    // Objetos instanciados en el BeforeEach para Cónyuge
    private ContratoDePlanta contratoConyuge;
    private Empleado empleadoSinConyuge;
    private Empleado empleadoConConyuge;

    // Objetos instanciados en el BeforeEach para Hijos
    private ContratoDePlanta contratoHijos;
    private Empleado empleadoSinHijos;
    private Empleado empleadoConHijos;

    @BeforeEach
    public void setUp() {
        this.sueldoMensual = 100000.0;
        this.montoConyuge = 5000.0;
        this.montoHijos = 4000.0;

        // --- Inicialización de objetos para testAntiguedad ---
        this.contrato9Anios = new ContratoDePlanta(LocalDate.now().minusYears(9), sueldoMensual, montoConyuge, montoHijos);
        this.contrato10Anios = new ContratoDePlanta(LocalDate.now().minusYears(10), sueldoMensual, montoConyuge, montoHijos);
        this.contrato11Anios = new ContratoDePlanta(LocalDate.now().minusYears(11), sueldoMensual, montoConyuge, montoHijos);
        this.empleadoBase = new Empleado("Juan", LocalDate.of(1990, 1, 1), 0, false);

        // --- Inicialización de objetos para testConyuge ---
        this.contratoConyuge = new ContratoDePlanta(LocalDate.now().minusYears(5), sueldoMensual, montoConyuge, montoHijos);
        this.empleadoSinConyuge = new Empleado("Ana", LocalDate.of(1992, 3, 10), 0, false);
        this.empleadoConConyuge = new Empleado("Carlos", LocalDate.of(1992, 3, 10), 0, true);

        // --- Inicialización de objetos para testHijos ---
        this.contratoHijos = new ContratoDePlanta(LocalDate.now().minusYears(5), sueldoMensual, montoConyuge, montoHijos);
        this.empleadoSinHijos = new Empleado("María", LocalDate.of(1995, 6, 20), 0, false);
        this.empleadoConHijos = new Empleado("Sofía", LocalDate.of(1995, 6, 20), 2, false);
    }

    @Test
    public void testAntiguedad() {
        // 1. Menos de 10 años (9 años -> 0% adicional)
        assertEquals(100000.0, contrato9Anios.calcularSueldoBasico(empleadoBase), 0.01);

        // 2. Borde exacto de 10 años (10 años -> 0% adicional)
        assertEquals(100000.0, contrato10Anios.calcularSueldoBasico(empleadoBase), 0.01);

        // 3. Más de 10 años (11 años -> +25% = 125.000)
        assertEquals(125000.0, contrato11Anios.calcularSueldoBasico(empleadoBase), 0.01);
    }

    @Test
    public void testConyuge() {
        // 1. Sin cónyuge (0% adicional)
        assertEquals(100000.0, contratoConyuge.calcularSueldoBasico(empleadoSinConyuge), 0.01);

        // 2. Con cónyuge (+5% sobre sueldo mensual = 105.000)
        assertEquals(105000.0, contratoConyuge.calcularSueldoBasico(empleadoConConyuge), 0.01);
    }

    @Test
    public void testHijos() {
        // 1. Sin hijos (0 adicional)
        assertEquals(100000.0, contratoHijos.calcularSueldoBasico(empleadoSinHijos), 0.01);

        // 2. Con hijos (2 hijos * 4.000 = +8.000 -> 108.000)
        assertEquals(108000.0, contratoHijos.calcularSueldoBasico(empleadoConHijos), 0.01);
    }
}
