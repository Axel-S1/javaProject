package joueur;
import carte.Carte;

public class Pirate {
	private String nom;
	private int vie;
	private int popularite;
	private Carte[] carte = new Carte[5];
	
	public void piocherCarte(int nbCarte){
		
	}
	
	public void jouerCarte(int nbCarte){
	}
	
	public char checkWinLoose(){
		if (popularite >= 10) return 'W';
		else if (vie <= 0) return 'L';
		else return 'N';
	}
	
}
