package Models;

import java.util.ArrayList;
import java.util.HashMap;

public class Joueur {

    private int id;
    private String pseudo;
    private Zone position;
    private HashMap<ElementArtefact,ArrayList<Cle>> cles ;
    private ArrayList<Artefact> artefacts;

    public Joueur(String pseudo, Zone position) {
        this.pseudo = pseudo;
        this.position = position;
        cles=new HashMap<>();

    }

    public void recevoirCle(Cle nouvelleCle){
        ArrayList<Cle> listeCle = this.cles.get(nouvelleCle.getElementCle());
        System.out.println("Le joueurs avait "+listeCle.size());

        if(listeCle ==null){
            System.out.println("Premiere cle de type ..");
            ArrayList<Cle> temp=new ArrayList<Cle>();
            temp.add(nouvelleCle);
            this.cles.put(nouvelleCle.getElementCle(),temp);


        }else{
            listeCle.add(nouvelleCle);
            System.out.println("Le joueurs a maintenat "+listeCle.size());

        }


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
}

