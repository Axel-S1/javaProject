package test_fonctionnel;

import plateau.Plateau;

public class TestPlateau {
	private static Plateau plateau = new Plateau("luffy", "Teach");
	
	public static void main(String[] args) {
		boolean partieEnCours = true;
		do{
			partieEnCours = plateau.faireTourDeJeu();
		}while(partieEnCours);
		
	}	
}
	
