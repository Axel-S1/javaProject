package carte;

import utils.MyRandom;

public enum TouteCarteRegen {
	BISOUS_MAGIQUE("Bisous Magique", "Hop ! un petit bisou magique de la part du poisson péché ce matin", 3, -1),
	PANSEMENT("Pansement", "pour les bobos du quotidien !", 1, 0),
	ELIXIR_DE_JOUVENCE("Elixir de Jouvence", "Mais où as tu trouvé ça !!!", 4, 0);
	
	private Carte carte;
	private static MyRandom myrandom = new MyRandom();
	
	public Carte getCarte(){
		return carte;
	}
	
	public static Carte getRandomCarte(){
		return (TouteCarteRegen.values()[myrandom.getRandom(TouteCarteRegen.values().length)].getCarte());
	}
	
	private TouteCarteRegen(String titre, String description, int effetSurVie, int effetSurPopularite){
		 this.carte = new CarteRegen(titre, description, effetSurVie, effetSurPopularite);
	}
	
}
