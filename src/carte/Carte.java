package carte;

public abstract class Carte {
	private String type;
	private String titre;
	private String description;
	private int effetSurVie;
	private int effetSurPopularite;
	
	protected Carte(String type, String titre, String description, int effetSurVie, int effetSurPopularite){
		this.type = type;
		this.titre = titre;
		this.description = description;
		this.effetSurVie = effetSurVie;
		this.effetSurPopularite = effetSurPopularite;
	}
	
	public String getType() {return type;};
	public String getTitre() {return titre;};
	public String getDescription() {return description;};
	public int getEffetSurVie() {return effetSurVie;};
	public int getEffetSurPopularite() {return effetSurPopularite;};
	
	public abstract void faireAction();
}
