package Models;

public class Zone {

    private EtatZone situationZone;


    public EtatZone getSituationZone(){
        return this.situationZone;
    }

    public void setSituationZone(EtatZone etat){
        this.situationZone=etat;
    }

    public void innoderZone(){
       situationZone=situationZone.getSuivant();
    }

    public void  assecherZone(){

        if(situationZone==EtatZone.SUBMERGEE){
            System.out.print("La case ne peut pas etre asseche ...");
        }
        else{
            situationZone=EtatZone.NORMAL;
        }
    }

    @Override
    public String toString() {
        return "Zone "+situationZone.toString();

    }
}
