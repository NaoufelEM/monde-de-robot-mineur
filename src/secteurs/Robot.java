package secteurs;

import java.util.ArrayList;
import java.util.List;

import enumeration.Direction;
import enumeration.Type;
import objets.Minerai;

public class Robot extends Secteur {
	private int capaciteStockage;
	private int capaciteExtraction;
	private List<Minerai> minerais;

	public Robot(int id, int longitude, int latitude, Type type, int capaciteStockage, int capaciteExtraction) {
		super(id, longitude, latitude, type);
		this.capaciteStockage = capaciteStockage;
		this.capaciteExtraction = capaciteExtraction;
		this.minerais = new ArrayList<>();
	}

	public List<Minerai> getMinerais() {
		return minerais;
	}

	public void setMinerais(List<Minerai> minerais) {
		this.minerais = minerais;
	}

	public void seDeplacer(Direction direction) {
		// TODO il faudra implementer les déplacement de mon robot selon le paramèteres
		// Direction.
	}

	public void recolter() {
		// TODO il faudra implementer ça.
	}

	public void stocker() {
		// TODO il faudra implementer ça.
	}

	public void deposer() {
		// TODO il faudra implementer ça.
	}

	public int getCapaciteStockage() {
		return capaciteStockage;
	}

	public void setCapaciteStockage(int capaciteStockage) {
		this.capaciteStockage = capaciteStockage;
	}

	public int getCapaciteExtraction() {
		return capaciteExtraction;
	}

	public void setCapaciteExtraction(int capaciteExtraction) {
		this.capaciteExtraction = capaciteExtraction;
	}

}
