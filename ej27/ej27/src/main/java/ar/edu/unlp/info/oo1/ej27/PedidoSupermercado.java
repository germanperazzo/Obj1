package ar.edu.unlp.info.oo1.ej27;

import java.util.ArrayList;
import java.util.List;

public class PedidoSupermercado extends Pedido {

	private List<ArticuloSupermercado> articulos;
    private boolean cuponDescuento;

    public PedidoSupermercado(String email, FormaEntrega formaEntrega,
                              boolean cuponDescuento,List<ArticuloSupermercado> articulos) {
        super(email, formaEntrega);
        this.articulos = new ArrayList<>(articulos);
        this.cuponDescuento = cuponDescuento;
    }

    public boolean agregarArticulo(ArticuloSupermercado articulo) {
        if (articulo.getStockActual() <= 0) {
            return false;
        }

        if (this.calcularPeso() + articulo.getPeso() > 35) {
            return false;
        }

        return this.articulos.add(articulo);
    }

    @Override
    public double calcularCosto() {
        double total = this.articulos.stream()
        		.mapToDouble(ArticuloSupermercado::getPrecio)
        		.sum();
        
        return this.cuponDescuento ? total * 0.90 : total;
    }

    public double calcularPeso() {
        return this.articulos.stream()
                .mapToDouble(ArticuloSupermercado::getPeso)
                .sum();
    }
}
