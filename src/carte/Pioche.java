package carte;

import utils.MyRandom;

public class Pioche {
	private static int nbCarteMax = 500;
	private Carte[] pilleDeCarte = new Carte[nbCarteMax];
	private int nbCarte = 0;
	
	private int nbCarteAttaque = 0;
	private int nbCartePop = 0;
	private int nbCarteRegen = 0;
	
	
	private static MyRandom myrandom = new MyRandom();
	
	
	public Pioche(int nbCarteAttaque, int nbCartePop, int nbCarteRegen){
		this.nbCarteAttaque = nbCarteAttaque;
		this.nbCartePop = nbCartePop;
		this.nbCarteRegen = nbCarteRegen;
		remplirPioche();
	}
	
	public Carte prendreCarte() {
		if (nbCarte <= 0) remplirPioche();
		
		
		int randNumCarte = myrandom.getRandom(nbCarte);
		Carte carteToreturn = pilleDeCarte[randNumCarte];
		
		pilleDeCarte[randNumCarte] = pilleDeCarte[nbCarte-1];
		pilleDeCarte[nbCarte-1] = null;
		nbCarte--;
		
		return carteToreturn;
	}
	
	
	private void remplirPioche(){
		for(int i = 0; i < nbCarteAttaque; i++) 			pilleDeCarte[i] = TouteCarteAttaque.getRandomCarte();
		nbCarte += nbCarteAttaque;
		
		for(int i = nbCarte; i < nbCarte+nbCartePop; i++)	pilleDeCarte[i] = TouteCartePopularite.getRandomCarte();
		nbCarte += nbCartePop;
		
		for(int i = nbCarte; i < nbCarte+nbCarteRegen; i++)	pilleDeCarte[i] = TouteCarteRegen.getRandomCarte();
		nbCarte += nbCarteRegen;
	}
}
