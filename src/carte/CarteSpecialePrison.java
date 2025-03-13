package carte;

import joueur.Pirate;

public class CarteSpecialePrison extends Carte {

	public CarteSpecialePrison(String titre, String description){
		super("speciale", titre, description);
	}
	
	@Override
	public void faireEffet(Pirate pirate) {
		pirate.setPrisonStatut(true);
	}
	
	@Override
	public int getEffetSurVie() {return 0;}
	@Override
	public int getEffetSurPop() {return 0;}
	
}