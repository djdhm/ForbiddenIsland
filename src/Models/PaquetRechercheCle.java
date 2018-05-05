package Models;

import java.util.Collections;

public class PaquetRechercheCle extends PaquetCarte {

    @Override
    public void initialisationPaquet() {
            System.out.println("Preparer le paquet de carte de recherche cle");

            // Ajout des cartes sans effet
            EffetRien rien =new EffetRien();
            CarteRechercheCle carte = new CarteRechercheCle(rien);
            for(int i=0;i<5;i++){
                this.ajouterCarte(carte);
            }


            // Ajout des carte de cle
            for(int j=0;j<5;j++){
                    this.ajouterCarte(new CarteRechercheCle(new TrouveCle(Cle.CLEAIR)));
                    this.ajouterCarte(new CarteRechercheCle(new TrouveCle(Cle.CLEEAU)));
                    this.ajouterCarte(new CarteRechercheCle(new TrouveCle(Cle.CLETERRE)));
                    this.ajouterCarte(new CarteRechercheCle(new TrouveCle(Cle.CLEFEU)));
            }

            // Ajout des Carte MonteEau
            CarteRechercheCle monteEau=new CarteRechercheCle(new MonteEau());
            for(int k=0;k<5;k++){
                    this.ajouterCarte(monteEau);
            }
            this.melangerPaquet();
          System.out.print("La taille de deck est ");
           this.afficherInfo();

           this.tirerCarte();

           this.afficherInfo();


    }
}
