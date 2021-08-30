package SpringTest1.com.spr.boot1;
import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ApplicationStarter1 {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationStarter1.class, args);
		
	}

}
