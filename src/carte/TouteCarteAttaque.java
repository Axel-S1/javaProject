package carte;

import utils.MyRandom;

public enum TouteCarteAttaque {
	COUP_DE_SABRE("Coup de sabre", "Le pirate inflige un coup de sabre féroce à son adversaire et lui inflige 2 point de vie", -2, 0),
	TIR_DE_PISTOLET("Tir de pistolet", "Le pirate tire dans la direction de son adversaire", -1, 0),
	COUP_DANS_LE_DOS("Coup dans le dos", "Pas très loyal...", -2, -1);
	
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
