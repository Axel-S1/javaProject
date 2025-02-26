package my_interface;

import carte.Carte;

public interface GameInterface{
    void afficherDeck();
    void afficherStatus();
    void afficherPhraseDeFin();
    void afficherCarteJouer(Carte carte);
    void afficherCoupPorterSurVie(int effetSurVie);
    void afficherCoupPorterSurPop(int effetSurPop);
}
