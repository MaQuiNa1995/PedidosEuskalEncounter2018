package es.maqui.euskal.backend.repositorio;

import org.springframework.data.repository.CrudRepository;

import es.maqui.euskal.backend.modelo.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {

}