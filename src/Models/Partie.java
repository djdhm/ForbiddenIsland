package Models;

import TP.Observable;
import javafx.geometry.Pos;

import java.awt.*;
import java.util.ArrayList;

public class Partie extends Observable {

    static Dimension PositionDepart[]={
        new Dimension(2,2),
        new Dimension(4,4),
        new Dimension(1,3),
        new Dimension(4,4)
    };
    int actionRestantes;
    Grille grille;
    private ArrayList<Joueur> joueurs;
    private Joueur joueurActuel;
    ArrayList<Joueur> joueursEnvoles;
    private PaquetRechercheCle paquqetCarteCle;
    private PaquetCarteZone paquetCarteZone;


    public Partie(Grille grille,ArrayList<Joueur> joueurs){
        this.joueurs=joueurs;
        this.actionRestantes=3;
        this.grille=grille;

        this.paquqetCarteCle=new PaquetRechercheCle();
        this.paquetCarteZone=new PaquetCarteZone();

    }
    public Partie(ArrayList<Joueur> joueurs){
        grille=new Grille();
        this.joueurs= joueurs;
        this.joueurActuel=this.joueurs.get(0);
        joueurActuel.recevoirCle(new Cle(ElementArtefact.FEU));
        this.paquqetCarteCle=new PaquetRechercheCle();
        this.paquetCarteZone=new PaquetCarteZone();

    }
    public void initialiserPartie(){
        grille.initialiserGrille();
        paquetCarteZone.initialisationPaquet(this);
        paquqetCarteCle.initialisationPaquet(this);

        joueurActuel=joueurs.get(0);
        this.actionRestantes=3;

    }

    public void  tourSuivant(){
        for(Zone e:        grille.getZoneAdjacentes(joueurActuel.getPosition())){
            System.out.println("Changement d'etat de la celule vers non selectionne"+e);
            if(e!=null){
                e.setTypeSelection(0);
            }
        }
        this.actionRestantes=3;
        joueurActuel.setTour(false);
        joueurActuel=joueurs.get((joueurs.indexOf(joueurActuel)+1)%joueurs.size());
        joueurActuel.setTour(true);
        joueurActuel.getInventaire().ajouterCle(new Cle(ElementArtefact.FEU));
        notifyObservers();
    }

    public boolean partieGagne(){
        return  joueurs.size()==joueursEnvoles.size();
    }
    public boolean partiePerdu(){
        if(grille.getHeliport().getSituationZone()==EtatZone.SUBMERGEE){

            return true;
        }
        if(joueurs.size()==0){
            return  true;
        }
        return false;
    }

    public  Grille getGrille(){
        return this.grille;
    }

    public void  deplacerJoueur(Joueur j,int x,int y){

        j.setPosition(grille.getZone(x,y));


    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }
    public int idJoueurActuel(){
        return joueurs.indexOf(joueurActuel);
    }

    public Joueur getJoueurActuel() {
        return joueurActuel;

    }
    public String getNomJoueurActuel(){
//        System.out.println("Joueur Actuel "+this.joueurActuel.getPseudo());
//        return this.joueurActuel.getPseudo();
        return joueurActuel.getPseudo();
    }

    public int getNombreAction() {
        return actionRestantes;
    }
    public void decNombreAction(){
        this.actionRestantes--;

        notifyObservers();
    }

    public void entourerZoneAssecher(){
        for(Zone z:grille.getZoneAdjacentes(joueurActuel.getPosition())){
            if(z.getSituationZone().equals(EtatZone.INNONDE)){
                z.setTypeSelection(2);
            }else{
                z.setTypeSelection(0);
            }
        }
    }
    public  void deselectionnerZone(){
        for(Zone z:grille.getZoneAdjacentes(joueurActuel.getPosition())){
                z.setTypeSelection(0);
        }
    }

    public void entourerZoneDeplacement() {
        for(Zone z:grille.getZoneAdjacentes(joueurActuel.getPosition())){
            if(!z.getSituationZone().equals(EtatZone.SUBMERGEE)){
                z.setTypeSelection(1);
            }
            else{
                z.setTypeSelection(0);
            }
        }
    }

    public void selectionnerCarteZone() {
        this.paquetCarteZone.basculerSelection();
    }
    public void selectionnerCarteCle(){
        this.paquqetCarteCle.basculerSelection();
    }

    public PaquetCarteZone getPaquetCarteZone() {
        return paquetCarteZone;
    }

    public PaquetRechercheCle getPaquqetCarteCle() {
        return paquqetCarteCle;
    }
}
