package Controllers;

import Models.Joueur;
import Models.Partie;
import Models.Zone;
import Views.Board;
import Views.New.CleView;
import Views.ZoneView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PartieController {

    Partie partie;
    Board plateau;
    ZoneView zoneView;
    public Partie initialiserPartie(ArrayList<Joueur> joueurs){
        zoneView=new ZoneView();
        zoneView=plateau.getZone();
        partie=new Partie(joueurs);
        partie.initialiserPartie();
        zoneView.loadZones(partie.getGrille());
        return partie;
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
