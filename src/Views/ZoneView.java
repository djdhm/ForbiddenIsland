package Views;

import Models.Grille;
import Models.Joueur;
import Views.New.Graphiques;
import Views.New.JPanelImage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ZoneView extends JPanel {

    private GridLayout grille=new GridLayout(6,6,10,10);
    private JPanelImage[][] listeZones;
    public ZoneView(){
        super();

        this.setLayout(grille);
        listeZones=new JPanelImage[6][6];
        Dimension taille=new Dimension(660,660);
        setMinimumSize(taille);
        setPreferredSize(taille);
        setMaximumSize(taille);
        this.setVisible(true);
    }
    private void loadZones(){

    }
    public void loadZones(Grille grille){
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(grille.getZone(i,j)!=null){
                    JPanelImage image=new JPanelImage(Graphiques.ImageZone[i][j]);
                    listeZones[i][j]=image;
                    this.add(image);
                }else{
                    this.add(new JPanel());
                }
            }
        }
    }
    public void innonderZone(int x,int y){
        this.listeZones[x][y]=new JPanelImage("./res/images/zones/Breakers Bridge_flood@2x.png");
        this.remove(x*6+y);
        this.add(listeZones[x][y],x*6+y);
        this.repaint();
    }

    public void selectionZone(int x,int y){

        this.listeZones[x][y].setBorder(Graphiques.ACTIVE_BORDER_SELECTED);
        this.remove(x*6+y);
        this.add(listeZones[x][y],x*6+y);
        this.repaint();
    }


    public void positionnerJoueur(Joueur j,int x,int y){
            listeZones[x][y].ajouterJoueur(j);

    }
}