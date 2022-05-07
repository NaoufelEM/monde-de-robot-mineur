package secteurs;

import enumeration.Type;

public class Secteur {
	private String id;
	private int longitude;
	private int latitude;
	private Type type;

	public Secteur(String id, int longitude, int latitude, Type type) {
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
