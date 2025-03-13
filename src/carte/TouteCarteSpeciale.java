package carte;

import utils.MyRandom;

public enum TouteCarteSpeciale {
	BOUSCULADE("Bousculade", "Le pirate fait tomber les cartes de son adversaire"),
	PRISON("Prison", "Le pirate place son adversaire en prison !");
	
	private Carte carte;
	private static MyRandom myrandom = new MyRandom();
	
	public Carte getCarte(){
		return carte;
	}
	
	public static Carte getRandomCarte(){
		return (TouteCarteSpeciale.values()[myrandom.getRandom(TouteCarteSpeciale.values().length)].getCarte());
	}
	
	private TouteCarteSpeciale(String titre, String description){
		if (titre.equals("Bousculade")) this.carte = new CarteSpecialeBousculade(titre, description);
		else if (titre.equals("Prison")) this.carte = new CarteSpecialePrison(titre, description);
	}
	
}