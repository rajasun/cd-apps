package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@SpringBootApplication
@RestController
public class Application {
	@RequestMapping("/")
	public String home() {
	        Date date = new Date();
		System.out.println("**** Microservice 2 invoked  Updated for Trigger *** !!!!" + date.toString());
		return "Hello Docker World -- MS2 v10 --Demo !!!";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
