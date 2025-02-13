package carte;

import utils.MyRandom;

public enum TouteCartePopularite {
	REVOLTE_ORGANISEE(" Révolte Organisée ", "Au cours d'un abordage, le pirate fait preuve d'une grande bravoure et gagne 1 points de popularité", 0, 1),
	MAIN_DE_FER      ("    Main de fer    ", "il est fort... trop fort il se blesse", -1, 2);
	
	private Carte carte;
	private static MyRandom myrandom = new MyRandom();
	
	public Carte getCarte(){
		return carte;
	}
	
	public static Carte getRandomCarte(){
		return (TouteCartePopularite.values()[myrandom.getRandom(TouteCartePopularite.values().length)].getCarte());
	}
	
	private TouteCartePopularite(String titre, String description, int effetSurVie, int effetSurPopularite){
		 this.carte = new CartePopularite(titre, description, effetSurVie, effetSurPopularite);
	}
	
}
