package Models;

public class EffetRien implements EffetCarte {

    @Override
    public void effetCarteRecherche(Joueur joueur) {

        System.out.println("Vous ne faites rien pour le moment...");

    }

    @Override
    public String toString() {
        return "Effet neant";
    }
}
