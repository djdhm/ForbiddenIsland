package Models;

public class PaquetCarteZone extends  PaquetCarte{



    @Override
    public void initialisationPaquet(Partie partie) {
        System.out.println("Preparer le paquet de carte de zone");
        CarteZone carteZone;
        Grille grille=partie.getGrille();
        for(int i=1;i<5;i++){
            for(int j=1;j<5;j++){
                carteZone=new CarteZone(grille.getZone(i,j));
                this.ajouterCarte(carteZone);
            }
        }
          carteZone=new CarteZone(grille.getZone(0,3));
        this.ajouterCarte(carteZone);
          carteZone=new CarteZone(grille.getZone(5,2));
        this.ajouterCarte(carteZone);
          carteZone=new CarteZone(grille.getZone(5,3));
        this.ajouterCarte(carteZone);
          carteZone=new CarteZone(grille.getZone(2,0));
        this.ajouterCarte(carteZone);
          carteZone=new CarteZone(grille.getZone(2,5));
        this.ajouterCarte(carteZone);
          carteZone=new CarteZone(grille.getZone(0,2));
        this.ajouterCarte(carteZone);
          carteZone=new CarteZone(grille.getZone(2,0));
        this.ajouterCarte(carteZone);
          carteZone=new CarteZone(grille.getZone(3,5));
        this.ajouterCarte(carteZone);
          carteZone=new CarteZone(grille.getZone(3,5));
        this.ajouterCarte(carteZone);
        this.melangerPaquet();

    }
}
