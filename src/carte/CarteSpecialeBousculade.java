package carte;

import joueur.Pirate;

public class CarteSpecialeBousculade extends Carte {

	public CarteSpecialeBousculade(String titre, String description){
		super("speciale", titre, description);
	}
	
	@Override
	public void faireEffet(Pirate pirate) {
		for (int i = 0; i < 5; i++) {
			Carte carteASupprimer = pirate.getDeck()[i];
			if (carteASupprimer != null) pirate.supprimerCarte(carteASupprimer);
		}
	}
	
	@Override
	public int getEffetSurVie() {return 0;}
	@Override
	public int getEffetSurPop() {return 0;}
	
}