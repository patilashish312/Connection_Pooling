package SpringTest1.com.spr.boot1;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.client.WebClient;

public class RestHandlerWebClien2 {

	@Autowired
	@Qualifier(value = "PooledWebClient")
	WebClient webClient2;

	@RequestMapping(value = "/testCurrencies5", method = RequestMethod.GET)
	public void webClientGet() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_PDF));
		HttpEntity<String> entity = new HttpEntity(headers);

		webClient2.get().accept(MediaType.APPLICATION_PDF).exchangeToMono(x -> x.toEntity(Byte.class));
	}
}
