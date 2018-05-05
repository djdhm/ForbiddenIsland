package Views.New;


import Models.Joueur;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class JPanelImage extends JPanel {
    String image;
    ArrayList<Joueur> joueurs;
    public JPanelImage(String path)
    {
        super();
        joueurs=new ArrayList<>();
        this.setSize(new Dimension(200,200));
        this.image=path;
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
                System.out.println("Affichage des joueurs ");
                g.drawImage(jImage,(int) getSize().getWidth()/3+33*k, (int) getSize().getHeight()/2,30,45, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ajouterJoueur(Joueur j) {
        this.joueurs.add(j);
        this.repaint();
    }
}
