package my_interface;

public interface GameInterface{
    void afficherStatus(String nomPirate, int viePirate, int popPirate);
    void afficherPhraseDeFin(String nomPirate, char statutPirate);
    void afficherCarte(int numCarte, String typeCarte, String titreCarte, int effetVieCarte, int effetPopCarte);
    void afficherCarteSpeciale(int numCarte, String typeCarte, String titreCarte, String descCarte);
    void afficherCarteJouer(String nomPirate, String titreCarte, String descCarte);
    void afficherCoupPorterSurVie(String nomPirate, int effetSurVie);
    void afficherCoupPorterSurPop(String nomPirate, int effetSurPop);
    void afficherPhrasePirate(String phrase);
    void demanderChoix();
}
