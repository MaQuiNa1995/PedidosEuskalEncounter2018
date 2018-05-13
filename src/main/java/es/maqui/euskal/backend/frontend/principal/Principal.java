package es.maqui.euskal.backend.frontend.principal;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI
@Title("Pedidos Euskal 2018")
public class Principal extends UI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

    @Override
    protected void init(VaadinRequest request) {
	    setContent(new VentanaPedidos());
    }
    
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = Principal.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
    }

}
