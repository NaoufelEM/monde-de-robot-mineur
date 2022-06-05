package enumeration;

public enum Direction {
	NORD("n"), SUD("s"), EST("e"), OUEST("o");

	private String touche;

	Direction(String touche) {
		this.touche = touche;
	}

	public static Direction directionDepuisLaTouche(String touche){
		for (Direction d : Direction.values()) {
			if (d.touche.equalsIgnoreCase(touche)) {
				return d;
			}
		}
		return null;
	}
}
