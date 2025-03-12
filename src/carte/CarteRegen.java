package carte;

import joueur.Pirate;

public class CarteRegen extends Carte {

	public CarteRegen(String titre, String description, int effetSurVie, int effetSurPop){
		super("regen", titre, description, effetSurVie, effetSurPop);
	}
	
	@Override
	public void faireEffet(Pirate pirate) {
		pirate.prendreEffetPop(getEffetSurPop());
		pirate.prendreEffetVie(getEffetSurVie());
	}
}
