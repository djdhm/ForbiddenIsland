package Models;

import TP.Observable;

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
        zones[0][2]=new Zone();
        zones[0][3]=new Zone();
        zones[5][2]=new Zone();
        zones[5][3]=new Zone();
        zones[2][0]=new Zone();
        zones[3][0]=new Zone();
        zones[2][5]=new Zone();
        zones [3][5]=new Zone();

    }

    public  Zone getZone(int i,int j){
        return zones[i][j];

    }
    public Zone getHeliport(){
        return zones[2][2];
    }






}
