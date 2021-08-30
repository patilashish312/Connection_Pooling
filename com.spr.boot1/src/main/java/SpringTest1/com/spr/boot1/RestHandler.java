package SpringTest1.com.spr.boot1;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.Duration;
import java.util.Collections;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class RestHandler {

	@Autowired
	@Qualifier(value="withoutconnectionPool")
	RestTemplate restTemplate;

	@RequestMapping(value = "/testCurrencies", method = RequestMethod.GET)
	public String restTemplateGet() {
		return restTemplate.getForObject("https://api.coinbase.com/v2/currencies", String.class);

	}

	@RequestMapping(value = "/testCurrencies1", method = RequestMethod.GET)
	public ResponseEntity<byte[]> restTemplateGet1() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_PDF));
		HttpEntity<String> entity = new HttpEntity(headers);		
		Stream.of("Ashish","Patil").forEach(System.out::print);
		return restTemplate.exchange("https://api.coinbase.com/v2/currencies", HttpMethod.GET, entity, byte[].class);
	}
	
}
