package carte;

import joueur.Pirate;

public class CartePopularite extends Carte {

	public CartePopularite(String titre, String description, int effetSurVie, int effetSurPop){
		super("popularite", titre, description, effetSurVie, effetSurPop);
	}
	
	@Override
	public void faireEffet(Pirate pirate){
		pirate.prendreEffetPop(getEffetSurPop());
		pirate.prendreEffetVie(getEffetSurVie());
	}
}

