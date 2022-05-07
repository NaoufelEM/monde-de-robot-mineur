package secteurs;

import java.util.ArrayList;
import java.util.List;

import enumeration.Type;
import objets.Minerai;

public class Mine extends Secteur {
	private int capaciteDepart;
	private List<Minerai> minerais;

	public Mine(String id, int longitude, int latitude, Type type, int capaciteDepart) {
		super(id, longitude, latitude, type);
		this.capaciteDepart = capaciteDepart;
		this.minerais = new ArrayList<>(100);
	}

	public List<Minerai> getMinerais() {
		return minerais;
	}

	public void setMinerais(List<Minerai> minerais) {
		this.minerais = minerais;
	}

	public int getCapaciteDepart() {
		return capaciteDepart;
	}

	public void setCapaciteDepart(int capaciteDepart) {
		this.capaciteDepart = capaciteDepart;
	}

}
