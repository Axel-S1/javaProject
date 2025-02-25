package test_fonctionnel;

import joueur.Pirate;

public class TestJoueur {
	public static void main(String[] args) {
		Pirate luffy = new Pirate("Luffy", 0);
		
		luffy.afficherDeck();
		luffy.piocherCarte();
		luffy.afficherDeck();
	}

}
