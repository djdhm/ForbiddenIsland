package Views;

import Models.*;
import TP.Observer;
import Views.New.CleView;
import Views.New.Graphiques;
import Views.New.JPanelImage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ZoneView extends JPanel implements Observer{

    private Grille zones;
    private boolean isSelected;
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


    public void loadZones(Grille grille){
        Zone zone;
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                zone=grille.getZone(i,j);
                if(zone!=null){
                    zone.addObserver(this);
                    JPanelImage image=new JPanelImage(zone.getImageSituation(i,j));
                    if(zone instanceof AssocieElement){
                        image.setArtefact(((AssocieElement) zone).getElement());
                    }
                    listeZones[i][j]=image;
                    this.add(image);
                }else{
                    this.add(new JPanel());
                }
            }
        }
    }
    public void innonderZone(int x,int y){
            listeZones[x][y].innonderZone(Graphiques.ImageZoneInnonder[x][y]);
        }

    public void selectionZone(int x,int y){

        this.listeZones[x][y].setBorder(Graphiques.ACTIVE_BORDER_SELECTED);
        this.remove(x*6+y);
        this.add(listeZones[x][y],x*6+y);
        this.repaint();
    }
    public void ajouterCle(int pos,JPanelImage imageCle){
        System.out.println("Ajout d'une cle au joueur : "+pos);

    }


    public void positionnerJoueur(Joueur j,int x,int y){
            listeZones[x][y].ajouterJoueur(j);
    }

    public void retirerJoueur(Joueur j ,int x,int y){
        if(x>0 && y>0){
            listeZones[x][y].retirerJoueur(j);
            System.out.println("Kayen le joueur");

        }
    }


    @Override
    public void update() {
        this.removeAll();
        System.out.println("Mise a jour des images ");
        this.loadZones(zones);
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
