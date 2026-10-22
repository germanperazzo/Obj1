package ar.edu.unlp.info.oo1.ej27;

import java.util.ArrayList;
import java.util.List;

public class PedidoViandas extends Pedido {

	private List<Vianda> viandas;
    private boolean soloAptoCeliaco;

    public PedidoViandas(String email, FormaEntrega formaEntrega,
                         boolean soloAptoCeliaco, List<Vianda> viandas) {
        super(email, formaEntrega);
        this.viandas = new ArrayList<>(viandas);
        this.soloAptoCeliaco = soloAptoCeliaco;
    }

    public boolean agregarVianda(Vianda vianda) {
        if (!vianda.estaDisponible()) {
            return false;
        }

        if (this.soloAptoCeliaco && !vianda.esAptaCeliacos()) {
            return false;
        }

        if (this.calcularTiempoEstimado() >= 40) {
            return false;
        }

        return this.viandas.add(vianda);
    }

    @Override
    public double calcularCosto() {
        return this.viandas.stream()
                .mapToDouble(Vianda::getPrecio)
                .sum();
    }

}
