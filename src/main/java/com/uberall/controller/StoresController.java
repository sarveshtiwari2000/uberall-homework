package com.uberall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.maps.model.LatLng;
import com.uberall.data.Store;
import com.uberall.map.MapService;
import com.uberall.model.Shop;


@RestController
public class StoresController {


	@Autowired
	@Qualifier("geocodeService")
	private MapService geocodeService;

	@Autowired
	@Qualifier("memoryStore")
	private Store<Shop, LatLng> store;

	@RequestMapping(path = "/shop", method = RequestMethod.POST)
	public void addShop(@RequestBody Shop shop) {
		LatLng geocode = geocodeService.getGeocode(shop);
		if (null != geocode) {
			shop.setShopLatitude(geocode.lat);
			shop.setShopLongitude(geocode.lng);
		}
		store.add(shop);
	}


	@RequestMapping(path = "/shop/{latitude}/{longitude}", method = RequestMethod.GET)
	public Shop getShop(@PathVariable double latitude, @PathVariable double longitude) {
		LatLng geocode = new LatLng(latitude, longitude);
		Shop shop = store.get(geocode);
		return shop;
	}

	@RequestMapping(path = "/shop", method = RequestMethod.GET)
	public List<Shop> getShops() {
		return store.getAll();
	}

}
