package Models;

import TP.Observable;
import Views.New.Graphiques;

import java.util.ArrayList;

public class Zone extends Observable{

    private ArrayList<Joueur> joueurs;
    private EtatZone situationZone;
    private int typeSelection;
    public Zone(){
        joueurs=new ArrayList<>();
        this.situationZone= EtatZone.NORMAL;
        this.typeSelection=0;
    }

    public EtatZone getSituationZone(){
        return this.situationZone;
    }

    public void setSituationZone(EtatZone etat){
        this.situationZone=etat;
        notifyObservers();
    }

    public void innoderZone(){
       situationZone=situationZone.getSuivant();
       notifyObservers();
    }

    public void  assecherZone(){

        if(situationZone==EtatZone.SUBMERGEE){
            System.out.print("La case ne peut pas etre asseche ...");
        }
        else{
            situationZone=EtatZone.NORMAL;
        }
        notifyObservers();
    }

    public void removeJoueur(Joueur j){
        this.joueurs.remove(j);
        notifyObservers();
    }
    public void ajouterJoueur(Joueur j){
        this.joueurs.add(j);
        notifyObservers();

    }
    public String getImageSituation(int i,int j){
        // Affichage de la zone en etat normal
        if(situationZone.equals(EtatZone.NORMAL)){
            return Graphiques.ImageZone[i][j];
        }
        else if(situationZone.equals(EtatZone.INNONDE)){
            return Graphiques.ImageZoneInnonder[i][j];
        }
        else{
            return "./res/images/zones/extra/Tile_Flood_Water@2x.png";
        }
    }

    @Override
    public String toString() {
        return "Zone "+situationZone.toString();

    }


    public int getTypeSelection() {
        return typeSelection;
    }

    public void setTypeSelection(int typeSelection) {
        this.typeSelection = typeSelection;
        notifyObservers();
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }
}
