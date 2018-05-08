package Views;

import Controllers.ZoneController;
import Models.*;
import TP.Observer;
import Views.New.CleView;
import Views.New.Graphiques;
import Views.New.JPanelImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ZoneView extends JPanel implements Observer{

    private  Partie partie;
    private Grille zones;
    private boolean isSelected;
    private MouseListener mouseListener;
    private GridLayout grille=new GridLayout(6,6,10,10);
    private JPanelImage[][] listeZones;
    public ZoneView(Partie partie){
        super();
        this.partie=partie;
        this.setLayout(grille);
        listeZones=new JPanelImage[6][6];
        Dimension taille=new Dimension(660,660);
        setMinimumSize(taille);
        setPreferredSize(taille);
        setMaximumSize(taille);
        this.setVisible(true);
    }


    public void loadZones(Grille grille){
        setVisible(false);
        Zone zone;
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                zone=grille.getZone(i,j);
                if(zone!=null){
                    zone.addObserver(this);

                    JPanelImage image=new JPanelImage(zone,zone.getImageSituation(i,j));
                    if(zone instanceof AssocieElement){
                        image.setArtefact(((AssocieElement) zone).getElement());
                    }
                    listeZones[i][j]=image;
                    zone.addObserver(image);
                    new ZoneController(image,zone,partie);
                    this.add(image);
                }else{
                    this.add(new JPanel());
                }
            }
        }
        setVisible(true);
    }
    public void mettreaJjourZones(Grille grille){
        setVisible(false);
        Zone zone;
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                zone=grille.getZone(i,j);
                if(zone!=null){

                    //JPanelImage image=new JPanelImage(zone,zone.getImageSituation(i,j));

                    //listeZones[i][j]=image;
                    listeZones[i][j].setImage(zone.getImageSituation(i,j));
                    if(zone instanceof AssocieElement){
                        listeZones[i][j].setArtefact(((AssocieElement) zone).getElement());
                    }

//                    this.add(image);
                }
            }
        }
        setVisible(true);
    }
    public void innonderZone(int x,int y){
            listeZones[x][y].innonderZone(Graphiques.ImageZoneInnonder[x][y]);
        }

    public void selectionZone(int x,int y){

//        this.listeZones[x][y].setTypeSelection(1);
        // Selection pour deplacement
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
        System.out.println("Mise a jour des images ");
       // loadZones(this.partie.getGrille());
        mettreaJjourZones(this.partie.getGrille());
        //repaint();
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void setMouseListener(MouseListener mouseListener) {
        this.mouseListener = mouseListener;
    }
    public void setPartie(Partie partie){
        this.partie=partie;
    }

}
