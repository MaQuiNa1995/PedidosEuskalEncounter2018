package es.maqui.euskal.backend.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.maqui.euskal.backend.modelo.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

}