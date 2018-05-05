package Models;

import java.util.ArrayList;

public class Partie {

    Grille grille;
    ArrayList<Joueur> joueurs;
    Joueur joueurActuel;
    ArrayList<Joueur> joueursEnvoles;
    PaquetRechercheCle paquqetCarteCle;
    PaquetCarteZone paquetCarteZone;


    public Partie(Grille grille,ArrayList<Joueur> joueurs){
        this.joueurs=joueurs;
        this.grille=grille;
        this.paquqetCarteCle=new PaquetRechercheCle();
        this.paquetCarteZone=new PaquetCarteZone();

    }
    public Partie(ArrayList<Joueur> joueurs){
        grille=new Grille();
        this.joueurs= joueurs;
        this.paquqetCarteCle=new PaquetRechercheCle();
        this.paquetCarteZone=new PaquetCarteZone();

    }
    public void initialiserPartie(){
        paquetCarteZone.initialisationPaquet();
        paquqetCarteCle.initialisationPaquet();
        grille.initialiserGrille();

    }

    public void  tourSuivant(){

        joueurActuel=joueurs.get((joueurs.indexOf(joueurActuel)+1)%joueurs.size());

    }

    public boolean partieGagne(){
        return  joueurs.size()==joueursEnvoles.size();
    }
    public boolean partiePerdu(){
        if(grille.getHeliport().getSituationZone()==EtatZone.SUBMERGEE){

            return true;
        }
        if(joueurs.size()==0){
            return  true;
        }
        return false;
    }

    public  Grille getGrille(){
        return this.grille;
    }

    public void  deplacerJoueur(Joueur j,int x,int y){

        j.setPosition(grille.getZone(x,y));


    }

}
