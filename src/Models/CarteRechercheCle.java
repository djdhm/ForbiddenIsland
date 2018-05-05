package Models;

public class CarteRechercheCle implements Carte {
    private int id;
    private EffetCarte effetCarte;
    static int idCartes=1;

    public CarteRechercheCle(EffetCarte effetCarte) {
        this.effetCarte = effetCarte;
        this.id=idCartes++;
    }


    @Override
    public void effetCarte(Joueur joueur) {
        effetCarte.effetCarteRecherche(joueur);
    }

    @Override
    public String toString() {
        return "Carte :"+id+"avec "+effetCarte.toString();
    }
}
