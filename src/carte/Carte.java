package carte;

import joueur.Pirate;

public abstract class Carte {
	private String type;
	private String titre;
	private String description;
	private int effetSurVie;
	private int effetSurPop;
	
	protected Carte(String type, String titre, String description, int effetSurVie, int effetSurPop){
		this.type = type;
		this.titre = titre;
		this.description = description;
		this.effetSurVie = effetSurVie;
		this.effetSurPop = effetSurPop;
	}
	
	@Override
	public String toString() {
		return titre;
	}
	
	public abstract void faireEffet(Pirate pirate);
	public String getType() {return type;}
	public String getTitre() {return titre;}
	public String getDescription() {return description;}
	public int getEffetSurVie() {return effetSurVie;}
	public int getEffetSurPop() {return effetSurPop;}
}
