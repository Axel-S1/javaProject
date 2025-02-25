package plateau;

import carte.Carte;
import joueur.Pirate;

public class Plateau {
	private static int nbMaxPirate = 2;
	
	private Pirate[] pirate = new Pirate[nbMaxPirate];
	private Zone zonePirate0 = null;
	private Zone zonePirate1 = null;
	
	
	public Plateau(String nomPirate0, String nomPirate1){
		pirate[0] = new Pirate(nomPirate0, 0);
		pirate[1] = new Pirate(nomPirate1, 1);
		
		zonePirate0 = new Zone(pirate[0]);
		zonePirate1 = new Zone(pirate[1]);
		
	}
	
	private Zone trouverZone(int idPirate, Carte carte){
		
		if 		(carte.getType().equals("popularite") && idPirate == 0) 	return zonePirate0;
		else if (carte.getType().equals("popularite") && idPirate == 1) 	return zonePirate1;
		else if (carte.getType().equals("attaque") && idPirate == 0) 	return zonePirate1;
		else if (carte.getType().equals("attaque") && idPirate == 1) 	return zonePirate0;
		else return null;
		
	}
	
	private void setAutrePirateMaxPopularite(Pirate pirate){
		if (pirate.getId() == 0) this.pirate[1].setPop(5);
		else this.pirate[0].setPop(5);
	}
	
	private void setAutrePirateMinVie(Pirate pirate){
		if (pirate.getId() == 0) this.pirate[1].setVie(0);
		else this.pirate[0].setVie(0);
	}
	
	private boolean doFinal() {
		boolean tempExit = true;
		
		for (int i = 0; i < nbMaxPirate ; i++) {
			char tempStatus = pirate[i].verifVictoireDefaite();
			
			if (tempStatus == 'W') {
				setAutrePirateMinVie(pirate[i]);
				tempExit = false;
			} else if (tempStatus == 'L'){
				setAutrePirateMaxPopularite(pirate[i]);
				tempExit = false;
			}
		}
		
		for (int i = 0; i < nbMaxPirate ; i++) {
			pirate[i].afficherPhraseDeFin();
		}
		
		return tempExit;
	}
	
	private void pourAfficherLesDeuxStatus() {
		pirate[0].afficherStatus();
		pirate[1].afficherStatus();
	}
	
	public boolean faireTourDeJeu() {
		for(int i = 0; i < nbMaxPirate; i++) {
			pourAfficherLesDeuxStatus();
			pirate[i].piocherCarte();
			pirate[i].afficherDeck();
			
			Carte carteAJouer = pirate[i].demanderChoix();
			Zone zoneAJouer = trouverZone(pirate[i].getId(), carteAJouer);
			
			if (zoneAJouer != null) {
				pirate[i].afficherCarteJouer(carteAJouer);
				zoneAJouer.placerCarte(carteAJouer);
				pirate[i].supprimerCarte(carteAJouer);
			}
			if (pirate[0].verifVictoireDefaite() != 'N' || pirate[1].verifVictoireDefaite() != 'N') return doFinal();
		}
		return true;
	}
}
