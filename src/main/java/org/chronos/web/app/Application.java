package org.chronos.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.chronos.web.app.model", "org.chronos.web.app.controllers.*", "org.chronos.web.app.controllers", "org.chronos.web.app.repository"})
@EnableConfigurationProperties
@EntityScan(basePackages = {"org.chronos.web.app.model"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
