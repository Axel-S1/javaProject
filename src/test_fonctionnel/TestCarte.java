package test_fonctionnel;

import carte.Carte;
import carte.TouteCartePopularite;
import carte.TouteCarteAttaque;

public class TestCarte {
	public static void main(String[] args) {
		Carte cartePop = TouteCartePopularite.getRandomCarte();
		Carte carteAtt = TouteCarteAttaque.COUP_DE_SABRE.getCarte();
		System.out.println(cartePop.getDescription());
		System.out.println(carteAtt.getDescription());
	}

}
