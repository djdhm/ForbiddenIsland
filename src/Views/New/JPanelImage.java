package Views.New;


import Models.Artefact;
import Models.Joueur;
import Models.Zone;
import TP.Observer;
import sun.java2d.loops.FillRect;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class JPanelImage extends JPanel implements Observer {
    private String image;
    private Zone zone;
    ArrayList<Joueur> joueurs;
    private Artefact artefact;
    private MouseListener mouseListener;
    public JPanelImage(String path)
    {
        super();
        joueurs=new ArrayList<>();
        this.setSize(new Dimension(200,200));
        this.image=path;
    }
    public JPanelImage(Zone zone,String path){
        super();
        joueurs=new ArrayList<>();
        this.setSize(new Dimension(200,200));
        this.image=path;
        this.zone=zone;
        zone.addObserver(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            BufferedImage bImage = ImageIO.read(new File( image));
            BufferedImage jImage ;
            g.drawImage(bImage, 2, 2, (int) getSize().getWidth(), (int) getSize().getHeight(), this);
           for(int k=0;k<joueurs.size();k++) {
                jImage= ImageIO.read(new File(Graphiques.Pions[joueurs.get(k).getId()]));
                System.out.println("Affichage des joueurs X:"+32*(int)(k%2) +" Y:"+ (getSize().getHeight()/2-40*(k/2)));
                g.drawImage(jImage,32*(k%2), (int) getSize().getHeight()/2-40*(int)(k/2),28,40, this);

            }
            if(artefact!=null){
                jImage= ImageIO.read(new File("./res/images/tresors/"+artefact.getElementArtefact()+".png"));
                g.drawImage(jImage,60, 8,28,40, this);
            }

            if(zone!=null){

               switch (zone.getTypeSelection()){
                   case 0:
                       setBorder(Graphiques.INACTIVE_BORDER);
                    break;
                   case 1:
                       setBorder(Graphiques.ACTIVE_BORDER_SELECTED);
                       break;
                   case 2:
                       setBorder(Graphiques.ACTIVE_BORDER_SHORE_HOVER);
                       break;

               }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ajouterTresor(Tresor tresor){

    }

    public void ajouterJoueur(Joueur j) {
        this.joueurs.add(j);
        this.repaint();
    }
    public void retirerJoueur(Joueur j){
        System.out.println("Retirer un joueur ...");
        this.joueurs.remove(j);
        repaint();

    }
    public void innonderZone(String path){
        image=path;
        this.repaint();
    }

    public void setArtefact(Artefact artefact) {
        this.artefact = artefact;
        this.repaint();
    }

    @Override
    public void update() {
        this.joueurs.removeAll(this.joueurs);
        for (Joueur k:
             zone.getJoueurs()) {
            this.joueurs.add(k);
            System.out.println("Ajout des joueurs");
        };

        System.out.println("Affichage de la zone a nouveau");
        repaint();
    }



    public void ajouterListenerSouris(MouseListener mouseListener) {
        this.mouseListener = mouseListener;
        this.addMouseListener(mouseListener);
    }
}
