package jeu;

import carte.Carte;
import joueur.Pirate;
import my_interface.Journal;
import plateau.Plateau;

public class GameMain {
	private static int nbMaxPirate = 2;
	private static Plateau plateau = new Plateau();
	private static Pirate[] pirate = new Pirate[nbMaxPirate];
	private static Journal journal = new Journal();
	
	private static void initJeu() {
		pirate[0] = new Pirate("Luffy", 0);
		pirate[1] = new Pirate("Teach", 0);
	}
	
	private static void afficherStatusDesPirates(){
		journal.afficherStatus(pirate[0]);
		journal.afficherStatus(pirate[1]);
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
			
			pirate[i].piocherCarte();
			journal.afficherDeck(pirate[i]);
			
			Carte carteAJouer = pirate[i].demanderChoix();
			carteAJouer.faireEffet(pirate[trouverPirateID(carteAJouer, i)]);
			plateau.ajouterALaZone(carteAJouer, i);
			journal.afficherCarteJouer(pirate[i], carteAJouer);
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
			journal.afficherPhraseDeFin(pirate[i]);
		}
	}	
}
