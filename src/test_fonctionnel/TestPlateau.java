package test_fonctionnel;

import plateau.Plateau;

public class TestPlateau {
	private static Plateau plateau = new Plateau("luffy", "Teach");
	private static boolean partieEnCours = true;
	
	public static void main(String[] args) {
		
		do{
			partieEnCours = plateau.faireTourDeJeu();
		}while(partieEnCours);
		
	}	
}
	
