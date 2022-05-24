
package init;

import enumeration.Type;
import secteurs.Entrepot;
import secteurs.Mine;
import secteurs.Robot;
import secteurs.Secteur;

import java.util.ArrayList;
import java.util.List;

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
        this.initEntrepots();
        this.initRobots();
    }

    public void initVide() {
        for (int i = 0; i < largeur; i++) {
            for (int j = 0; j < longueur; j++) {
                matrice[i][j] = new Secteur(i + j, i, j, Type.VIDE);
            }
        }
    }

    public void initMines() {
        int nombreMinesOr = Utils.randomGenerateur(1, 3);
        int nombreMinesNickel = Utils.randomGenerateur(1, 3);
        //	if(mine.getType() ==  Type.VIDE) {
// TODO faire une boucle while tant que le secteur n'est pas vide
        for (int i = 0; i < nombreMinesOr; i++) {
            int longitude = Utils.randomGenerateur(0, 10);
            int latitude = Utils.randomGenerateur(0, 10);
            int capacite = Utils.randomGenerateur(50, 101);
            Mine mineOr = new Mine(i, longitude, latitude, Type.OR, capacite);
            this.matrice[longitude][latitude] = mineOr;
            this.mines.add(mineOr);
        }

        for (int i = 0; i < nombreMinesNickel; i++) {
            int longitude = Utils.randomGenerateur(0, 10);
            int latitude = Utils.randomGenerateur(0, 10);
            int capacite = Utils.randomGenerateur(50, 101);
            Mine mineNickel = new Mine(i, longitude, latitude, Type.NICKEL, capacite);
            this.matrice[longitude][latitude] = mineNickel;
            this.mines.add(mineNickel);
        }
    }

    public void initEntrepots() {
        int longitude = Utils.randomGenerateur(0, 10); //3
        int latitude = Utils.randomGenerateur(0, 10); //5

//	if(secteur.getType() ==  Type.VIDE) {
// TODO faire une boucle while tant que le secteur n'est pas vide

        Entrepot entrepotOr = new Entrepot(1, longitude, latitude, Type.OR);
        this.matrice[longitude][latitude] = entrepotOr;

        Entrepot entrepotNickel = new Entrepot(2, longitude, latitude, Type.NICKEL);
        this.matrice[longitude][latitude] = entrepotNickel;

        this.entrepots.add(entrepotOr);
        this.entrepots.add(entrepotNickel);
    }

    public void initRobots() {
        int nombreRobotsOr = Utils.randomGenerateur(1, 4);
        int nombreRobotsNickel = Utils.randomGenerateur(1, 5 - nombreRobotsOr);

        //	if(robot.getType() ==  Type.VIDE) {
// TODO faire une boucle while tant que le secteur n'est pas vide
        for (int i = 0; i < nombreRobotsOr; i++) {
            int longitude = Utils.randomGenerateur(0, 10);
            int latitude = Utils.randomGenerateur(0, 10);
            int capaciteStockage = Utils.randomGenerateur(5, 9);
            int capaciteExtraction = Utils.randomGenerateur(1, 3);

            Robot robot = new Robot(i, longitude, latitude, Type.OR, capaciteStockage, capaciteExtraction);
            this.matrice[longitude][latitude] = robot;
            this.robots.add(robot);
        }

        for (int i = 0; i < nombreRobotsNickel; i++) {
            int longitude = Utils.randomGenerateur(0, 10);
            int latitude = Utils.randomGenerateur(0, 10);
            int capaciteStockage = Utils.randomGenerateur(5, 9);
            int capaciteExtraction = Utils.randomGenerateur(1, 3);

            Robot robot = new Robot(i, longitude, latitude, Type.NICKEL, capaciteStockage, capaciteExtraction);
            this.matrice[longitude][latitude] = robot;
            this.robots.add(robot);
        }
    }

    public void afficher() {
        // TODO amélirer affichage + ajouter banniere
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
        System.out.printf("tour:%s%n", 100);

        // Affichage des informations sur les mines
        // TODO afficher les id des mines M1 , M2 , M3....
        for (Mine mine : mines) {
            System.out.printf("%s\t%s%s\t%s\t%s/%s%n", mine.getNumero(), mine.getLongitude(),
                    mine.getLatitude(), mine.getType(), mine.getMinerais().size(), mine.getCapaciteDepart());
        }

        // Affichage des informations sur les entrepots
        for (Entrepot entrepot : entrepots) {
            System.out.printf("%s\t%s%s\t%s\t%s%n", entrepot.getNumero(), entrepot.getLongitude(),
                    entrepot.getLatitude(), entrepot.getType(), entrepot.getMinerais().size());
        }

        // Affichage des informations sur les robots
        for (Robot robot : robots) {
            System.out.printf("%s\t%s%s\t%s\t%s/%s%n", robot.getNumero(), robot.getLongitude(),
                    robot.getLatitude(), robot.getType(), robot.getMinerais().size(), robot.getCapaciteStockage());
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
