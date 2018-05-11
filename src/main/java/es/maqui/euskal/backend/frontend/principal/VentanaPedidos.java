package es.maqui.euskal.backend.frontend.principal;

import com.vaadin.data.Binder;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.VerticalLayout;

import es.maqui.euskal.backend.model.Pedido;

@SpringComponent
@UIScope
public class VentanaPedidos extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Binder<Pedido> binder = new Binder<>(Pedido.class);


}
