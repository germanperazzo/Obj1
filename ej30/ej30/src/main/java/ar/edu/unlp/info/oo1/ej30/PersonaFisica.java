package ar.edu.unlp.info.oo1.ej30;

public class PersonaFisica extends Cliente {

	private String nombre;
    private String dni;

    public PersonaFisica(String direccion, String nombre, String dni) {
        super(direccion);
        this.nombre = nombre;
        this.dni = dni;
    }

    @Override
    public double aplicarDescuento(double montoBruto) {
        // 10% de descuento para personas físicas
        return montoBruto * 0.90;
    }
}
