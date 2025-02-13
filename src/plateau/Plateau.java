package plateau;

import carte.Carte;
import joueur.Pirate;

public class Plateau {
	private static int nbMaxPirate = 2;
	
	private ZoneDAttaque zoneDattaque = new ZoneDAttaque();
	private ZoneDePopularite zoneDePopularite1 = new ZoneDePopularite();
	private ZoneDePopularite zoneDePopularite2 = new ZoneDePopularite();
	private Pirate[] pirate = new Pirate[nbMaxPirate];
	
	
	public Plateau(String nomPirate1, String nomPirate2){
		pirate[0] = new Pirate(nomPirate1);
		pirate[1] = new Pirate(nomPirate2);
	}
	
	private Zone trouverZone(int pirate, Carte carte) {
		if (carte.getType().equals("popularite")) {
			if (pirate == 0) return zoneDePopularite1;
			else return zoneDePopularite2;
			
		}
		else if (carte.getType().equals("attaque")) return zoneDattaque;
		return null;
	}
	
	public int faireTour() {
		pirate[0].piocherCarte();
		pirate[0].afficherMain();
		Carte carteAJouer = pirate[0].demanderChoix();
		pirate[0].jouerCarte(trouverZone(0, carteAJouer), carteAJouer);
		if (pirate[0].checkWinLoose() != 'N') return 1;
		else if (pirate[1].checkWinLoose() != 'N') return 1;
		
		return 0;
	}
}
