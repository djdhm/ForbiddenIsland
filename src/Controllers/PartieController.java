package Controllers;

import Models.*;
import Views.Board;
import Views.New.CleView;
import Views.New.DregerButton;
import Views.ZoneView;

import javax.swing.*;
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
        if(partie.partiePerdu()){
            plateau.afficherMessagePerte();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source=((DregerButton)e.getSource()).getText();
        System.out.println(source);


        switch (source){

            case "FIN DE TOUR":
                System.out.println("Fin tour de jouer ...");
                this.partie.selectionnerCarteZone();
                while(this.partie.getNombreAction()>0) this.partie.decNombreAction();
                this.partie.deselectionnerZone();
                ((DregerButton)e.getSource()).setEnabled(false);
            break;
            case "SE DEPLACER":
                System.out.println("Se deplacer...");
                this.partie.entourerZoneDeplacement();

                break;
            case "ASSECHER ZONE":
                System.out.println("Assecher une zone ...");
                this.partie.entourerZoneAssecher();
                this.partie.getJoueurActuel().recevoirCle(new Cle(ElementArtefact.FEU));
                this.partie.getJoueurActuel().recevoirCle(new Cle(ElementArtefact.FEU));
                this.partie.getJoueurActuel().recevoirCle(new Cle(ElementArtefact.FEU));
                this.partie.getJoueurActuel().recevoirCle(new Cle(ElementArtefact.FEU));
                this.partie.getJoueurActuel().recevoirCle(new Cle(ElementArtefact.FEU));
                break;
            case "RECUPERER UN TRESOR":
                System.out.println("Recuperer un tresor ...");
                Joueur j=this.partie.getJoueurActuel();
                Artefact elementArtefact=((AssocieElement)j.getPosition()).getElement();
                if(j.avoirToutesCles(elementArtefact.getElement())){
                    ((AssocieElement)j.getPosition()).recupererTresor(j);
                    System.out.println("Vous avez recuperer le tresor");
                    partie.getJoueurActuel().retirerCle(elementArtefact.getElement());
                    partie.ajouterTresor(elementArtefact);
                    JOptionPane.showMessageDialog(zoneView,"Vous avez recupere le tresor de type"+elementArtefact.getElementArtefact());

                }else{
                    System.out.println("Vous avez pas les cles necessaire");
                    JOptionPane.showMessageDialog(zoneView,"Vous n'avez pas assez de cles pour recuperer ce Tresor ");
                }
                    break;
            case "S'ENVOLER":
                System.out.println("S'envoler ...");
                Joueur x=this.partie.getJoueurActuel();
                if(x.getPosition() instanceof Heliport){
                    x.setPosition(null);
                    partie.envolerJoueur(x);
                    this.partie.tourSuivant();
                    this.partie.deselectionnerZone();
                    JOptionPane.showMessageDialog(zoneView,"Vous vous etes enfuis de l'ile !!");


                    if(partie.partieGagne()){
                        plateau.afficherMessageVictoire();
                    }
                }

                break;

        }
    }
}
