package Models;

import TP.Observable;

import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public abstract class PaquetCarte extends Observable {
    private Stack<Carte> cartes;
    private  Stack<Carte> defausse;
    private boolean selection;
    private int nombreCarteARetirer;
    public PaquetCarte(){
        cartes=new Stack<>();
        defausse=new Stack<>();
        selection=false;
    }

    public void afficherInfo(){
        System.out.println("Le deck contient");
        System.out.println(cartes.size()+" Carte");
        System.out.println(defausse.size()+" Dans la defausse");
        for (Carte e: cartes) {
            System.out.println(e.toString());
        }

    }
    private void melangerDefausse(){
        System.out.println("Melanger le contenu de la defausse ...");
        Collections.shuffle(defausse);

    }

    public   void melangerPaquet(){
        System.out.println("Melanger le contenu du paquet de cartes ...");
        Collections.shuffle(cartes);
    }

    private void poserDansDefausse(Carte carte){

        defausse.push(carte)       ;

    }

    private void recupererDefausse(){
        System.out.println("recuperer la defausse  ...");
        cartes.addAll(defausse);
        defausse=new Stack<>();
    }

    public Carte tirerCarte(){
        Carte carte=this.cartes.pop();
        poserDansDefausse(carte);
        this.nombreCarteARetirer--;
        if(nombreCarteARetirer==0) this.basculerSelection();
        if(this.cartes.size()==0) this.recupererDefausse();
        return carte;

    }
    public void basculerSelection(){
        this.selection=!this.selection;
        if(selection) {nombreCarteARetirer=2;}
        notifyObservers();
    }
    public void ajouterCarte(Carte carte){
        cartes.push(carte);
    }
    abstract public void initialisationPaquet(Partie partie);

    public int getNombreCarteARetirer() {
        return nombreCarteARetirer;
    }
}
