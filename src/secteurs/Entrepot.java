package secteurs;

import java.util.List;

import enumeration.Type;
import objets.Minerai;

public class Entrepot extends Secteur {
	private List<Minerai> minerais;

	public Entrepot(String id, int longitude, int latitude, Type type, List<Minerai> minerais) {
		super(id, longitude, latitude, type);
		this.setMinerais(minerais);
	}

	public List<Minerai> getMinerais() {
		return minerais;
	}

	public void setMinerais(List<Minerai> minerais) {
		this.minerais = minerais;
	}

}
