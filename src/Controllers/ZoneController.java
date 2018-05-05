package Controllers;


import Models.Grille;
import Views.New.Graphiques;
import Views.New.JPanelImage;
import Views.ZoneView;

import javax.swing.*;
import java.awt.*;

public class ZoneController {

    ZoneView zoneView;
    Grille grille;
    public ZoneController(){
        zoneView=new ZoneView();
        grille=new Grille();
        grille.initialiserGrille();

    }
    public ZoneController(ZoneView zone,Grille grille){
        this.grille=grille;
        this.zoneView=zone;
    }

    public void initAffichage(){
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(grille.getZone(i,j)==null){
                    zoneView.add(new JPanel());
                }else{
                    zoneView.add(new JPanelImage(Graphiques.ImageZone[i][j]));
                }
            }
        }
    }
    public void innonderZone(int x,int y){
        this.zoneView.innonderZone(2,2);
        this.zoneView.selectionZone(2,2);

    }





}
