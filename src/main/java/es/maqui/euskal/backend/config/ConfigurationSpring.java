package es.maqui.euskal.backend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationSpring {

	@Bean
	public CommandLineRunner loadData() {
		return (args) -> {

		};
	}

}
