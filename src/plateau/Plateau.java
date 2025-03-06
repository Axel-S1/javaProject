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

//	public boolean notUse() {
//		for(int i = 0; i < nbMaxPirate; i++) {
//			pourAfficherLesDeuxStatus();
//			pirate[i].piocherCarte();
//			pirate[i].afficherDeck();
//			
//			Carte carteAJouer = pirate[i].demanderChoix();
//			Zone zoneAJouer = trouverZone(pirate[i].getId(), carteAJouer);
//			
//			if (zoneAJouer != null) {
//				pirate[i].afficherCarteJouer(carteAJouer);
//				zoneAJouer.placerCarte(carteAJouer);
//				pirate[i].supprimerCarte(carteAJouer);
//			}
//			if (pirate[0].verifVictoireDefaite() != 'N' || pirate[1].verifVictoireDefaite() != 'N') return doFinal();
//		}
//		return true;
//	}
}
