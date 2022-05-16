
package init;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		this.initVide();
		this.initMines();
	}

	public void initVide() {
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < longueur; j++) {
				matrice[i][j] = new Secteur(i + j, i, j, Type.VIDE);
			}
		}
	}

	public void initMines() {
		Random random = new Random();
		int nombreMinesOr = random.nextInt(1, 3);
		int nombreMinesNickel = random.nextInt(1, 3);

		for (int i = 0; i < nombreMinesOr; i++) {
			int longitude = random.nextInt(0, 10);
			int latitude = random.nextInt(0, 10);
			int capacite = random.nextInt(50, 101);
			Mine mineOr = new Mine(i, longitude, latitude, Type.OR, capacite);
			this.mines.add(mineOr);
		}

		for (int i = 0; i < nombreMinesNickel; i++) {
			int longitude = random.nextInt(0, 10);
			int latitude = random.nextInt(0, 10);
			int capacite = random.nextInt(50, 101);
			Mine mineNickel = new Mine(i, longitude, latitude, Type.NICKEL, capacite);
			this.mines.add(mineNickel);

		}

	}

	public void afficher() {
		for (int i = 0; i < largeur; i++) {
			System.out.print("\t" + i);
		}
		System.out.println();
		for (int i = 0; i < largeur; i++) {
			System.out.print(i + "\t");
			for (int j = 0; j < longueur; j++) {

				System.out.print("|" + matrice[i][j].getMatrice()[0][0]);
				System.out.print(matrice[i][j].getMatrice()[0][1]);
				System.out.print("|\t");

			}
			System.out.print("\n");
			System.out.print("\t");
			for (int j = 0; j < longueur; j++) {

				System.out.print("|" + matrice[i][j].getMatrice()[1][0]);
				System.out.print(matrice[i][j].getMatrice()[1][1]);
				System.out.print("|\t");

			}
			System.out.println();
		}
	}

	public void afficherMenu() {
		System.out.println(String.format("tour:%s", 100));

		// Affichage des informations sur les mines
		for (Mine mine : mines) {
			System.out.println(String.format("%s\t%s%s\t%s\t%s/%s", mine.getNumero(), mine.getLongitude(),
					mine.getLatitude(), mine.getType(), mine.getMinerais().size(), mine.getCapaciteDepart()));
		}

		// Affichage des informations sur les entrepots
		for (Entrepot entrepot : entrepots) {
			System.out.println(String.format("%s\t%s%s\t%s\t%s"));
		}

		// Affichage des informations sur les robots
		for (Robot robot : robots) {
			System.out.println(String.format("%s\t%s%s\t%s\t%s/%s"));
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
