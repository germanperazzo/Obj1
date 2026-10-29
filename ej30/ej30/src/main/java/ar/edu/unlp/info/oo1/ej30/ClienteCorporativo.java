package ar.edu.unlp.info.oo1.ej30;

public class ClienteCorporativo extends Cliente {

	private String nombreEmpresa;
    private String cuit;

    public ClienteCorporativo(String direccion, String nombreEmpresa, String cuit) {
        super(direccion);
        this.nombreEmpresa = nombreEmpresa;
        this.cuit = cuit;
    }

    @Override
    public double aplicarDescuento(double montoBruto) {
        // Los clientes corporativos no tienen este descuento especial por defecto
        return montoBruto;
    }
}
