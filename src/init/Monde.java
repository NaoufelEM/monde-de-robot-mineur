
package init;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;

import enumeration.Type;
import secteurs.Entrepot;
import secteurs.Mine;
import secteurs.Secteur;

public class Monde {
	private int longueur;
	private int largeur;
	private int pourcentageEau;
	private Secteur[][] matrice;
	private List<Entrepot> entrepots;
	private List<Mine> mines;
	private List<Robot> robots;

	public Monde(int longueur, int largeur, int pourcentageEau) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.pourcentageEau = pourcentageEau;
		// TODO Gestion du min et du maxi.
		this.matrice = new Secteur[largeur][longueur];
		this.entrepots = new ArrayList<Entrepot>(2);
		this.mines = new ArrayList<Mine>(4);
		this.robots = new ArrayList<Robot>(5);
	}

	public void afficher() {
		for (int i = 0; i < largeur; i++) {
			System.out.print("\t" + i);
		}
		System.out.println();
		for (int i = 0; i < largeur; i++) {
			System.out.print(i + "\t");
			for (int j = 0; j < longueur; j++) {
				Secteur monSecteur = matrice[i][j];
				System.out.print(monSecteur.getId() + "\t");
			}

			System.out.println();
		}

	}

	public void initVide() {
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < longueur; j++) {
				matrice[i][j] = new Secteur("V" + i + j, i, j, Type.VIDE);
			}
		}
	}

	public List<Entrepot> getEntrepots() {
		return entrepots;
	}

	public void setEntrepots(List<Entrepot> entrepots) {
		this.entrepots = entrepots;
	}

	public List<Mine> getMines() {
		return mines;
	}

	public void setMines(List<Mine> mines) {
		this.mines = mines;
	}

	public List<Robot> getRobots() {
		return robots;
	}

	public void setRobots(List<Robot> robots) {
		this.robots = robots;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getPourcentageEau() {
		return pourcentageEau;
	}

	public void setPourcentageEau(int pourcentageEau) {
		this.pourcentageEau = pourcentageEau;
	}

}
