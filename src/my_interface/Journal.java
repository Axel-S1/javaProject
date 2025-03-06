package my_interface;

import carte.Carte;
import joueur.Pirate;

public class Journal implements GameInterface{
	
	@Override
    public void afficherDeck(Pirate pirate){
		System.out.println("\n");
        System.out.println("ðŸ“œ Main du pirate " + pirate.getNom() + " :");
        Carte[] deck = pirate.getDeck();
        for (int i = 0; i < 5; i++) {
            Carte tempCarte = deck[i];
            if (tempCarte != null) {
                System.out.println("  ðŸ”¹"+ (i+1) +" Carte " + tempCarte.getType() + " : " + tempCarte.getTitre());
                System.out.println("     âž¤ Vie : " + tempCarte.getEffetSurVie() + " | PopularitÃ© : " + tempCarte.getEffetSurPop());
            } else {
                System.out.println("  [ Emplacement vide ]");
            }
        }
        System.out.println("\n");
    }
	
	@Override
	public void afficherCarteJouer(Pirate pirate, Carte carte) {
	    System.out.println("ðŸŽ´ Le pirate " + pirate.getNom() + " joue la carte : " + carte.getTitre());
	    System.out.println("    ðŸ“� Description : " + carte.getDescription());
	    System.out.println("\n");
	}

    @Override
    public void afficherStatus(Pirate pirate) {
        System.out.println("ðŸ“Š Pirate " + pirate.getNom() + " - Vie : " + pirate.getVie() + " | PopularitÃ© : " + pirate.getPop());
    }

    @Override
    public void afficherPhraseDeFin(Pirate pirate) {
    	System.out.println("");
    	if (pirate.getStatut() == 'L') {
    		System.out.println("ðŸ�† Le pirate " + pirate.getNom() + " soupire : \"J'ai perdu, je l'admet !\"");
    	}
    	else{
    		System.out.println("ðŸ�† Le pirate " + pirate.getNom() + " crie : \"J'ai gagnÃ© cette bataille !\" ðŸŽ‰");
    	}
    }
    
    @Override
    public void afficherCoupPorterSurVie(Pirate pirate, int effetSurVie) {
        if (effetSurVie > 0)
            System.out.println("â�¤ï¸� Le pirate " + pirate.getNom() + " rÃ©cupÃ¨re " + effetSurVie + " points de vie !");
        else
            System.out.println("ðŸ’” Le pirate " + pirate.getNom() + " perd " + Math.abs(effetSurVie) + " points de vie !");
        System.out.println("\n");
    }

    @Override
    public void afficherCoupPorterSurPop(Pirate pirate, int effetSurPop) {
        if (effetSurPop > 0)
            System.out.println("ðŸ“ˆ La popularitÃ© du pirate " + pirate.getNom() + " augmente de " + effetSurPop + " !");
        else
            System.out.println("ðŸ“‰ La popularitÃ© du pirate " + pirate.getNom() + " diminue de " + Math.abs(effetSurPop) + " !");
        System.out.println("\n");
    }
}
