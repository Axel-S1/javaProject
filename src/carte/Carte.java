package carte;

import joueur.Pirate;

public abstract class Carte {
	private String type;
	private String titre;
	private String description;
	
	protected Carte(String type, String titre, String description){
		this.type = type;
		this.titre = titre;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return titre;
	}
	
	public abstract void faireEffet(Pirate pirate);
	public String getType() {return type;}
	public String getTitre() {return titre;}
	public String getDescription() {return description;}
	public abstract int getEffetSurVie();
	public abstract int getEffetSurPop();
}
