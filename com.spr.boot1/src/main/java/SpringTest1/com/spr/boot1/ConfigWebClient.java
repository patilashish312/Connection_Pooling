package SpringTest1.com.spr.boot1;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;
import reactor.netty.resources.PooledConnectionProvider;

@Configuration
public class ConfigWebClient {

	@Bean(name = "PooledWebClient")
	WebClient webClient2() {
		String connectionProviderName = "myConnectionProvider";
		int maxConnections = 1;
		//int acquireTimeout = 1000;
		HttpClient httpClient=
		HttpClient.create(ConnectionProvider.create(connectionProviderName, maxConnections));
		return WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient)).build();
	}
	
	@Bean(name="DefaultWebClient")
	WebClient webClient() {
		return WebClient.create();
	}
}
