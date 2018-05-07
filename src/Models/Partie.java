package Models;

import TP.Observable;
import javafx.geometry.Pos;

import java.awt.*;
import java.util.ArrayList;

public class Partie extends Observable {

    static Dimension PositionDepart[]={
        new Dimension(2,2),
        new Dimension(4,4),
        new Dimension(1,3),
        new Dimension(0,4)
    };
    int actionRestantes;
    Grille grille;
    private ArrayList<Joueur> joueurs;
    private Joueur joueurActuel;
    ArrayList<Joueur> joueursEnvoles;
    PaquetRechercheCle paquqetCarteCle;
    PaquetCarteZone paquetCarteZone;


    public Partie(Grille grille,ArrayList<Joueur> joueurs){
        this.joueurs=joueurs;
        this.actionRestantes=3;
        this.grille=grille;

        this.paquqetCarteCle=new PaquetRechercheCle();
        this.paquetCarteZone=new PaquetCarteZone();

    }
    public Partie(ArrayList<Joueur> joueurs){
        grille=new Grille();
        this.joueurs= joueurs;
        this.joueurActuel=this.joueurs.get(0);
        this.paquqetCarteCle=new PaquetRechercheCle();
        this.paquetCarteZone=new PaquetCarteZone();

    }
    public void initialiserPartie(){
        grille.initialiserGrille();
        paquetCarteZone.initialisationPaquet();
        paquqetCarteCle.initialisationPaquet();
        for (int i=0;i<this.joueurs.size();i++) {
            joueurs.get(i).setPosition(grille.getZone(PositionDepart[i].width,PositionDepart[i].height));
        }


    }

    public void  tourSuivant(){
        this.actionRestantes=3;
        joueurActuel.setTour(false);
        joueurActuel=joueurs.get((joueurs.indexOf(joueurActuel)+1)%joueurs.size());
        joueurActuel.setTour(true);
        notifyObservers();
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

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }
    public int idJoueurActuel(){
        return joueurs.indexOf(joueurActuel);
    }

    public Joueur getJoueurActuel() {
        return joueurActuel;

    }
    public String getNomJoueurActuel(){
//        System.out.println("Joueur Actuel "+this.joueurActuel.getPseudo());
//        return this.joueurActuel.getPseudo();
        return joueurActuel.getPseudo();
    }

    public int getNombreAction() {
        return actionRestantes;
    }
    public void decNombreAction(){
        this.actionRestantes--;
        notifyObservers();
    }
}
