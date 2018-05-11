package es.maqui.euskal.backend.repository.impl;

import org.springframework.stereotype.Repository;

import es.maqui.euskal.backend.model.Pedido;
import es.maqui.euskal.backend.repository.PedidoRepository;

@Repository
public class PedidoRepositoryImpl extends RepositorioGenericoImpl<Long, Pedido> implements PedidoRepository {

	public static final String NOMBRE_TABLA = "PEDIDOS";

	@Override
	public Class<Pedido> getClassDeT() {
		return Pedido.class;
	}

	@Override
	public String getNombreTabla() {
		return NOMBRE_TABLA;
	}


}
