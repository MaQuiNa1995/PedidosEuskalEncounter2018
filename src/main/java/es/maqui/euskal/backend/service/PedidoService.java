package es.maqui.euskal.backend.service;

import java.util.List;

import es.maqui.euskal.backend.model.Pedido;

public interface PedidoService {
	Long aniadirVehiculo(Pedido pedidoNuevo);

	Pedido actualizarVehiculo(Pedido pedidoModificado);

	void borrarPedido(Long id);

	Pedido obtenerVehiculo(Long id);

	List<Pedido> obtenerPedidos();
}
