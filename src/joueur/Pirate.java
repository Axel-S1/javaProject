package joueur;
import java.util.Scanner;

import carte.Carte;
import carte.TouteCarteAttaque;
import carte.TouteCartePopularite;
import myInterface.GameInterface;
import utils.MyRandom;

public class Pirate implements GameInterface{
	private String nom;
	private int id;
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
		if (effetSurVie != 0) afficherCoupPorterSurVie(effetSurVie);
	}
	
	public void prendreEffetPop(int effetSurPop) {
		popularite += effetSurPop;
		if (effetSurPop != 0)afficherCoupPorterSurPop(effetSurPop);
	}
	
	public char verifVictoireDefaite(){
		if (vie <= 0) {
			return 'L';
		}
		else if (popularite >= 5) {
			return 'W';
		}
		else return 'N';
	}
	
	public  int getId() {
		return id;
	}
	
	public void setPop(int pop) {
		popularite = pop;
	}
	
	public void setVie(int vie) {
		this.vie = vie;
	}
	
	@Override
    public void afficherDeck() {
		System.out.println("\n");
        System.out.println("📜 Main du pirate " + nom + " :");
        for (int i = 0; i < nbCarteMax; i++) {
            Carte tempCarte = deck[i];
            if (tempCarte != null) {
                System.out.println("  🔹"+ (i+1) +" Carte " + tempCarte.getType() + " : " + tempCarte.getTitre());
                System.out.println("     ➤ Vie : " + tempCarte.getEffetSurVie() + " | Popularité : " + tempCarte.getEffetSurPopularite());
            } else {
                System.out.println("  [ Emplacement vide ]");
            }
        }
        System.out.println("\n");
    }
	
	@Override
	public void afficherCarteJouer(Carte carte) {
	    System.out.println("🎴 Le pirate " + nom + " joue la carte : " + carte.getTitre());
	    System.out.println("    📝 Description : " + carte.getDescription());
	    System.out.println("\n");
	}

    @Override
    public void afficherStatus() {
        System.out.println("📊 Pirate " + nom + " - Vie : " + vie + " | Popularité : " + popularite);
    }

    @Override
    public void afficherPhraseDeFin() {
    	if (vie <= 0) {
    		System.out.println("🏆 Le pirate " + nom + " soupire : \"J'ai perdu, je l'admet !\"");
    	}
    	else if (popularite >= 5) {
    		System.out.println("🏆 Le pirate " + nom + " crie : \"J'ai gagné cette bataille !\" 🎉");
    	}
    }
    
    @Override
    public void afficherCoupPorterSurVie(int effetSurVie) {
        if (effetSurVie > 0)
            System.out.println("❤️ Le pirate " + nom + " récupère " + effetSurVie + " points de vie !");
        else
            System.out.println("💔 Le pirate " + nom + " perd " + Math.abs(effetSurVie) + " points de vie !");
        System.out.println("\n");
    }

    @Override
    public void afficherCoupPorterSurPop(int effetSurPop) {
        if (effetSurPop > 0)
            System.out.println("📈 La popularité du pirate " + nom + " augmente de " + effetSurPop + " !");
        else
            System.out.println("📉 La popularité du pirate " + nom + " diminue de " + Math.abs(effetSurPop) + " !");
        System.out.println("\n");
    }
}
