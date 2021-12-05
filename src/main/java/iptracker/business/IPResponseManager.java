package iptracker.business;

import java.net.InetAddress;

import com.maxmind.geoip2.WebServiceClient;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Location;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import iptracker.model.IPResponse;

public class IPResponseManager {

	

	public IPResponse getUserIpInfo(IPResponse resp) throws Exception {
		
		String FILE_PATH = "/home/para/workspace/IPTracker/src/main/java/iptracker/assets/env"; //Linux
//		String FILE_PATH = ""; //Mac
//		String FILE_PATH = ""; //Windows
		
		File file = new File(FILE_PATH);
		Scanner reader = new Scanner(file);
		int accountID = Integer.parseInt(reader.nextLine());
		String geoLocationApiKey = reader.nextLine();
		
		reader.close();

		WebServiceClient client = new WebServiceClient.Builder(accountID, geoLocationApiKey).host("geolite.info").build();

		InetAddress ipAddress = InetAddress.getByName(resp.getIp());

		CountryResponse countryResponse = client.country(ipAddress);
		CityResponse cityResponse = client.city(ipAddress);

		Country country = countryResponse.getCountry();
		City city = cityResponse.getCity();
		
		Location location = cityResponse.getLocation();

		if(country.getName() != null) {
			resp.setCountry(country.getName());
		}
		if(city.getName() != null) {
			resp.setCity(city.getName());
		}
		if(location.getLongitude() != null) {
			resp.setLongitude(Double.toString(location.getLongitude()));
		}
		if(location.getLatitude() != null) {
			resp.setLatitude(Double.toString(location.getLatitude()));
		}

		return resp;
	}

}
