package init;

import java.util.Random;

public class MondeDeRobotMineurStart {

	public static void main(String[] args) {
		System.out.println("Bienvenu dans le jeu monde de robots mineur!");
		//Initialisation du monde
        Monde monde = new Monde(10, 10, 20);

        //Affichage du monde et du menu tant que
        monde.afficher();
        monde.afficherMenu();
	}

}