package secteurs;

import java.util.List;

import enumeration.Type;
import objets.Minerai;

public class Entrepot extends Secteur {
	private List<Minerai> minerais;

	public Entrepot(int id, int longitude, int latitude, Type type, List<Minerai> minerais) {
		super(id, longitude, latitude, type);
		this.setMinerais(minerais);
		super.getMatrice()[0][0]="E";
        super.getMatrice()[0][1] = String.valueOf(id) ;
        super.getMatrice()[1][0]="X";
        super.getMatrice()[1][1]="X";
	}

	public List<Minerai> getMinerais() {
		return minerais;
	}

	public void setMinerais(List<Minerai> minerais) {
		this.minerais = minerais;
	}

}
