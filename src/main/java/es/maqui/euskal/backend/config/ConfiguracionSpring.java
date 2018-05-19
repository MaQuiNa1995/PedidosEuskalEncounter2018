package es.maqui.euskal.backend.config;

import java.net.URI;

import java.net.URISyntaxException;
import java.util.logging.Logger;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionSpring {
	
	private final static Logger LOG = Logger.getLogger(ConfiguracionSpring.class.getName());

	@Bean
	public CommandLineRunner loadData() {
		return (args) -> {
			// Posibles configuraciones que quiera meterle en el futuro aqui antes de aarancar la aplicacion
		};
	}
	
//    @Bean
//    public BasicDataSource dataSource(){
//        URI uriBaseDatos=null;
//		try {
//			uriBaseDatos = new URI("qxenawziykbusl:c4a0bf2c9589b14fac1b8cafe912c000fc9cff4b1f398617e6e0d0863c7f8139@ec2-54-204-39-46.compute-1.amazonaws.com:5432/d3h5ikfjrmeh09");
//		} catch (URISyntaxException exception) {
//			LOG.warning("La Uri no está bien definida: "+ exception.getMessage());
//		}
//
//        String usuario = uriBaseDatos.getUserInfo().split(":")[0];
//        String contrasena = uriBaseDatos.getUserInfo().split(":")[1];
//        String dbUrl = "jdbc:postgresql://" + uriBaseDatos.getHost() + ':' + uriBaseDatos.getPort() + uriBaseDatos.getPath() + "?sslmode=require";
//
//        BasicDataSource basicDataSource = new BasicDataSource();
//        basicDataSource.setUrl(dbUrl);
//        basicDataSource.setUsername(usuario);
//        basicDataSource.setPassword(contrasena);
//
//        return basicDataSource;
//    }

}
