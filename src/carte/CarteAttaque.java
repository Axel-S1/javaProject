package carte;

import joueur.Pirate;

public class CarteAttaque extends Carte {

	public CarteAttaque(String titre, String description, int effetSurVie, int effetSurPop){
		super("attaque", titre, description, effetSurVie, effetSurPop);
	}
	
	@Override
	public void faireEffet(Pirate pirate) {
		pirate.prendreEffetPop(getEffetSurPop());
		pirate.prendreEffetVie(getEffetSurVie());
	}
}
