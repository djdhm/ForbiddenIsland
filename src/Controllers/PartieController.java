package Controllers;

import Models.Joueur;
import Models.Partie;
import Views.ZoneView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PartieController {

    Partie partie;
    ZoneView zoneView;

    public void initialiserPartie(ArrayList<Joueur> joueurs){

        zoneView=new ZoneView();
        partie=new Partie(joueurs);
        partie.initialiserPartie();
        zoneView.loadZones(partie.getGrille());
    }
    public ZoneView getZoneView(){
        return zoneView;
    }

    public void  positionnerJoueurs(Joueur j,int x,int y){

        this.partie.deplacerJoueur(j,x,y);
        this.zoneView.positionnerJoueur(j,x,y);

    }

    public void selectionZone(int x,int y){
        this.zoneView.selectionZone(x,y);

    }
    public void innonderZone(int x,int y){
        zoneView.innonderZone(x,y);
    }

}
