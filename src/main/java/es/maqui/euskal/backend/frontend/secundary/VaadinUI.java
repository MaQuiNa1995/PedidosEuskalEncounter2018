package es.maqui.euskal.backend.frontend.secundary;

import java.util.logging.Logger;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

@SpringUI
public class VaadinUI extends UI {

	private static Logger LOG = Logger.getLogger(VaadinUI.class.getName());
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Override
    protected void init(VaadinRequest request) {
    	LOG.info("Soy un mensaje de prueba");
	    setContent(new Button("Click me", e -> Notification.show("Boton de prueba")));
    }

}
