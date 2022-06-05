package secteurs;

import enumeration.Type;

public class Secteur {
	private int id;
	private String[][] matrice;
	protected int longitude;
	protected int latitude;
	private Type type;

	public Secteur(int id, int longitude, int latitude, Type type) {
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.type = type;
		this.matrice = new String[2][2];
		this.matrice[0][0] = " ";
		this.matrice[0][1] = " ";
		this.matrice[1][0] = " ";
		this.matrice[1][1] = " ";
	}

	public int getId() {
		return id;
	}

	public String getNumero() {
		return this.matrice[0][0]+this.id;
	}

	public void setId(int id) {
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

	public String[][] getMatrice() {
		return matrice;
	}

	public void setMatrice(String[][] matrice) {
		this.matrice = matrice;
	}

}