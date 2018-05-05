package Controllers;

import Models.Joueur;
import Models.Partie;
import Views.ZoneView;

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
}
