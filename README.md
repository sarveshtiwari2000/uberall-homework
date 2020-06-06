# Uberall - Homework

To add a resource
```
Resource			: /shop
Description			: Adds a shop. The API would find out the latitude and longitude of the 
					  shop address using Google Maps API and store it with the address.
Method				: POST
Request Content-type: application/json
Example Request		:	{
						  "shopName": "Uberall",
						  "shopAddress": {
						    "number": "44",
						    "addressLine1" : "Martin-Luther-Street",
						    "addressLine2" : "Berlin",
						    "postCode": "13353"
						  }
						}
Success Response	: 200 OK
```

To get a resource
```
Resource				: /shop/{latitude}/{longitude}
Description				: Gives you the nearest shop from your latitude and longitude.
Method					: GET
Response Content-type	: application/json;charset=UTF-8
Example Response		: 200 OK	
							{
							  "shopName": "Uberall",
							  "shopAddress": {
							    "number": "44",
							    "addressLine1": "Martin-Luther-Street",
							    "addressLine2": "Berlin",
							    "postCode": "13353"
							  },
							  "shopLatitude": 37.422364,
							  "shopLongitude": -122.084364
							}
```

To get resources list
```
Resource				: /shop
Description				: Gives you the list of available uberall
Method					: GET
Response Content-type	: application/json;charset=UTF-8
Example Response		: 200 OK	
							{
							  "shopName": "Uberall",
							  "shopAddress": {
							    "number": "44",
							    "addressLine1": "Martin-Luther-Street",
							    "addressLine2": "Berlin",
							    "postCode": "13353"
							  },
							  "shopLatitude": 37.422364,
							  "shopLongitude": -122.084364
							}
```


## How to run
You need Java 8 for running this project.


**Maven :**
If using maven you can use below command to run it

`mvn spring-boot:run -Dserver.port=8082`

