package pl.kszpakowski.bikeramp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class BikerampApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikerampApplication.class, args);
	}

}
