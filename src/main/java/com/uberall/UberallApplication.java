package com.uberall;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.google.maps.model.LatLng;
import com.uberall.data.MemoryStore;
import com.uberall.data.Store;
import com.uberall.map.MapService;
import com.uberall.model.Shop;

@SpringBootApplication
public class UberallApplication {

	public static void main(String[] args) {
		SpringApplication.run(UberallApplication.class, args);
	}

	@Bean(name = "geocodeService")
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	@ConfigurationProperties(prefix = "config")
	public MapService getGeocodeService() {
		MapService service = new MapService();
		return service;
	}

	@Bean(name = "memoryStore")
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Store<Shop, LatLng> getMemoryStore() {
		return new MemoryStore();
	}
}
