package joueur;
import carte.Carte;
import carte.TouteCarteAttaque;
import carte.TouteCartePopularite;
import plateau.Zone;
import utils.MyRandom;

public class Pirate {
	private String nom;
	private int vie = 5;
	private int popularite = 0;
	private int nbCarte = 0;
	private static int nbCarteMax = 5;
	private Carte[] main = new Carte[nbCarteMax];
	private MyRandom myrandom = new MyRandom();
	
	public Pirate(String nom){
		this.nom = nom;
	}
	
	
	public void piocherCarte(){
		for (int i = 0; i < nbCarteMax; i++) {
			if(main[i] == null) {
				if (myrandom.getRandom(2) == 0) main[i] = TouteCartePopularite.getRandomCarte();
				else main[i] = TouteCarteAttaque.getRandomCarte();
				nbCarte++;
			}
				
		}
	}
	
	//Temporary A déplacer
	public void afficherMain(){
		for (int i = 0; i < nbCarteMax; i++) {
			Carte tempCarte = main[i];
			System.out.println("Carte " + tempCarte.getType() + " : " + tempCarte.getTitre() + "\n\tEffet :\t-Vie : " + tempCarte.getEffetSurVie() + "\t-Popularité : " + tempCarte.getEffetSurPopularite() + "\n\n");
		}
	}
	
	public void jouerCarte(Zone zone, Carte carte){
		zone.placerCarte(carte);
		supprimerCarte(carte);
	}
	
	public Carte demanderChoix(){
		return main[myrandom.getRandom(5)];
	}
	
	private void supprimerCarte(Carte carte){
		for (int i = 0; i < nbCarteMax; i++){
			if (main[i].getTitre().equals(carte.getTitre())) {
				main[i] = null;
				nbCarte--;
				break;
			}
		}
	}
	
	public char checkWinLoose(){
		if (popularite >= 5) return 'W';
		else if (vie <= 0) return 'L';
		else return 'N';
	}
	
}
