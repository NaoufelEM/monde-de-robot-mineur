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
		super.getMatrice()[0][0] = "R";
		super.getMatrice()[0][1] = String.valueOf(id);
		super.getMatrice()[1][0] = "X";
		super.getMatrice()[1][1] = "X";
	}

	public List<Minerai> getMinerais() {
		return minerais;
	}

	public void setMinerais(List<Minerai> minerais) {
		this.minerais = minerais;
	}

	public void seDeplacerVers(Direction direction, Secteur[][] matrice) {
		// TODO il faudra implementer les déplacement de mon robot selon le
		// paramèteres
		// Direction.

		switch (direction) {
		case NORD -> {
			System.out.println("NORD");
			if (this.longitude - 1 > 0 && peutAllerVers(matrice[this.longitude - 1][this.latitude], matrice)) {
				super.longitude--;
			}
		}
		case SUD -> {
			System.out.println("SUD");
			if (this.longitude + 1 < matrice.length && peutAllerVers(matrice[this.longitude + 1][this.latitude], matrice)) {
				super.longitude++;
			}
		}
		case OUEST -> {
			System.out.println("OUEST");
			if (this.latitude - 1 > 0 && peutAllerVers(matrice[this.longitude][this.latitude - 1], matrice)) {
				super.latitude--;
			}
		}
		case EST -> {
			System.out.println("EST");
			if (this.latitude + 1 < matrice.length && peutAllerVers(matrice[this.longitude][this.latitude + 1], matrice)) {
				super.latitude++;
			}
		}
		}
	}

	public void recolter(Mine mine) {
		// TODO il faudra implementer ça.
		for (int i = 0; i < capaciteExtraction - this.minerais.size(); i++) {
			this.minerais.add(mine.getMinerais().remove(i));
		}
	}

	public void deposer(Entrepot entrepot) {
		// TODO il faudra implementer ça.
		for (int i = 0; i < this.minerais.size(); i++) {
			entrepot.getMinerais().add(this.minerais.remove(i));
		}
	}

	public boolean peutAllerVers(Secteur secteur, Secteur[][] matrice) {
		if (secteur.getType() == Type.VIDE) {
			matrice[longitude][latitude] = new Secteur(0, longitude, latitude, Type.VIDE);
			secteur.getMatrice()[0][0] = "R";
			secteur.getMatrice()[0][1] = String.valueOf(super.getId());
			secteur.getMatrice()[1][0] = "X";
			secteur.getMatrice()[1][1] = "X";
			return true;
		}
		if (secteur instanceof Entrepot) {
			// TODO à developper
			matrice[longitude][latitude] = new Secteur(0, longitude, latitude, Type.VIDE);
			secteur.getMatrice()[0][0] = "E";
			secteur.getMatrice()[0][1] = String.valueOf(secteur.getId());
			secteur.getMatrice()[1][0] = "R";
			secteur.getMatrice()[1][1] = String.valueOf(super.getId());
			deposer((Entrepot) secteur);
			return true;
		}
		if (secteur instanceof Mine) {
			matrice[longitude][latitude] = new Secteur(0, longitude, latitude, Type.VIDE);
			secteur.getMatrice()[0][0] = "M";
			secteur.getMatrice()[0][1] = String.valueOf(secteur.getId());
			secteur.getMatrice()[1][0] = "R";
			secteur.getMatrice()[1][1] = String.valueOf(super.getId());
			recolter((Mine) secteur);
			return true;
		}

		return false;
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