package hello;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class Application {

	
    @Value("${db.pool.size}")
    String poolSize;
    
    @Value("${db.url}")
    String dbUrl;
    
    @Value("${ms2.url}")
    String ms2Url;
    
    @Value("${rabbit.ip}")
    String rabbitIp;
    
    
    @RequestMapping("/")
	public String home() {
		Date date = new Date();
		System.out.println("Microservice 1 invoked !!" + date.toString());
		
		StringBuilder builder =  new StringBuilder();
		
		builder.append("Hello again 333 from Docker -- from microservice 1 \n");
		builder.append("env variable :: \n");
		builder.append("poolSize >> " + poolSize + "\n" + "dbUrl >> " + dbUrl + "\n" + "ms2url >> " + ms2Url + "\n" + "rabbitip >> " + rabbitIp);
		builder.append("Response from urilty microservice >>" + invokeUtilityService(ms2Url));
		
		return builder.toString();
	}


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	String invokeUtilityService(String url)
	{
	   
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(url, String.class);
	     
	    System.out.println(result);
	    
	    return result;
		
	}
	
	
}
