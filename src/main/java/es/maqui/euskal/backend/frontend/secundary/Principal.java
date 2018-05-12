package es.maqui.euskal.backend.frontend.secundary;

import org.springframework.util.StringUtils;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import es.maqui.euskal.backend.frontend.principal.VentanaPedido;
import es.maqui.euskal.backend.model.Pedido;
import es.maqui.euskal.backend.repository.PedidoRepository;

@SpringUI
public class Principal extends UI {

	private final PedidoRepository repo;

	private final VentanaPedido editor;

	final Grid<Pedido> grid;

	final TextField filter;

	private final Button addNewBtn;

	public Principal(PedidoRepository repo, VentanaPedido editor) {
		this.repo = repo;
		this.editor = editor;
		this.grid = new Grid<>(Pedido.class);
		this.filter = new TextField();
		this.addNewBtn = new Button("New Pedido", FontAwesome.PLUS);
	}

	@Override
	protected void init(VaadinRequest request) {
		// build layout
		HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
		VerticalLayout mainLayout = new VerticalLayout(actions, grid, editor);
		setContent(mainLayout);

		grid.setHeight(300, Unit.PIXELS);
		grid.setColumns("id", "firstName", "lastName");

		filter.setPlaceholder("Filter by last name");

		// Hook logic to components

		// Replace listing with filtered content when user changes filter
		filter.setValueChangeMode(ValueChangeMode.LAZY);
		filter.addValueChangeListener(e -> listPedidos(e.getValue()));

		// Connect selected Pedido to editor or hide if none is selected

		// Instantiate and edit new Pedido the new button is clicked
		Pedido pedido = new Pedido();
		pedido.setId(1l);
		pedido.setNombreUsuario("prueba");
		pedido.setPedido("prueba Pedido");

		// Listen changes made by the editor, refresh data from backend
		editor.setChangeHandler(() -> {
			editor.setVisible(false);
			listPedidos(filter.getValue());
		});

		// Initialize listing
		listPedidos(null);
	}

	// tag::listPedidos[]
	void listPedidos(String filterText) {
		grid.setItems(repo.list());

	}
	// end::listPedidos[]

}
