package plateau;

import carte.Carte;
import joueur.Pirate;

public class Zone {
	private Pirate pirate;
	
	public Zone(Pirate pirate) {
		this.pirate = pirate;
	}
	
	public void placerCarte(Carte carte) {
		pirate.prendreEffetVie(carte.getEffetSurVie());
		pirate.prendreEffetPop(carte.getEffetSurPopularite());
	}
}
