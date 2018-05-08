package Models;

import TP.Observable;
import javafx.geometry.Pos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Partie extends Observable {

    private HashMap<ElementArtefact ,Boolean> tresorTrouve;
    private int cpt=0;
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
        tresorTrouve=new HashMap<ElementArtefact, Boolean>();

        this.paquqetCarteCle=new PaquetRechercheCle();
        this.paquetCarteZone=new PaquetCarteZone();

    }
    public Partie(ArrayList<Joueur> joueurs){
        grille=new Grille();
        tresorTrouve=new HashMap<ElementArtefact, Boolean>();

        this.joueurs= joueurs;
        this.joueurActuel=this.joueurs.get(0);
        this.paquqetCarteCle=new PaquetRechercheCle();
        this.paquetCarteZone=new PaquetCarteZone();

    }
    public void initialiserPartie(){
        grille.initialiserGrille();

        paquetCarteZone.initialisationPaquet(this);
        paquqetCarteCle.initialisationPaquet(this);
        joueursEnvoles=new ArrayList<>();

        joueurActuel=joueurs.get(0);
        this.actionRestantes=3;

    }

    public void  tourSuivant(){
        for (Joueur j:joueurs
             ) {
            if(j.getPosition().getSituationZone().equals(EtatZone.SUBMERGEE)){

                ArrayList<Zone> zonesfuites=this.grille.getZoneAdjacentes(joueurActuel.getPosition());
                if(zonesfuites.size()!=0){
                    j.setPosition(zonesfuites.get(0));
                }
            }else{

            }
        }
        for(Zone e:        grille.getZoneAdjacentes(joueurActuel.getPosition())){
            System.out.println("Changement d'etat de la celule vers non selectionne"+e);
            if(e!=null){
                e.setTypeSelection(0);
            }
        }
        this.actionRestantes=3;
        joueurActuel.setTour(false);
        cpt=0;
        joueurActuel=joueurs.get((joueurs.indexOf(joueurActuel)+1)%joueurs.size());

        while (joueurActuel.getPosition().getSituationZone().equals(EtatZone.SUBMERGEE) && joueurs.size()>0){
            joueurActuel=joueurs.get((joueurs.indexOf(joueurActuel)+1)%joueurs.size());
            joueurs.remove(joueurActuel);
            cpt++;
        }


        joueurActuel.setTour(true);
        joueurActuel.getInventaire().ajouterCle(new Cle(ElementArtefact.FEU));
        notifyObservers();
    }

    public boolean partieGagne(){
        for (ElementArtefact element :ElementArtefact.values()
             ) {
            if(!tresorTrouve.containsKey(ElementArtefact.AIR)){
                return false;
            }

        }

        return  joueurs.size()==joueursEnvoles.size() ;

    }
    public boolean partiePerdu(){
        if(grille.getHeliport().getSituationZone()==EtatZone.SUBMERGEE){

            return true;

        }
        if(joueurs.size()==0){
            return  true;
        }
        if(cpt==3) return true;
        return false;
    }
    public void noyerJoueur(Joueur j){
        this.joueursEnvoles.remove(j);
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

    public void envolerJoueur(Joueur x) {
        joueurs.remove(x);
        joueursEnvoles.add(x);
        notifyObservers();

    }
}
