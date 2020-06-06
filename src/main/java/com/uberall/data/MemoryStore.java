package com.uberall.data;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.maps.model.LatLng;
import com.uberall.model.Shop;

public class MemoryStore implements Store<Shop, LatLng> {

	private static final Logger LOG = Logger.getLogger(MemoryStore.class.getName());

	private final List<Shop> data = new ArrayList<>();

	@Override
	public Shop get(LatLng geocode) {
		Shop nearestShop = findNearest(geocode);
		return nearestShop;
	}

	@Override
	public List<Shop> getAll() {
		return data;
	}

	@Override
	public Shop add(Shop item) {
		data.add(item);
		return item;
	}


	public Shop findNearest(LatLng geocode) {
		double lat1 = geocode.lat;
		double lon1 = geocode.lng;
		double nearestDist = -1;
		Shop nearestShop = null;
		for (Shop shop : data) {
			double lat2 = shop.getShopLatitude();
			double lon2 = shop.getShopLongitude();
			double dist = Util.haversine(lat1, lon1, lat2, lon2);
			if (dist < nearestDist || nearestDist == -1) {
				nearestShop = shop;
				nearestDist = dist;
				LOG.log(Level.INFO, " Shop " + nearestShop.getShopName() + " found at " + nearestDist + " KM");
			}
		}
		return nearestShop;
	}

}
