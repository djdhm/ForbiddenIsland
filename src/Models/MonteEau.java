package Models;

public class MonteEau implements  EffetCarte {



    @Override
    public void effetCarteRecherche(Joueur joueur) {

        System.out.println("La zone que vous occupiez sera innonde fuyez des que possible ...");
        joueur.monteEau();
    }

    @Override
    public String toString() {
        return "Effet Montee des eaux";
    }
}
