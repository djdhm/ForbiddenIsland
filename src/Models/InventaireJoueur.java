package Models;

import TP.Observable;

import java.util.ArrayList;

public class InventaireJoueur  extends Observable{

    private ArrayList<ElementArtefact> tresors;
    private ArrayList<Cle> cles;


    public InventaireJoueur(){

    }

    public void ajouterCle( Cle cle ){
            this.cles.add(cle);
            notifyObservers();
    }

    public void ajouterTresor(ElementArtefact elementArtefact){
        this.tresors.add(elementArtefact);
        notifyObservers();
    }
    public void retirerCle(Cle cle){
        this.cles.remove(cle);
        notifyObservers();
    }
}
