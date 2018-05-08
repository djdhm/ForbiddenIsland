package Models;

import TP.Observable;

import java.awt.*;
import java.util.ArrayList;

public class Grille extends Observable  {

    Zone[][] zones;
    PaquetRechercheCle paquetcle;
    public Grille(){
        this.zones=new Zone[6][6];
    }
    public void initialiserGrille(){

        for(int i=1;i<5;i++){
            for(int j=1;j<5;j++){
                zones[i][j]=new Zone();
            }
        }

        zones[2][1]=new Heliport();
        zones[0][3]=new Zone();
        zones[5][2]=new Zone();
        zones[5][3]=new Zone();
        zones[2][0]=new Zone();
        zones[2][5]=new Zone();
        zones[3][5]=new Zone();
        zones[0][2]=new AssocieElement(Artefact.getArtefactElement(ElementArtefact.FEU));
        zones[3][0]=new AssocieElement(Artefact.getArtefactElement(ElementArtefact.AIR));
        zones[2][2]=new AssocieElement(Artefact.getArtefactElement(ElementArtefact.TERRE));
        zones[2][4]=new AssocieElement(Artefact.getArtefactElement(ElementArtefact.EAU));
        zones[3][1]=new AssocieElement(Artefact.getArtefactElement(ElementArtefact.FEU));
        zones[3][5]=new AssocieElement(Artefact.getArtefactElement(ElementArtefact.EAU));
        zones[4][3]=new AssocieElement(Artefact.getArtefactElement(ElementArtefact.AIR));


    }

    public  Zone getZone(int i,int j){
        return zones[i][j];

    }
    public Zone getHeliport(){
        return zones[2][2];
    }

    public ArrayList<Zone> getZoneAdjacentes(Zone zone){
            ArrayList<Zone> zonesAdjacentes =new ArrayList<>();
            Dimension position=chercherZone(zone);
            if(zones[position.width-1][position.height]!=null) zonesAdjacentes.add(zones[position.width-1][position.height]);
            if(zones[position.width+1][position.height]!=null) zonesAdjacentes.add(zones[position.width+1][position.height]);
            if(zones[position.width][position.height-1]!=null) zonesAdjacentes.add(zones[position.width][position.height-1]);
            if(zones[position.width][position.height+1]!=null) zonesAdjacentes.add(zones[position.width][position.height+1]);

            return zonesAdjacentes;

    }


    public Dimension chercherZone(Zone zone){
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(this.zones[i][j]==zone){
                    return new Dimension(i,j);
                }
            }
        }
        System.out.println("Zone introuvable...");
        return null;
    }


}
