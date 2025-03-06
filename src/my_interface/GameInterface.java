package my_interface;

import carte.Carte;
import joueur.Pirate;

public interface GameInterface{
    void afficherStatus(Pirate pirate);
    void afficherPhraseDeFin(Pirate pirate);
    void afficherDeck(Pirate pirate);
    void afficherCarteJouer(Pirate pirate, Carte carte);
    void afficherCoupPorterSurVie(Pirate pirate, int effetSurVie);
    void afficherCoupPorterSurPop(Pirate pirate, int effetSurPop);
}
