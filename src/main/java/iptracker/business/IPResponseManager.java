package iptracker.business;

import java.net.InetAddress;

import com.maxmind.geoip2.WebServiceClient;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;

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
		CityResponse cityResponse = client.city();

		Country country = countryResponse.getCountry();
		City city = cityResponse.getCity();

		resp.setCountry(country.getName());
		resp.setCity(city.getName());
//		resp.setLongitude(Double.toString(location.getLongitude()));
//		resp.setLatitude(Double.toString(location.getLatitude()));

		return resp;
	}

}
