package iptracker.model;

public class IPResponse extends BaseResponse{

	private String ip;
	private String country;
	private String city;
	private String longitude;
	private String latitude;

	public IPResponse() {
		ip = "null";
		country = "none";
		city = "none";
		longitude = "unknown";
		latitude = "unknown";
		
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
