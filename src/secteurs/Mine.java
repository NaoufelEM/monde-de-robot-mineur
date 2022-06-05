package secteurs;

import java.util.ArrayList;
import java.util.List;

import enumeration.Type;
import objets.Minerai;

public class Mine extends Secteur {
	private int capaciteDepart;
	private List<Minerai> minerais;

	public Mine(int id, int longitude, int latitude, Type type, int capaciteDepart) {
		super(id, longitude, latitude, type);
		this.capaciteDepart = capaciteDepart;
		this.minerais = new ArrayList<>(capaciteDepart);
		super.getMatrice()[0][0] = "M";
		super.getMatrice()[0][1] = String.valueOf(id);
		super.getMatrice()[1][0] = "X";
		super.getMatrice()[1][1] = "X";
		this.remplirDeMinerai(type);
	}

	public void remplirDeMinerai(Type type) {
		for (int i = 0; i < this.capaciteDepart; i++) {
			Minerai minerai = new Minerai(type);
			minerais.add(minerai);
		}
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