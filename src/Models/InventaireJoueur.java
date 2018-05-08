package Models;

import TP.Observable;

import java.util.ArrayList;

public class InventaireJoueur  extends Observable{

    private ArrayList<ElementArtefact> tresors;
    private ArrayList<Cle> cles;


    public InventaireJoueur(){
        cles=new ArrayList<>();
        tresors=new ArrayList<>();
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

    public ArrayList<Cle> getCles() {
        return cles;
    }

    public ArrayList<ElementArtefact> getTresors() {
        return tresors;
    }

    public void supprimer(ElementArtefact elementArtefact) {
        this.getCles().removeIf(cle -> {
            return cle.getElementCle().equals(elementArtefact);
        });
        notifyObservers();
    }
}
