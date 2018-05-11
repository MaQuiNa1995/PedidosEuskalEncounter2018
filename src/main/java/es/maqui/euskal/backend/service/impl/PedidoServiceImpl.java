package es.maqui.euskal.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.maqui.euskal.backend.model.Pedido;
import es.maqui.euskal.backend.repository.PedidoRepository;
import es.maqui.euskal.backend.service.PedidoService;

@Service
@Transactional
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public Long aniadirVehiculo(Pedido pedidoNuevo) {

		return pedidoRepository.add(pedidoNuevo).getId();
	}

	@Override
	public Pedido actualizarVehiculo(Pedido pedidoModificado) {
		return pedidoRepository.update(pedidoModificado);
	}

	@Override
	public void borrarPedido(Long id) {
		pedidoRepository.delete(id);
	}

	@Override
	public Pedido obtenerVehiculo(Long id) {
		return pedidoRepository.read(id);
	}

	@Override
	public List<Pedido> obtenerPedidos() {
		return pedidoRepository.list();
	}

}
