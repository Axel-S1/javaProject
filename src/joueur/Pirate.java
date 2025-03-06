package joueur;
import java.util.Scanner;

import carte.Carte;
import carte.TouteCarteAttaque;
import carte.TouteCartePopularite;
import my_interface.GameInterface;
import utils.MyRandom;

public class Pirate{
	private String nom;
	private int id;
	private char statut = 'N';
	private int vie = 5;
	private int popularite = 0;
	private static int nbCarteMax = 5;
	private Carte[] deck = new Carte[nbCarteMax];
	private MyRandom myrandom = new MyRandom();
	private static final Scanner scanner = new Scanner(System.in);
	 
	public Pirate(String nom, int id){
		this.nom = nom;
		this.id = id;
	}
	
	public void piocherCarte(){
		for (int i = 0; i < nbCarteMax; i++) {
			if(deck[i] == null) {
				if (myrandom.getRandom(2) == 0) deck[i] = TouteCartePopularite.getRandomCarte();
				else deck[i] = TouteCarteAttaque.getRandomCarte();
			}
				
		}
	}
	
	public Carte demanderChoix() {
	    int choix = -1;

	    while (choix < 1 || choix > 5 || deck[choix - 1] == null) {
	        System.out.print("Choisissez une carte (1-5) : ");
	        if (scanner.hasNextInt()) choix = scanner.nextInt();
	        else scanner.next();
	    }
	    
	    return deck[choix - 1];
	}
	
	public void supprimerCarte(Carte carte){
		for (int i = 0; i < nbCarteMax; i++){
			if (deck[i].getTitre().equals(carte.getTitre())) {
				deck[i] = null;
				break;
			}
		}
	}
	
	public void prendreEffetVie(int effetSurVie) {
		vie += effetSurVie;
		if (effetSurVie != 0); //TODO afficherCoupPorterSurVie(effetSurVie);
	}
	
	public void prendreEffetPop(int effetSurPop) {
		popularite += effetSurPop;
		if (effetSurPop != 0); //TODO afficherCoupPorterSurPop(effetSurPop);
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
}
