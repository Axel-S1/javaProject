package jeu;

import carte.Carte;
import carte.Pioche;
import joueur.Pirate;
import my_interface.Journal;
import plateau.Plateau;

public class GameMain {
	private static int nbMaxPirate = 2;
	private static int nbCarteAttaque = 50;
	private static int nbCartePop = 100;
	private static int nbCarteRegen = 15;
	private static Plateau plateau = new Plateau();
	private static Pirate[] pirate = new Pirate[nbMaxPirate];
	private static Pioche pioche = new Pioche(nbCarteAttaque, nbCartePop, nbCarteRegen);
	public static final Journal journal = new Journal();
	
	private static void initJeu() {
		pirate[0] = new Pirate("Luffy", 0);
		pirate[1] = new Pirate("Teach", 0);
	}
	
	private static void afficherStatusDesPirates(){
		journal.afficherStatus(pirate[0].getNom(), pirate[0].getVie(), pirate[0].getPop());
		journal.afficherStatus(pirate[1].getNom(), pirate[1].getVie(), pirate[1].getPop());
	}
	
	private static int trouverPirateID(Carte carte, int currentID) {
		if (carte.getType().equals("attaque")) return ((currentID+1)%2);
		return currentID;
	}
	
	private static boolean doFinal(){
		for (int i = 0; i < nbMaxPirate; i++) {
			if (pirate[i].getStatut() == 'W') pirate[(i+1)%2].setStatut('L');
			else if (pirate[i].getStatut() == 'L') pirate[(i+1)%2].setStatut('W');
		}
		
		return false;
	}
	
	private static boolean faireTourDeJeu() {
		for(int i = 0; i < nbMaxPirate; i++) {
			afficherStatusDesPirates();
			
			pirate[i].piocherCarte(pioche);
			pirate[i].pourAfficherDeck();
			
			Carte carteAJouer = pirate[i].demanderChoix();
			journal.afficherCarteJouer(pirate[i].getNom(), carteAJouer.getTitre(), carteAJouer.getDescription());
			carteAJouer.faireEffet(pirate[trouverPirateID(carteAJouer, i)]);
			plateau.ajouterALaZone(carteAJouer, i);
			pirate[i].supprimerCarte(carteAJouer);
			
			if (pirate[0].verifVictoireDefaite() != 'N' || pirate[1].verifVictoireDefaite() != 'N') return doFinal();
		}
		return true;
	}
	
	public static void main(String[] args){
		
		initJeu();
		
		boolean partieEnCours = true;
		do{
			partieEnCours = faireTourDeJeu();
		}while(partieEnCours);
		
		for (int i = 0; i < nbMaxPirate; i++) {
			journal.afficherPhraseDeFin(pirate[i].getNom(), pirate[i].getStatut());
		}
	}	
}
