package plateau;

import carte.Carte;

public abstract class Zone {
	protected int nbCarte = 0;
	private static int maxCarte = 100;
	
	public abstract void placerCarte(Carte carte);
}
