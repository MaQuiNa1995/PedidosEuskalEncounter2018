package es.maqui.euskal.backend.frontend.principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import es.maqui.euskal.backend.modelo.Pedido;
import es.maqui.euskal.backend.repositorio.PedidoRepository;

public class VentanaPedidos extends VerticalLayout {

	@Autowired
	private PedidoRepository pedidoRepository;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger LOG = Logger.getLogger(VentanaPedidos.class.getName());

	private TextField textUsuario;
	private TextArea areaPedidos;
	private Button buttonEnviar;

	public VentanaPedidos() {
		instanciarComponentes();

		buttonEnviar.addClickListener(e -> {

			String nombreUsuario = textUsuario.getValue();
			String pedidosLista = areaPedidos.getValue();

			if (!nombreUsuario.isEmpty() && (!pedidosLista.isEmpty())) {

				Pedido pedido = new Pedido();
				pedido.setLista(pedidosLista);
				pedido.setNombreUsuario(nombreUsuario);
				
				pedidoRepository.save(pedido);

			} else {
				Notification.show("Ni el nombre ni los pedidos pueden ser nulos");
			}
		});

		this.addComponents(textUsuario, areaPedidos, buttonEnviar);
	}

	private void instanciarComponentes() {
		textUsuario = new TextField("Pon aqui tu nombre");
		textUsuario.setWidth(40f, Unit.PERCENTAGE);
		areaPedidos = new TextArea("Pon aqui tu lista, cada pedido en 1 linea");
		areaPedidos.setWidth(100f, Unit.PERCENTAGE);
		areaPedidos.setHeight(50, Unit.PERCENTAGE);
		buttonEnviar = new Button("Enviar a Maqui");

	}

	public TextField getTextUsuario() {
		return textUsuario;
	}

	public TextArea getAreaPedidos() {
		return areaPedidos;
	}

	public Button getButtonEnviar() {
		return buttonEnviar;
	}

}
