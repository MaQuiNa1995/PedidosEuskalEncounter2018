package es.maqui.euskal.backend.frontend.secundary;

import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

@SpringUI
public class Principal extends UI {

	private static Logger LOG = Logger.getLogger(Principal.class.getName());
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Override
    protected void init(VaadinRequest request) {
    	LOG.info("Soy un mensaje de prueba");
	    setContent(new Button("Click me", e -> Notification.show("Boton de prueba")));
    }
    
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = Principal.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

}
