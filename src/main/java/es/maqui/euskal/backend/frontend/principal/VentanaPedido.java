package es.maqui.euskal.backend.frontend.principal;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * A simple example to introduce building forms. As your real application is probably much
 * more complicated than this example, you could re-use this form in multiple places. This
 * example component is only used in VaadinUI.
 * <p>
 * In a real world application you'll most likely using a common super class for all your
 * forms - less code, better UX. See e.g. AbstractForm in Viritin
 * (https://vaadin.com/addon/viritin).
 */
@SpringComponent
@UIScope
public class PedidoEditor extends VerticalLayout {

	private final PedidoRepository repository;

	/**
	 * The currently edited Pedido
	 */
	private Pedido Pedido;

	/* Fields to edit properties in Pedido entity */
	TextField firstName = new TextField("First name");
	TextField lastName = new TextField("Last name");

	/* Action buttons */
	Button save = new Button("Save", VaadinIcons.CHECK);
	Button cancel = new Button("Cancel");
	Button delete = new Button("Delete", VaadinIcons.TRASH);
	CssLayout actions = new CssLayout(save, cancel, delete);

	Binder<Pedido> binder = new Binder<>(Pedido.class);

	@Autowired
	public PedidoEditor(PedidoRepository repository) {
		this.repository = repository;

		addComponents(firstName, lastName, actions);

		// bind using naming convention
		binder.bindInstanceFields(this);

		// Configure and style components
		setSpacing(true);
		actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

		// wire action buttons to save, delete and reset
		save.addClickListener(e -> repository.save(Pedido));
		delete.addClickListener(e -> repository.delete(Pedido));
		cancel.addClickListener(e -> editPedido(Pedido));
		setVisible(false);
	}

	public interface ChangeHandler {

		void onChange();
	}

	public final void editPedido(Pedido c) {
		if (c == null) {
			setVisible(false);
			return;
		}
		final boolean persisted = c.getId() != null;
		if (persisted) {
			// Find fresh entity for editing
			Pedido = repository.findById(c.getId()).get();
		}
		else {
			Pedido = c;
		}
		cancel.setVisible(persisted);

		// Bind Pedido properties to similarly named fields
		// Could also use annotation or "manual binding" or programmatically
		// moving values from fields to entities before saving
		binder.setBean(Pedido);

		setVisible(true);

		// A hack to ensure the whole form is visible
		save.focus();
		// Select all text in firstName field automatically
		firstName.selectAll();
	}

	public void setChangeHandler(ChangeHandler h) {
		// ChangeHandler is notified when either save or delete
		// is clicked
		save.addClickListener(e -> h.onChange());
		delete.addClickListener(e -> h.onChange());
	}

}
