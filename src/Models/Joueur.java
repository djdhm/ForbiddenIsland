package Models;

import Views.New.Tresor;

import java.util.ArrayList;
import java.util.HashMap;

public class Joueur {

    private int id;
    private String pseudo;
    private Zone position;
    private InventaireJoueur inventaire;

    static int idsJoueurs=1;

    public Joueur(String pseudo, Zone position) {
        this.id=idsJoueurs++;
        this.pseudo = pseudo;
        this.position = position;
        inventaire=new InventaireJoueur();

    }

    public void recevoirCle(Cle nouvelleCle){
        inventaire.ajouterCle(nouvelleCle);

    }
    public void recevoirTresor(ElementArtefact elementArtefact){
        inventaire.ajouterTresor(elementArtefact);
    }
    public void monteEau(){
        position.innoderZone();
    }
    public Zone getPosition() {
        return position;
    }
    public void setPosition(Zone position){
        this.position=position;
    }

    public int getId() {
        return id;
    }
}

