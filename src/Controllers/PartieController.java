package Controllers;

import Models.Joueur;
import Models.Partie;
import Models.Zone;
import Views.Board;
import Views.New.CleView;
import Views.New.DregerButton;
import Views.ZoneView;

import javax.swing.text.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PartieController implements ActionListener {

    Partie partie;
    Board plateau;
    ZoneView zoneView;
    public  PartieController(Partie partie,Board board){
            this.partie=partie;
            this.plateau=board;
            this.partie.addObserver(plateau);
    }
    public Partie initialiserPartie(ArrayList<Joueur> joueurs){
        partie.initialiserPartie();
        zoneView=new ZoneView(this.partie);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String source=((DregerButton)e.getSource()).getText();
        System.out.println(source);

        switch (source){
            case "FIN DE TOUR":
                System.out.println("Fin tour de jouer ...");
                this.partie.tourSuivant();
            break;
            case "SE DEPLACER":
                System.out.println("Se deplacer...");
                this.partie.decNombreAction();
                this.partie.entourerZoneDeplacement();
                break;
            case "ASSECHER ZONE":
                System.out.println("Assecher une zone ...");
                this.partie.entourerZoneAssecher();
        }
    }
}
