package es.maqui.euskal.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import es.maqui.euskal.backend.repository.Identificable;

@Entity
public class Pedido implements Identificable<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6553492524378565619L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "NOMBRE_USUARIO")
	private String nombreUsuario;
	
	@Column(name = "PEDIDO")
	private String pedido;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id=id;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}
	
}
