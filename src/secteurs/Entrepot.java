package secteurs;

import java.util.ArrayList;
import java.util.List;

import enumeration.Type;
import init.Utils;
import objets.Minerai;

public class Entrepot extends Secteur {
	private List<Minerai> minerais;

	public Entrepot(int id, int longitude, int latitude, Type type) {
		super(id, longitude, latitude, type);
		this.setMinerais(minerais);
		super.getMatrice()[0][0]="E";
		super.getMatrice()[0][1] = String.valueOf(id) ;
		super.getMatrice()[1][0]="X";
		super.getMatrice()[1][1]="X";

		// init de l'entrepot
		int capacite = Utils.randomGenerateur(50, 100);
		this.minerais = new ArrayList<>(capacite);

	}

	public List<Minerai> getMinerais() {
		return minerais;
	}

	public void setMinerais(List<Minerai> minerais) {
		this.minerais = minerais;
	}

}