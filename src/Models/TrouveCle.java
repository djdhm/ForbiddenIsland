package Models;

public class TrouveCle implements EffetCarte {
    private Cle cle;

    public TrouveCle(Cle cle) {
        this.cle = cle;
    }

    @Override
    public void effetCarteRecherche(Joueur joueur) {

                System.out.println("Bravo vous avez trouve une cle");
                joueur.recevoirCle(cle);

    }

    @Override
    public String toString() {
        return "Effet Trouve Cle de l'element "+cle.getElementCle().toString();
    }
}
