package Models;

import TP.Observable;
import Views.New.Tresor;

import java.util.ArrayList;
import java.util.HashMap;

public class Joueur extends Observable {

    private int id;
    private String pseudo;
    private Zone position;
    private Zone anciennePosition;
    private InventaireJoueur inventaire;
    private boolean tour;
    static int idsJoueurs=1;

    public Joueur(String pseudo, Zone position) {
        this.tour=false;
        this.id=idsJoueurs++;
        this.pseudo = pseudo;
        this.position = position;
        inventaire=new InventaireJoueur();

    }

    public void recevoirCle(Cle nouvelleCle){
        inventaire.ajouterCle(nouvelleCle);
        notifyObservers();

    }
    public void recevoirTresor(ElementArtefact elementArtefact){
        inventaire.ajouterTresor(elementArtefact);
        notifyObservers();
    }
    public void monteEau(){
        position.innoderZone();
    }
    public Zone getPosition() {
        return position;
    }
    public void setPosition(Zone position){

        if(this.position!=null){
            System.out.println("Retirer le joueur de la case precedente");
            this.position.removeJoueur(this);
        }
        this.position=position;
        System.out.println("Affichage dans la case arrivé");
        this.position.ajouterJoueur(this);
        notifyObservers();
    }

    public int getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public boolean isTour() {
        return tour;
    }
    public void setTour(boolean tour){
        this.tour=tour;
        notifyObservers();
    }


    public Zone getAnciennePosition() {
        return anciennePosition;
    }
}
