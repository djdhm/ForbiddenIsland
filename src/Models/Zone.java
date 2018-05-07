package Models;

import TP.Observable;
import Views.New.Graphiques;

public class Zone extends Observable{

    private EtatZone situationZone;
    public Zone(){
        this.situationZone= EtatZone.NORMAL;

    }

    public EtatZone getSituationZone(){
        return this.situationZone;
    }

    public void setSituationZone(EtatZone etat){
        this.situationZone=etat;
        notifyObservers();
    }

    public void innoderZone(){
       situationZone=situationZone.getSuivant(); notifyObservers();
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


}
