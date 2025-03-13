package carte;

import joueur.Pirate;

public class CarteRegen extends Carte {

	private int effetSurVie;
	private int effetSurPop;
	
	public CarteRegen(String titre, String description, int effetSurVie, int effetSurPop){
		super("regen", titre, description);
		this.effetSurVie = effetSurVie;
		this.effetSurPop = effetSurPop;
	}
	
	@Override
	public void faireEffet(Pirate pirate) {
		pirate.prendreEffetPop(effetSurPop);
		pirate.prendreEffetVie(effetSurVie);
	}
	
	@Override
	public int getEffetSurVie() {return effetSurVie;}
	@Override
	public int getEffetSurPop() {return effetSurPop;}
}
