package SpringTest1.com.spr.boot1;

import java.util.Collections;

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
public class RestHandler1 {

	@Autowired
	@Qualifier(value="connectionPool2")
	RestTemplate restTemplate2;

	@RequestMapping(value = "/testCurrencies2", method = RequestMethod.GET)
	public String restTemplateGet() {
		return restTemplate2.getForObject("https://api.coinbase.com/v2/currencies", String.class);

	}

	@RequestMapping(value = "/testCurrencies3", method = RequestMethod.GET)
	public ResponseEntity<byte[]> restTemplateGet1() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_PDF));
		HttpEntity<String> entity = new HttpEntity(headers);		
		return restTemplate2.exchange("https://api.coinbase.com/v2/currencies", HttpMethod.GET, entity, byte[].class);
	}
	
	
	
	
	
}
