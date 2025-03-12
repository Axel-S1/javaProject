package my_interface;

public class Journal implements GameInterface{
	
	@Override
	public void afficherPhraseDeDeck(String phrase) {
		System.out.println("\n");
		System.out.println(phrase);
	}
	
	@Override
    public void afficherCarte(int numCarte, String typeCarte, String titreCarte, int effetVieCarte, int effetPopCarte){
        System.out.println(" - "+ numCarte +" Carte " + typeCarte + " : " + titreCarte);
        System.out.println("     - Vie : " + effetVieCarte + " | Popularité : " + effetPopCarte);
        System.out.println("");
    }
	
	@Override
	public void afficherCarteJouer(String nomPirate, String titreCarte, String descCarte) {
	    System.out.println(nomPirate + " joue la carte : " + titreCarte);
	    System.out.println("Description : " + descCarte);
	    System.out.println("\n");
	}

    @Override
    public void afficherStatus(String nomPirate, int viePirate, int popPirate) {
        System.out.println("le Pirate " + nomPirate + " - Vie : " + viePirate + " | Popularité : " + popPirate);
    }

    @Override
    public void afficherPhraseDeFin(String nomPirate, char statutPirate) {
    	System.out.println("");
    	if (statutPirate == 'L') {
    		System.out.println(nomPirate + " soupire : \"J'ai perdu, je l'admet !\"");
    	}
    	else{
    		System.out.println(nomPirate + " crie : \"J'ai gagné cette bataille !\"");
    	}
    }
    
    @Override
    public void afficherCoupPorterSurVie(String nomPirate, int effetSurVie) {
        if (effetSurVie > 0)
            System.out.println("Le pirate " + nomPirate + " récupère " + effetSurVie + " points de vie !");
        else
            System.out.println("Le pirate " + nomPirate + " perd " + Math.abs(effetSurVie) + " points de vie !");
        System.out.println("\n");
    }

    @Override
    public void afficherCoupPorterSurPop(String nomPirate, int effetSurPop) {
        if (effetSurPop > 0)
            System.out.println("La popularité du pirate " + nomPirate + " augmente de " + effetSurPop + " !");
        else
            System.out.println("La popularité du pirate " + nomPirate + " diminue de " + Math.abs(effetSurPop) + " !");
        System.out.println("\n");
    }
    
    @Override
    public void demanderChoix() {
    	System.out.print("Choisissez une carte (1-5) : ");
    	System.out.print("\n");
    }
    
}
