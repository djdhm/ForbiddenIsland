package Models;

import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public abstract class PaquetCarte {
    private Stack<Carte> cartes;
    private  Stack<Carte> defausse;

    public PaquetCarte(){
        cartes=new Stack<>();
        defausse=new Stack<>();

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
        return carte;

    }
    public void ajouterCarte(Carte carte){
        cartes.push(carte);
    }
    abstract public void initialisationPaquet();

}
