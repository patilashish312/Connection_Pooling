package SpringTest1.com.spr.boot1;

import java.util.concurrent.TimeUnit;

import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigClass {

	@Bean(name = "withoutconnectionPool")
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	
	
	@Bean(name="connectionPool2")
	RestTemplate restTemplate2() {
		CloseableHttpClient client=HttpClients.custom()
				.setMaxConnTotal(1).setMaxConnPerRoute(1)
				.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
				.setConnectionReuseStrategy(new DefaultConnectionReuseStrategy())
				.evictExpiredConnections()   //Evicting expired connections
				.evictIdleConnections(6000, TimeUnit.MILLISECONDS)  // evict idle connection after 6 seconds.
				.build();
		HttpComponentsClientHttpRequestFactory req
		=new HttpComponentsClientHttpRequestFactory(client);
		req.setReadTimeout(5000);
		req.setConnectTimeout(5000);
		req.setConnectionRequestTimeout(5000);
		
		return new RestTemplate(req);
	}

}
