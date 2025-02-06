package carte;

public enum TouteCarteAttaque {
	COUP_DE_SABRE("Coup de sabre", "Le pirate inflige un coup de sabre f�roce � son adversaire et lui inflige 2 d�gats", -2, 0);
	
	private Carte carte;
	
	public Carte getCarte(){
		return carte;
	}
	
	private TouteCarteAttaque(String titre, String description, int effetSurVie, int effetSurPopularite){
		 this.carte = new CarteAttaque(titre, description, effetSurVie, effetSurPopularite);
	}
	
}
