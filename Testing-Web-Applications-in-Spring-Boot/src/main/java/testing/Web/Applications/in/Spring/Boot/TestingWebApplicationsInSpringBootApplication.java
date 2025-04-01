package testing.Web.Applications.in.Spring.Boot;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition
@SpringBootApplication
public class TestingWebApplicationsInSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingWebApplicationsInSpringBootApplication.class, args);
	}

}
