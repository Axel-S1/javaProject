package plateau;

import carte.Carte;

public class Plateau {
	private Zone zoneAttaque = new Zone();
	private Zone zonePopPirate0 = new Zone();
	private Zone zonePopPirate1 = new Zone();
	
	
	private Zone trouverZone(Carte carte, int pirateID){
		
		if (carte.getType().equals("attaque")) {
			return zoneAttaque;
		}
		else {
			if (pirateID == 0) return zonePopPirate0;
			else return zonePopPirate1;
		}
		
	}

	public void ajouterALaZone(Carte carte, int pirateID) {
		trouverZone(carte, pirateID).placerCarte(carte);
	}
}
