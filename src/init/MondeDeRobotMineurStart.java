package init;

public class MondeDeRobotMineurStart {

    public static void main(String[] args) {
        System.out.println("Bienvenu dans le jeu monde de robots mineur!");
        //Initialisation du monde
        Monde monde = new Monde(10, 10, 20);
        //Affichage du monde et du menu tant que
        // TODO Tant que la personne n'a pas cliker sur "q" continuer à jour et afficher tour suivant
        monde.afficher();
        monde.afficherMenu();


        // TODO tester d'appuyer sur la touche droite et d'afficher "droite"

    }

}