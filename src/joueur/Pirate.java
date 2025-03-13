package joueur;

import java.util.Scanner;
import carte.Carte;
import carte.Pioche;
import my_interface.Journal;

public class Pirate{
	private static final Scanner scanner = new Scanner(System.in);
	private static int nbCarteMax = 5;
	private static Journal journal = new Journal();
	
	private String nom;
	private int id;
	
	private char statut = 'N';
	private int vie = 5;
	private int popularite = 0;
	private boolean isInPrison = false;
	
	private Carte[] deck = new Carte[nbCarteMax];
	 
	public Pirate(String nom, int id){
		this.nom = nom;
		this.id = id;
	}
	
	public void piocherCarte(Pioche pioche){
		for (int i = 0; i < nbCarteMax; i++) {
			if(deck[i] == null) {
				deck[i] = pioche.prendreCarte();
			}
				
		}
	}
	
	public Carte demanderChoix() {
		if(!isInPrison) {
			int choix = -1;

		    while (choix < 1 || choix > 5 || deck[choix - 1] == null) {
		    	journal.demanderChoix();
		        if (scanner.hasNextInt()) choix = scanner.nextInt();
		        else scanner.next();
		    }
		    return deck[choix - 1];
		}else {
			journal.afficherPhrasePirate(nom + " : Pourquoi je suis en prison ! Je ne peux pas jouer !!!\n");
			isInPrison = false;
			return null;
		}
		
	}
	
	public void supprimerCarte(Carte carte){
		for (int i = 0; i < nbCarteMax; i++){
			if (deck[i] != null && deck[i].getTitre().equals(carte.getTitre())) {
				deck[i] = null;
				break;
			}
		}
	}
	
	public void prendreEffetVie(int effetSurVie) {
		if (effetSurVie != 0){
			vie += effetSurVie;
			journal.afficherCoupPorterSurVie(nom, effetSurVie);
		}
	}
	
	public void prendreEffetPop(int effetSurPop) {
		if (effetSurPop != 0) {
			popularite += effetSurPop;
			journal.afficherCoupPorterSurPop(nom, effetSurPop);
		}
	}
	
	public char verifVictoireDefaite(){
		if (vie <= 0) {
			setStatut('L');
		}
		else if (popularite >= 5) {
			setStatut('W');
		}
		else setStatut('N');
		return statut;
	}
	
	public void setStatut(char statut) {
		this.statut = statut;
	}
	
	public void setPrisonStatut(boolean bool) {
		isInPrison = bool;
	}
	
	public void pourAfficherDeck() {
		journal.afficherPhrasePirate("La Main du pirate " + nom + " :");
		for (int i = 0; i < nbCarteMax; i++) {
			if (deck[i] != null) {
				if (deck[i].getType().equals("speciale")) {
					journal.afficherCarteSpeciale(i+1, deck[i].getType(), deck[i].getTitre(), deck[i].getDescription());
				}else {
					journal.afficherCarte(i+1, deck[i].getType(), deck[i].getTitre(), deck[i].getEffetSurVie(), deck[i].getEffetSurPop());
				}
				
			}
		}
	}
	
	public String getNom() {
		return nom;
	}
	
	public  int getId() {
		return id;
	}
	
	public char getStatut() {
		return statut;
	}
	
	public int getVie() {
		return vie;
	}
	
	public int getPop() {
		return popularite;
	}
	
	public Carte[] getDeck() {
		return deck;
	}
	
	public boolean getPrisonStatut() {
		return isInPrison;
	}
}
