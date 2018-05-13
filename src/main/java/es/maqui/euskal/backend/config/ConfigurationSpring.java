package es.maqui.euskal.backend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@Configuration
public class ConfigurationSpring {

	@Bean
	public CommandLineRunner loadData() {
		return (args) -> {

		};
	}

}
