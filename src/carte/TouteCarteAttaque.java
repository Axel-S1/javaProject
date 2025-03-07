package carte;

import utils.MyRandom;

public enum TouteCarteAttaque {
	COUP_DE_SABRE("   Coup de sabre   ", "Le pirate inflige un coup de sabre f�roce � son adversaire et lui inflige 2 point de vie", -2, 0);
	
	private Carte carte;
	private static MyRandom myrandom = new MyRandom();
	
	public Carte getCarte(){
		return carte;
	}
	
	public static Carte getRandomCarte(){
		return (TouteCarteAttaque.values()[myrandom.getRandom(TouteCarteAttaque.values().length)].getCarte());
	}
	
	private TouteCarteAttaque(String titre, String description, int effetSurVie, int effetSurPopularite){
		 this.carte = new CarteAttaque(titre, description, effetSurVie, effetSurPopularite);
	}
	
}
