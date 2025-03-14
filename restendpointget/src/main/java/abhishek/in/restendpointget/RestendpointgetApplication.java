package abhishek.in.restendpointget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("abhishek.in.restendpointget")
@EnableAutoConfiguration
public class RestendpointgetApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestendpointgetApplication.class, args);
	}

}
