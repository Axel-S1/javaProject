package plateau;

import carte.Carte;

public class Zone {
	private Carte[] cartePlacer = new Carte[256];
	private int nbCarte = 0;
	
	public void placerCarte(Carte carte) {
		cartePlacer[nbCarte] = carte;
	}
}
