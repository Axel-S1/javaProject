package test_fonctionnel;

import joueur.Pirate;

public class TestJoueur {
	public static void main(String[] args) {
		Pirate luffy = new Pirate("Luffy");
		
		luffy.afficherMain();
		luffy.piocherCarte();
		luffy.afficherMain();
	}

}
