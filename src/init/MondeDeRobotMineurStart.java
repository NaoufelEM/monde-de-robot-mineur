package init;

public class MondeDeRobotMineurStart {

	public static void main(String[] args) {
		System.out.println("Bienvenu dans le jeu monde de robots mineur!");
		Monde monde = new Monde(10, 10, 20);
		monde.afficher();
	}

}
