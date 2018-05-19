package es.maqui.euskal.backend.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PEDIDO")
public class Pedido {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "NOMBRE_USUARIO")
	private String nombreUsuario;

	@Column(name = "LISTA")
	private String lista;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getLista() {
		return lista;
	}

	public void setLista(String lista) {
		this.lista = lista;
	}

}